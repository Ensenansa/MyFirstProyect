/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.cartmode.model;

/**
 *
 * @author cesar
 */
public class Carta {
    
    
    private String dato;
    private boolean bloqueado;
    private Integer nivel;
    
    public Carta(String dato, Integer nivel){
        this.dato=dato;
        this.bloqueado=false;
        this.nivel=nivel;
    }
    
    public Integer getNivel(){
        return nivel;
    }
    public void setNIvel(Integer nivel){
        this.nivel=nivel;
    
    }
    
    
    
}
