package edu.eci.arsw.cartmode;



import edu.eci.arsw.cartmode.model.Carta;
import edu.eci.arsw.cartmode.model.Jugador;
import edu.eci.arsw.cartmode.model.Nivel;
import edu.eci.arsw.cartmode.services.CartModeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {
    
    
     private Integer id=0;
    
    @Autowired
    CartModeServices cart;
    //        stompClient.subscribe('/topic/jugador', function (player) {
    //showGreeting(JSON.parse(player.body).content);
    
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        cart.addPlayer(message.getName());
        return new Greeting("El jugador es, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }

    //@MessageMapping("/sal")
    //@SendTo("/topic/sala")
    //public Greeting Sala(HelloMessage message) throws Exception {
    //    Thread.sleep(1000); // simulated delay
    //    return null;
    //}
    
    
    @MessageMapping("/cart")
    @SendTo("/topic/carta")
    //public Carta CambioCarta(@DestinationVariable String carta) throws Exception {
    public String CambioCarta(String carta) throws Exception {
        System.out.println("miremos "+carta);
        Thread.sleep(2000); // simulated delay
        cart.printt(carta);
        
        return "sipp";
    }
    
    
    
    
    /**
    @MessageMapping("/hello")
    @SendTo("/topic/jugador")
    public Jugador player(Jugador player) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Jugador("Este es el jugador, " + HtmlUtils.htmlEscape(player.getNickName())+ "!");
    }
    */
    
    
}
