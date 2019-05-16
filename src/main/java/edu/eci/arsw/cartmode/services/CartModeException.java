/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.cartmode.services;

/**
 *
 * @author cesar
 */
public class CartModeException extends Exception {

    /**
     * Esta funcion lanza una excepcion con el mensaje y la causa 
     * de la excepcion.
     * @param message String Del mensaje a mostrar.
     * @param cause Throwable Causa del mensaje.
     */
    public CartModeException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Esta funcion llama a la clase padre.
     * @param message String del mensaje a mostrar.
     */
    public CartModeException(String message) {
        super(message);
    }

}
