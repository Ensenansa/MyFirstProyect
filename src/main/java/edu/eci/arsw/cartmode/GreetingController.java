package edu.eci.arsw.cartmode;

import edu.eci.arsw.cartmode.model.Carta;
import edu.eci.arsw.cartmode.model.Jugador;
import edu.eci.arsw.cartmode.model.Nivel;
import edu.eci.arsw.cartmode.model.Sala;
import edu.eci.arsw.cartmode.model.Tablero;
import edu.eci.arsw.cartmode.services.CartModeServices;
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

            System.out.println("nuevo anfitrion jugando, de sala "+numsala);

            int idsala = Integer.parseInt(numsala);
            Sala o = new Sala();
            cart.SetStade(idsala);
            //o=cart.get;
            o=cart.getSalaById(idsala);
            //cart.generateTblero();
            cart.iniciarPartida();
            //msg.convertAndSend("/topic/avisar." + o.toString());
            return o.toString();
            //return new String("El jugador es, " +"!")
    }
    
    
    @MessageMapping("tablero.{numsala}")
    @SendTo("/topic/tablero")
    public String tablero(@DestinationVariable String numsala) throws Exception {

            System.out.println("Un nuevo tablero es entregado a la sala # : "+numsala);
            int idsala = Integer.parseInt(numsala);
            Sala o = new Sala();
            cart.SetStade(idsala);
            o=cart.getSalaById(idsala);
            Tablero aa=new Tablero();
            aa=cart.iniciarPartida(idsala, cart.getAllPlayersBySala(idsala), o.getTablero().getNivel());
            
            return aa.toString();
    }

    //@MessageMapping("/cart")
    //@SendTo("/topic/carta")
    //public Carta CambioCarta(@DestinationVariable String carta) throws Exception {
    
    @MessageMapping("cart.{carta}")
    public void CambioCarta(Carta ct,@DestinationVariable String carta) throws Exception {
        System.out.println("miremos la p* carta" + ct.getDato());
        System.out.println("miremos que sala "+carta);
        
        msg.convertAndSend("/topic/cart."+carta,ct);

        
    }

}
