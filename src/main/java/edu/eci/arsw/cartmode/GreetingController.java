package edu.eci.arsw.cartmode;

import edu.eci.arsw.cartmode.model.Carta;
import edu.eci.arsw.cartmode.model.Jugador;
import edu.eci.arsw.cartmode.model.Nivel;
import edu.eci.arsw.cartmode.model.Sala;
import edu.eci.arsw.cartmode.model.Tablero;
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

    private Integer id = 0;

    @Autowired
    CartModeServices cart;

    //valor y Posicion y  de la carta
    private Map<String, Integer> cartas = new ConcurrentHashMap<>();

    private List<String> valoresPareja = new CopyOnWriteArrayList<>();

    Stack<String> pila = new Stack<String>();
    //private List<String> pareja = new CopyOnWriteArrayList<>();

    //        stompClient.subscribe('/topic/jugador', function (player) {
    //showGreeting(JSON.parse(player.body).content);
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        //Thread.sleep(1000); // simulated delay
        cart.addPlayer(message.getName());
        return new Greeting("El jugador es, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }

    @MessageMapping("avisar.{numsala}")
    @SendTo("/topic/avisar")
    public String avisar(@DestinationVariable String numsala) throws Exception {

        System.out.println("nuevo anfitrion jugando, de sala " + numsala);

        int idsala = Integer.parseInt(numsala);
        Sala o = new Sala();
        cart.SetStade(idsala);
        o = cart.getSalaById(idsala);

        cart.iniciarPartida();
        return o.toString();

    }

    @MessageMapping("tablero.{numsala}")
    @SendTo("/topic/tablero")
    public String tablero(@DestinationVariable String numsala) throws Exception {

        System.out.println("Un nuevo tablero es entregado a la sala # : " + numsala);
        int idsala = Integer.parseInt(numsala);
        Sala o = new Sala();
        cart.SetStade(idsala);
        o = cart.getSalaById(idsala);
        Tablero aa = new Tablero();
        aa = cart.iniciarPartida(idsala, cart.getAllPlayersBySala(idsala), o.getTablero().getNivel());

        return aa.toString();
    }

    @MessageMapping("cart")
    public void CambioCarta(Carta ct) throws Exception {
        int temporal = -1;
        String Keytemporal = "";
        System.out.println("miremos la p* carta" + ct.getDato());
        System.out.println("miremos la posicin de carta" + ct.getPos());

        //Se implementara por Pilas
        if (pila.empty()) {
            pila.push(ct.getDato());
            Thread.sleep(2000);
        } else {
            Carta j = new Carta(pila.pop());
            if (ct.getDato().equals(j.getDato())) {
                valoresPareja.add(ct.getDato());
                System.out.println("enviamos pareja");
                msg.convertAndSend("/topic/parejas", valoresPareja);

            }

        }

        msg.convertAndSend("/topic/cart", ct);

    }

}
