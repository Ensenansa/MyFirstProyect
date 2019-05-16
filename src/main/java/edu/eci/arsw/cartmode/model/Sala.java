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
     * Constructor vacio del objeto sala.
     */
    public Sala() {
    }  
    /**
     * Constructor del objeto sala con parametros de id, jugadores, jugadorAnfitrion y nivel.
     * @param id El identificador de la sala.
     * @param jugadores La lista de jugadores de la sala.
     * @param jugadorAnfrition El jugador Anfitrion de la sala.
     * @param nivel Nivel de la sala.
     */
    public Sala(Integer id, List<Jugador> jugadores, Jugador jugadorAnfrition, Integer nivel){
        this.id=id;
        this.jugadorAnfrition=jugadorAnfrition;
        this.jugadores=jugadores;        
        this.listo=false;
        this.nivel=nivel;
    }
    /**
     * Establece el nivel de la sala.
     * @param nivel Nivel de la sala.
     */
    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }
    /**
     * Retorna el nivel de la sala.
     * @return nivel Intero que representa el nivel de la materia.
     */
    public Integer getNivel() {
        return nivel;
    }
    /**
     * Establece el valor boolean de la variable listo.
     * @param listo Es la variable booleana que indica si la sala esta lista o
     * no.
     */
    public void setListo(Boolean listo) {
        this.listo = listo;
    }
    /**
     * Retorna el valor de la variable booleana listo.
     * @return listo Valor de la variable booleana listo que indica si la sala 
     * esta iniciada o no.
     */
    public Boolean getListo() {
        return listo;
    }  
    /**
     * Retorna el valor del id de la sala.
     * @return id Un entero que representa el identificador de la sala.
     */
    public Integer getId() {
        return id;
    }
    /**
     * Establece el valor del identificador de la sala.
     * @param id Representa el entero identificador de la sala.
     */
    public void setId(Integer id) {
        this.id = id;
    }  
    /**
     * Retorna el jugador anfitrion de la sala.
     * @return Jugador Representa el jugador anfitrion de la sala.
     */
    public Jugador getJugadorAnfrition() {
        return jugadorAnfrition;
    }
    /**
     * Retorna la lista de jugadores de la sala.
     * @return jugadores Lista de jugadores de la sala.
     */
    public List<Jugador> getJugadores() {
        return jugadores;
    }  
    /**
     * Establece al anfitrion de la sala.
     * @param jugadorAnfrition Un jugador que sera el anfitrion de la sala.
     */
    public void setJugadorAnfrition(Jugador jugadorAnfrition) {
        this.jugadorAnfrition = jugadorAnfrition;
    }
    /**
     * Establece la lista de jugadores de la sala.
     * @param jugadores Lista de jugadores.
     */
    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }
    /**
     * Representa el objeto en string.
     * @return String Con la representacion del objeto sala.
     */
    @Override
    public String toString() {      
        return "Sala{"+"id="+id+",jugadores="+jugadores.listIterator()+",nivel="+nivel+",jugadorAnfrition="+jugadorAnfrition+", listo="+listo+"}";
    }
}