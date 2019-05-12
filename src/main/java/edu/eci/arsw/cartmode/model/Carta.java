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
    private Integer pos;
    private String nombre;
/**
 * 
 */
    public Carta() {
    }
    /**
     * 
     * @param dato 
     */
    public Carta(String dato){
        this.dato=dato;
        this.pos=null;
    }
    /**
     * 
     * @param dato
     * @param pos 
     */
    public Carta(String dato, Integer pos){
        this.dato=dato;
        this.pos=pos;
    }  
    /**
     * 
     * @return 
     */
    public Integer getPos() {
        return pos;
    }
    /**
     * 
     * @param pos 
     */
    public void setPos(Integer pos) {
        this.pos = pos;
    }
    /**
     * 
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * 
     * @return 
     */
    public String getNombre() {
        return nombre;
    }  
    /**
     * 
     * @return 
     */
    public String getDato() {
        return dato;
    }
    /**
     * 
     * @param dato 
     */
    public void setDato(String dato) {
        this.dato = dato;
    }
    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        return "Carta{"+"dato="+dato+"pos="+pos+"nombre="+nombre+'}';
    }    
}
