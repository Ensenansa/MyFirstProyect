/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.carmode.stomp;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

/**
 *
 * @author 2098325
 */

@Controller
public class GreetingController {
    
    
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(Greeting nivel)throws Exception{
        Thread.sleep(1000);
        //
        //String temp= Integer.toString();
        return new Greeting("Este es el nivel"+HtmlUtils.htmlEscape(nivel.getContent()));
    
    }
    
}
