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
     * Constructor vacio.
     */
    public Carta() {
    }

    /**
     * Constructor que recive solo un atributo, el dato de la carta.
     *
     * @param dato Dato de la carta.
     */
    public Carta(String dato) {
        this.dato = dato;
        this.pos = null;
    }

    /**
     * COntructor que recive dos parametros, el dato de la carta y la posicion de la carta.
     * @param dato Es el dato de la carta. 
     * @param pos Es la posicion de la carta.
     */
    public Carta(String dato, Integer pos) {
        this.dato = dato;
        this.pos = pos;
    }

    /**
     * Retorna la posicion de la carta.
     * @return pos Entero que representa la posicion de la carta.
     */
    public Integer getPos() {
        return pos;
    }

    /**
     *Establece la posicion de la carta.
     * @param pos Posicion de la carta.
     */
    public void setPos(Integer pos) {
        this.pos = pos;
    }

    /**
     * Establece el nombre de la carta.
     * @param nombre EL nombre de la carta.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Retorna el nombre de la carta.
     * @return nombre Nombre de la carta.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Retorna el dato de la carta.
     * @return dato EL dato de la carta.
     */
    public String getDato() {
        return dato;
    }

    /**
     * Establece el dato de la carta.
     * @param dato Dato de la carta.
     */
    public void setDato(String dato) {
        this.dato = dato;
    }

    /**
     * Representa el objeto en string
     * @return String Con la representacion del objeto carta.
     */
    @Override
    public String toString() {
        return "Carta{" + "dato=" + dato + "pos=" + pos + "nombre=" + nombre + '}';
    }
}
