/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.cartmode.model;

import java.util.List;

/**
 *
 * @author cesar
 */
public class Sala {
    private Jugador jugadorAnfrition;
    private List<Jugador> jugadores;
    private Integer id;
    private Boolean listo;
    private Integer nivel;
    /**
     * 
     */
    public Sala() {
    }  
    /**
     * 
     * @param id
     * @param jugadores
     * @param jugadorAnfrition
     * @param nivel 
     */
    public Sala(Integer id, List<Jugador> jugadores, Jugador jugadorAnfrition, Integer nivel){
        this.id=id;
        this.jugadorAnfrition=jugadorAnfrition;
        this.jugadores=jugadores;        
        this.listo=false;
        this.nivel=nivel;
    }
    /**
     * 
     * @param nivel 
     */
    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }
    /**
     * 
     * @return 
     */
    public Integer getNivel() {
        return nivel;
    }
    /**
     * 
     * @param listo 
     */
    public void setListo(Boolean listo) {
        this.listo = listo;
    }
    /**
     * 
     * @return 
     */
    public Boolean getListo() {
        return listo;
    }  
    /**
     * 
     * @return 
     */
    public Integer getId() {
        return id;
    }
    /**
     * 
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }  
    /**
     * 
     * @return 
     */
    public Jugador getJugadorAnfrition() {
        return jugadorAnfrition;
    }
    /**
     * 
     * @return 
     */
    public List<Jugador> getJugadores() {
        return jugadores;
    }  
    /**
     * 
     * @param jugadorAnfrition 
     */
    public void setJugadorAnfrition(Jugador jugadorAnfrition) {
        this.jugadorAnfrition = jugadorAnfrition;
    }
    /**
     * 
     * @param jugadores 
     */
    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }
    /**
     * 
     * @return 
     */
    @Override
    public String toString() {      
        return "Sala{"+"id="+id+",jugadores="+jugadores.listIterator()+",nivel="+nivel+",jugadorAnfrition="+jugadorAnfrition+", listo="+listo+"}";
    }
}