package edu.eci.arsw.cartmode;

import edu.eci.arsw.cartmode.model.Carta;
import edu.eci.arsw.cartmode.model.CartaJavSc;
import edu.eci.arsw.cartmode.model.Jugador;
import edu.eci.arsw.cartmode.model.Sala;
import edu.eci.arsw.cartmode.persistence.MongoDBTest;
import edu.eci.arsw.cartmode.services.CartModeServices;
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
    private  MongoDBTest mgbd;
        
    private Integer jugadoress = 0;

    private Map<String, List<String>> valparejas = new ConcurrentHashMap<>();
    private Map<Integer, String> results = new ConcurrentHashMap<>();
    private Map<String, Stack<String>> cartas = new ConcurrentHashMap<>();
    private List<String> valoresPareja = new CopyOnWriteArrayList<>();
    private Stack<String> pila = new Stack<String>();

    @MessageMapping("/usu")
    public void greeting(HelloMessage message) throws Exception {
        cart.addPlayer(message.getName());
        int resp=cart.getIdSalaByPlayer(message.getName());
        msg.convertAndSend("/topic/usu", resp);        
    }

    @MessageMapping("avisar.{numsala}")
    @SendTo("/topic/avisar")
    public String avisar(@DestinationVariable String numsala) throws Exception {
        System.out.println("nuevo anfitrion jugando, de sala " + numsala);
        int idsala = Integer.parseInt(numsala);
        Sala o = new Sala();
        cart.SetStade(idsala);
        o = cart.getSalaById(idsala);        
        return o.toString();
    }

    @MessageMapping("iniciar")
    public void start() throws Exception {
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
  
    @MessageMapping("cart.{id}")
    public void CambioCarta(Carta ct, @DestinationVariable String id) throws Exception {
        List<String> temp = new CopyOnWriteArrayList<>();
        int players = cart.getAllPlayerInGame();
        int temporal = -1;
        String Keytemporal = "";                       
        
        System.out.println("Quien entra: "+ ct.getNombre());
        System.out.println("LA CARTA QUE ENTRA ES : "+ ct.getDato());
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
            cartas.remove(ct.getNombre());
            pila.push(ct.getDato());
            cartas.put(ct.getNombre(), pila);
            Thread.sleep(2000);
        } else {
            System.out.println("entro se hizo la pareja, tam de pila " + pila.size());
            System.out.println("-------------------------");
            Carta j = new Carta(pila.pop());
            if (ct.getDato().equals(j.getDato())) {
                System.out.println("-------------------------");
                temp.add(ct.getDato());
                cartas.remove(ct.getNombre());
                pila.clear();                
                Jugador f = cart.getPlayerByName(ct.getNombre());
                int cont = f.getPuntaje();               
                cont+=100;
                f.setPuntaje(cont);
                cart.setPlayerByName(f);
                cartas.put(ct.getNombre(), pila);
                System.out.println("enviamos pareja");
                System.out.println("QUIen hizo la pareja: "+ ct.getNombre());

                        
                System.out.println("-------------------------");
                valparejas.remove(id);
                valparejas.put(id, temp);
                //msg.convertAndSend("/topic/cart." + id, ct);
                msg.convertAndSend("/topic/parejas." + id, temp);
            }
        }
        msg.convertAndSend("/topic/cart." + id, ct);
    }

    
    
    
    @MessageMapping("cartt.{id}")
    public void IniciadorPartida(Carta ct, @DestinationVariable String id) throws Exception {
        
        cart.statedIdSala(Integer.parseInt(id));
        msg.convertAndSend("/topic/cartt." + id, "2");
    }
    @MessageMapping("level.{idd}")
    public void level(Jugador sjug, @DestinationVariable String idd) throws Exception {
        Boolean sies = true;
        Jugador jugadortemid = cart.getPlayerAnfiBySala(sjug.getSala());
        String tpJu = jugadortemid.getNickName();
        if (Integer.valueOf(sjug.getSala()) < 4) {
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

    @MessageMapping("result.{idd}")
    public void saveBD(@DestinationVariable String idd) throws Exception {
        System.out.println("--------------------");
        int punt=0;
        List<Jugador> temps=cart.getJugadoresByIdSala((Integer.parseInt(idd)));
        Jugador temp=new Jugador();
        for(Jugador te:temps){
            if(te.getPuntaje()>punt){
                punt=te.getPuntaje();
                temp.setNickName(te.getNickName());
                temp.setPuntaje(te.getPuntaje());            
            }
        }
        if(results.containsKey(Integer.parseInt(idd))){        
            System.out.println("Ya fue almacenado");
        }else{
            results.put(Integer.parseInt(idd), temp.getNickName());
            mgbd.insertData(temp.getNickName(),Integer.toString( temp.getPuntaje()));        
        }
        msg.convertAndSend("/topic/result." + idd, 99);
    }
}
