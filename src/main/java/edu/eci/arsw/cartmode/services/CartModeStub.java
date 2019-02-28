/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.cartmode.services;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.stereotype.Service;

/**
 *
 * @author 2098325
 */
@Service
public class CartModeStub implements CartModeServices{
    private static final List<String> player;
    
    
    
    
    public CartModeStub() {
    }

    
    
    
    @Override
    public List<String> namePlayer() throws CartModeException {
        return player;
    }
    
    @Override
    public void addPlayer(String name) throws CartModeException {
        System.out.println("Agergaando"+name);
        player.add(name);
    }
    
    static{
    
    player= new CopyOnWriteArrayList<>();
    
    
    
    }


}
