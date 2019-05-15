/*
 * The MIT License
 *
 * Copyright 2019 2098325.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package edu.eci.arsw.cartmode.controllers;

import edu.eci.arsw.cartmode.model.Jugador;
import edu.eci.arsw.cartmode.persistence.MongoDBTest;
import edu.eci.arsw.cartmode.services.CartModeException;
import edu.eci.arsw.cartmode.services.CartModeServices;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
 * @author 2098325
 */

@RestController
@RequestMapping(value = "/persistencia")
public class CartModeControllerPersistence {
    
    @Autowired
    private  MongoDBTest mgbd;
/**
 * Este metodo ingresa en la base de datos el nombre del jugador y su respectivo
 * puntaje.
 * @param nombre Nombre del jugador.
 * @param puntaje Puntahe de jugador.
 * @throws CartModeException 
 */
    @RequestMapping(method = RequestMethod.POST, path = "/almacenar/{nombre}/{puntaje}")
    public void addDataBaseMongoBD(@PathVariable String nombre, @PathVariable String puntaje) throws CartModeException {
        mgbd.insertData(nombre, puntaje);
    }
   /**
    * Retorna todos los jugadores que se encuentren almacenados en la base de datos.
    * @return ResponseEntity<?>  Con la representacion en String de todos 
    * los jugadores almacenados en la base de datos.
    */ 
    @GetMapping("/mostrar")
    public ResponseEntity<?> getAllJugadoresBySala() {
        mgbd.findAndPrintData();
        return new ResponseEntity<>(mgbd.getRespuesta(), HttpStatus.ACCEPTED);
    }
    
}
