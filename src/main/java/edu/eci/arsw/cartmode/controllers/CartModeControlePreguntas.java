/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.cartmode.controllers;

import edu.eci.arsw.cartmode.model.Jugador;
import edu.eci.arsw.cartmode.services.CartModeException;
import edu.eci.arsw.cartmode.services.CartModeServices;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author cefa-dico-asus
 */
@RestController
@RequestMapping(value = "/preguntas")
public class CartModeControlePreguntas {
    
    @Autowired
    private CartModeServices cat;

    @RequestMapping(method = RequestMethod.GET, path = "/all")
    public ResponseEntity<?> getAllJQuestion() {
        try {
            return new ResponseEntity<>(cat.getListPreguntas(), HttpStatus.ACCEPTED);
        } catch (CartModeException ex) {
            Logger.getLogger(CartModeController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(method = RequestMethod.GET, path = "/one")
    public ResponseEntity<?> getAllOneQuestion() {
        try {
            return new ResponseEntity<>(cat.getPregunta(), HttpStatus.ACCEPTED);
        } catch (CartModeException ex) {
            Logger.getLogger(CartModeController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
        }
    }
    
}