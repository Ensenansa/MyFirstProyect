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
    
    
    public Sala(Integer id, Tablero tablero, List<Jugador> jugadores, Jugador jugadorAnfrition){
        this.id=id;
        this.jugadorAnfrition=jugadorAnfrition;
        this.jugadores=jugadores;
        this.tablero=tablero;
    
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
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
}
