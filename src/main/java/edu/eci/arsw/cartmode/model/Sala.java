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
    
    public Sala() {
    }       
    public Sala(Integer id, List<Jugador> jugadores, Jugador jugadorAnfrition, Integer nivel){
        this.id=id;
        this.jugadorAnfrition=jugadorAnfrition;
        this.jugadores=jugadores;        
        this.listo=false;
        this.nivel=nivel;
    }
    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }
    public Integer getNivel() {
        return nivel;
    }
    public void setListo(Boolean listo) {
        this.listo = listo;
    }
    public Boolean getListo() {
        return listo;
    }   
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }    
    public Jugador getJugadorAnfrition() {
        return jugadorAnfrition;
    }
    public List<Jugador> getJugadores() {
        return jugadores;
    }   
    public void setJugadorAnfrition(Jugador jugadorAnfrition) {
        this.jugadorAnfrition = jugadorAnfrition;
    }
    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }
    @Override
    public String toString() {      
        return "Sala{"+"id="+id+",jugadores="+jugadores.listIterator()+",nivel="+nivel+",jugadorAnfrition="+jugadorAnfrition+", listo="+listo+"}";
    }
}