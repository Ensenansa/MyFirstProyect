/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.cartmode.controllers;

import edu.eci.arsw.cartmode.services.CartModeException;
import edu.eci.arsw.cartmode.services.CartModeServices;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author cesar
 */
@Service
//@CrossOrigin("*")
@RestController(value = "/jugadores")
public class CartModeController {

    @Autowired
    private CartModeServices cat;

    /**
     *
     * @return la pregunta de seleccion multiple como CopyOnWriteArrayList
     */
    @RequestMapping(method = RequestMethod.GET, path = "/preguntas/psm")
    public ResponseEntity<?> getJugadores() {
        try {
            return new ResponseEntity<>(cat.namePlayer(), HttpStatus.ACCEPTED);
        } catch (CartModeException ex) {
            Logger.getLogger(CartModeController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
        }
    }
}
