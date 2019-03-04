/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.cartmode.model.impl;

import edu.eci.arsw.cartmode.model.Carta;
import edu.eci.arsw.cartmode.model.Nivel;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author cesar
 */
//@Service
public class Nivel2 extends Nivel{

    public Nivel2(float tiempo, boolean hermafrodita, Tupla<Integer, Integer> tamaño, List<Carta> barajas) {
        super(tiempo, hermafrodita, tamaño, barajas);
    }

    
}
