/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.cartmode.model;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.data.annotation.Id;

/**
 *
 * @author cesar
 */
public class Jugador {

    private String nickName;
    private Integer puntaje;
    private Integer numCorrrectas;
    private Integer sala;

    /**
     * Constructor vacio.
     */
    public Jugador() {
    }

    /**
     * Constructor que recibe 2 parametros nickName y puntaje.
     *
     * @param nickName String que representa el nombre del jugador.
     * @param puntaje Entero que representa el puntaje del jugador.
     */
    public Jugador(String nickName, Integer puntaje) {
        this.nickName = nickName;
        this.puntaje = puntaje;
        numCorrrectas = null;
        sala = null;
    }

    /**
     * Constructor que recibe un parametro, NickName.
     * @param nickName String que representa el nombre del jugador.
     */
    public Jugador(String nickName) {
        this.nickName = nickName;
        puntaje = 0;
        numCorrrectas = 0;
        sala = 0;
    }

    /**
     * Establece la sala del jugador.
     * @param sala Entero que representa la sala a la que pertecene el jugador.
     */
    public void setSala(Integer sala) {
        this.sala = sala;
    }

    /**
     * Retorna el identificador de la sala a la cual pertenece el jgador.
     * @return sala Entero que representa el identificador de la sala.
     */
    public Integer getSala() {
        return sala;
    }

    /**
     * Retorna la cantidad de preguntas correctas.
     * @return numCorrrectas Entero que representa las preguntas contestadas 
     * correctamente.
     */
    public Integer getNumCorrrectas() {
        return numCorrrectas;
    }

    /**
     * Retorna el nombre del jugador.
     * @return nickName String que representa el nombre del jugador.
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * Retorna el puntaje del jugador.
     * @return puntaje Entero que representa el puntaje del jugador.
     */
    public Integer getPuntaje() {
        return puntaje;
    }

    /**
     * Establece el nombre del jugador.
     * @param nickName String que representa el nombre del jugador.
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * Establece el numero de preguntas correctas realizadas por el jugador.
     * @param numCorrrectas Integer Que representa la cantidad de preguntas 
     * correctas realizadas por el jugador.
     */
    public void setnumCorrrectas(Integer numCorrrectas) {
        this.numCorrrectas = numCorrrectas;
    }

    /**
     * Establece el puntaje del jugador.
     * @param puntaje Entero que representa el puntaje realizado por el jugador.
     */
    public void setPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
    }

    /**
     * Representa el objeto en string.     
     * @return String Con la representacion del objeto jugador.
     */
    @Override
    public String toString() {
        return "Jugador{" + "nickName=" + nickName + ",puntaje=" + puntaje + ",numeroDePreguntasCorrrectas=" + numCorrrectas + ", sala=" + sala + "}";
    }
}
