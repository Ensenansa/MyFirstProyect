package edu.eci.arsw.cartmode;

import edu.eci.arsw.cartmode.model.Carta;
import edu.eci.arsw.cartmode.model.CartaJavSc;
import edu.eci.arsw.cartmode.model.Jugador;
import edu.eci.arsw.cartmode.model.Sala;
import edu.eci.arsw.cartmode.persistence.MongoDBTest;
import edu.eci.arsw.cartmode.services.CartModeServices;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import static jdk.nashorn.internal.objects.NativeArray.map;
import static jdk.nashorn.internal.objects.NativeError.printStackTrace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

    @Autowired
    SimpMessagingTemplate msg;
    @Autowired
    CartModeServices cart; //valor y Posicion y  de la carta    
    @Autowired
    private MongoDBTest mgbd;

    private Integer jugadoress = 0;

    private Map<Integer, Map<String, List<String>>> parejasJugador = new ConcurrentHashMap<>();

    private Map<String, List<String>> valparejas = new ConcurrentHashMap<>();
    private Map<Integer, String> results = new ConcurrentHashMap<>();
    private Map<String, Stack<String>> cartas = new ConcurrentHashMap<>();
    private List<String> valoresPareja = new CopyOnWriteArrayList<>();
    private Stack<String> pila = new Stack<String>();

    /**
     * Esta funcion sirve para retornar un entero el cual significa la sala a la
     * cual pertenece un jugador en especifico.
     *
     * @param message Repersenta el nombre del jugador.
     * @throws Exception
     */
    @MessageMapping("/usu")
    public void greeting(HelloMessage message) throws Exception {
        cart.addPlayer(message.getName());
        int resp = cart.getIdSalaByPlayer(message.getName());
        msg.convertAndSend("/topic/usu", resp);
    }

    /**
     * Esta funcion permite eliminar todas las parejas hechas por los jugadores
     * en niveles anteriores.Deja vacios todos los hasmap y listas usadas.
     *
     * @throws Exception
     */
    @MessageMapping("iniciar")
    public void start() throws Exception {
        parejasJugador.clear();
        cartas.clear();
        valoresPareja.clear();
        valparejas.clear();
        int players = cart.getAllPlayerInGame();
        List<Jugador> ju = cart.nameAlPlayer();
        int y = 0;
        for (Jugador h : ju) {
            cartas.put(h.getNickName(), new Stack<String>());
            y++;
        }
        jugadoress = players;
    }

    /**
     * Esta funcion recibe una carta y evalua si el jugador ha hecho una pareja
     * o no.
     *
     * @param ct Representa la carta enviada por el jugador.
     * @param id Representa el id de la sala asociada.
     * @throws Exception
     */
    @MessageMapping("cart.{id}")
    public void CambioCarta(Carta ct, @DestinationVariable String id) throws Exception {
        List<String> temp = new CopyOnWriteArrayList<>();
        int players = cart.getAllPlayerInGame();
        int temporal = -1;
        String Keytemporal = "";
        System.out.println("Quien entra: " + ct.getNombre());
        System.out.println("LA CARTA QUE ENTRA ES : " + ct.getDato());
        if (cartas.containsKey(ct.getNombre())) {
            pila = cartas.get(ct.getNombre());
        } else {
            System.out.println("algo ocurrio muy feo");
        }
        if (valparejas.containsKey(id)) {
            temp = valparejas.get(id);
        } else {
            valparejas.put(id, temp);
        } //Se implementara por Pilas
        if (pila.empty()) {
            if (!cartas.isEmpty()) {
                cartas.remove(ct.getNombre());
            }
            pila.push(ct.getDato());
            cartas.put(ct.getNombre(), pila);
            Thread.sleep(2000);
        } else {
            System.out.println("entro se hizo la pareja?, tam de pila " + pila.size());
            System.out.println("-------------------------");
            Carta j = new Carta(pila.pop());
            if (ct.getDato().equals(j.getDato())) {
                List<String> cartt = new ArrayList<String>();
                Map<String, List<String>> cartt2 = new ConcurrentHashMap<>();
                if (parejasJugador.containsKey(Integer.parseInt(id))) {
                    System.out.println("llegamos 2");
                    cartt2 = parejasJugador.get(Integer.parseInt(id));
                    if (cartt2.containsKey(ct.getNombre())) {
                        cartt = cartt2.get(ct.getNombre());
                        cartt.add(ct.getDato());
                    } else {
                        cartt.add(ct.getDato());
                    }
                    cartt2.remove(ct.getDato());
                    cartt2.put(ct.getNombre(), cartt);
                    parejasJugador.remove(Integer.parseInt(id));
                    parejasJugador.put(Integer.parseInt(id), cartt2);
                    System.out.println("llegamos 4");
                } else {
                    System.out.println("llegamos 5");
                    cartt.add(ct.getDato());
                    cartt2.put(ct.getNombre(), cartt);
                    parejasJugador.put(Integer.parseInt(id), cartt2);
                }
                System.out.println("-------------------------");
                temp.add(ct.getDato());
                cartas.remove(ct.getNombre());
                pila.clear();
                Jugador f = cart.getPlayerByName(ct.getNombre());
                int cont = f.getPuntaje();
                cont += 100;
                f.setPuntaje(cont);
                cart.setPlayerByName(f);
                cartas.put(ct.getNombre(), pila);
                System.out.println("enviamos pareja");
                System.out.println("QUIen hizo la pareja: " + ct.getNombre());
                System.out.println("-------------------------");
                valparejas.remove(id);
                valparejas.put(id, temp);
                //msg.convertAndSend("/topic/cart." + id, ct);
                msg.convertAndSend("/topic/parejas." + id, temp);
                //msg.convertAndSend("/topic/parejas." + id, getPxJ(Integer.parseInt(id)));
            }
        }
        msg.convertAndSend("/topic/cxj." + id, getPxJ(Integer.parseInt(id)));
        msg.convertAndSend("/topic/cart." + id, ct);
    }

    /**
     * Esta funcion retorna en una matriz (lista de lista) todas las parejas
     * hechas por cada jugador.
     *
     * @param id Representa la sala suscrita.
     * @return resp Que es una lista de listas con las parejas realizadas.
     */
    public List<List<String>> getPxJ(Integer id) {
        List<List<String>> resp = new ArrayList<List<String>>();
        Map<String, List<String>> prueba;
        if (parejasJugador.containsKey(id)) {
            prueba = parejasJugador.get(id);
            Iterator it = prueba.keySet().iterator();
            while (it.hasNext()) {
                String key = (String) it.next();
                //System.out.println("Clave: " + key + " -> Valor: " + map.get(key));
                resp.add(prueba.get(key));
            }
        }
        return resp;
    }

    /**
     * Esta funcion retorna las parejas hechas por cada jugador.
     *
     * @param id Representa la sala suscrita.
     * @throws Exception
     */
    @MessageMapping("cxj.{id}")
    public void CartaXJugador(@DestinationVariable String id) throws Exception {
        msg.convertAndSend("/topic/cxj." + id, getPxJ(Integer.parseInt(id)));
    }

    /**
     * Esta funcion sirve para poder iniciar una sala y que esta ya no se
     * encuentre disponible.   
     * @param id Representa la sala suscrita.
     * @throws Exception
     */
    @MessageMapping("cartt.{id}")
    public void IniciadorPartida(@DestinationVariable String id) throws Exception {
        cart.statedIdSala(Integer.parseInt(id));
        msg.convertAndSend("/topic/cartt." + id, "2");
    }
    /**
     * Esta funcion avisa a los demas jugadores de que otro a ingresado  la sala.
     * @throws Exception 
     */
    @MessageMapping("otro")
    public void OtroUsuario() throws Exception {
        msg.convertAndSend("/topic/otro", cart.nameAllPlayer());
    }

    /**
     * Esta funcion esta diseñada para subir el nivel del juego, pero solamente 
     * puede ser activada por el jugador anfitrion.
     * @param sjug El jugador que intenta elevar el nivel.
     * @param idd El id de la sala suscrita.
     * @throws Exception
     */
    @MessageMapping("level.{idd}")
    public void level(Jugador sjug, @DestinationVariable String idd) throws Exception {
        Boolean sies = true;
        System.out.println("MIREMOS QUE USUARIO LLEGA  primero: " + sjug.getNickName());
        Jugador jugadortemid = cart.getPlayerAnfiBySala(sjug.getSala());
        Sala saljs = cart.getSalaById(Integer.parseInt(idd));
        Boolean resp = cart.IsAnfitrion(Integer.parseInt(idd), sjug);
        System.out.println("MIREMOS QUE USUARIO LLEGA : " + jugadortemid.getNickName());
        System.out.println("QUE RESPUESTA NOS ARROJA: " + resp);
        String tpJu = jugadortemid.getNickName();
        if (Integer.valueOf(sjug.getSala()) < 4 && resp) {
            System.out.println("ELVEANDO");
            cart.levelOfSalaId(Integer.valueOf(sjug.getSala()));
        } else {
            System.out.println("sobre paso los limites de los niveles");
        }
        start();
        System.out.println("Empezndo el borrado");
        System.out.println("--------------------");
        msg.convertAndSend("/topic/uplevel." + idd, sjug.getSala());
    }

    /**
     * Esta funcion regresa los resultados de todos los jugadores.
     * @param idd El id de la sala suscrita-
     * @throws Exception
     */
    @MessageMapping("result.{idd}")
    public void saveBD(@DestinationVariable String idd) throws Exception {
        System.out.println("--------------------");
        int punt = 0;
        List<Jugador> temps = cart.getJugadoresByIdSala((Integer.parseInt(idd)));
        Jugador temp = new Jugador();
        for (Jugador te : temps) {
            if (te.getPuntaje() > punt) {
                punt = te.getPuntaje();
                temp.setNickName(te.getNickName());
                temp.setPuntaje(te.getPuntaje());
            }
        }
        if (results.containsKey(Integer.parseInt(idd))) {
            System.out.println("Ya fue almacenado");
        } else {
            results.put(Integer.parseInt(idd), temp.getNickName());
            mgbd.insertData(temp.getNickName(), Integer.toString(temp.getPuntaje()));
        }
        msg.convertAndSend("/topic/result." + idd, 99);
    }
}
