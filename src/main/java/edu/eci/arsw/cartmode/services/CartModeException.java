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
     *
     * @param message
     * @param cause
     */
    public CartModeException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     *
     * @param message
     */
    public CartModeException(String message) {
        super(message);
    }

}
