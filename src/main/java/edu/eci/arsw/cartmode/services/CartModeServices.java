/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.cartmode.services;

import java.util.List;

/**
 *
 * @author cesar
 */
public interface CartModeServices {
    
    
    
    public List<String> namePlayer() throws CartModeException;
    
    public void addPlayer(String name)throws CartModeException;
    
}
