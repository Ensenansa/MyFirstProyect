package edu.eci.arsw.cartmode.controllers;

import edu.eci.arsw.cartmode.model.CartaJavSc;
import edu.eci.arsw.cartmode.services.CartModeException;
import edu.eci.arsw.cartmode.services.CartModeServices;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author cesar
 */
@RestController
@RequestMapping(value = "/cartas")
public class CartModeCOntrolerCarts {
    
    @Autowired
    private CartModeServices cat;     
    /**
     * Esta funcion retorna una baraja de cartas segun el nivel que se le pase
     * como parametro.(va de 1 a 3).
     * @param nivel El parametro que definira el nivel de cartas a generar.
     * @return ResponseEntity Con la representacion de las cartas.
     */
    @RequestMapping(method = RequestMethod.GET, path = "/bara/{nivel}")
    public ResponseEntity<?> getAllPlayerByLevel(@PathVariable Integer nivel) {
        try {
            List<CartaJavSc> tempo=cat.GenerateDuplicadoBaraja(nivel);             
            return new ResponseEntity<>(tempo , HttpStatus.ACCEPTED);
        } catch (CartModeException ex) {
            Logger.getLogger(CartModeController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
        }
    }
}