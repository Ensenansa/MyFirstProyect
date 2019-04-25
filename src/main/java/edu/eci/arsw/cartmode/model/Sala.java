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
    private Tablero tablero;
    private Boolean listo;
    private Integer nivel;

    public Sala() {
    }
    
    
    public Sala(Integer id, Tablero tablero, List<Jugador> jugadores, Jugador jugadorAnfrition, Integer nivel){
        this.id=id;
        this.jugadorAnfrition=jugadorAnfrition;
        this.jugadores=jugadores;
        this.tablero=tablero;
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

    public Jugador getJugadorAnfrition() {
        return jugadorAnfrition;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setJugadorAnfrition(Jugador jugadorAnfrition) {
        this.jugadorAnfrition = jugadorAnfrition;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }
    @Override
    public String toString() {
        
        return "Sala{"+"id="+id+", tablero="+tablero+", jugadores="+jugadores.listIterator()+",nivel="+nivel+",jugadorAnfrition="+jugadorAnfrition+", listo="+listo+"}";
    }
}