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
public class Jugador {

    private String nickName;
    private Integer parejasAcertadas;
    private Integer puntaje;
    private Integer preguntasCorrrectas;
    private Integer preguntasIncorrectas;
    private Integer nivel;
    private Integer sala;

    public Jugador() {
    }

    public Jugador(String nickName) {
        this.nickName = nickName;
        parejasAcertadas = 0;
        puntaje = 0;
        preguntasCorrrectas = 0;
        preguntasIncorrectas = 0;
        nivel=1;
        sala=0;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setSala(Integer sala) {
        this.sala = sala;
    }

    public Integer getSala() {
        return sala;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public Integer getParejasAcertadas() {
        return parejasAcertadas;
    }

    public String getNickName() {
        return nickName;
    }

    public Integer getPuntaje() {
        return puntaje;
    }

    public Integer getPreguntasCorrrectas() {
        return preguntasCorrrectas;
    }

    public Integer getPreguntasIncorrectas() {
        return preguntasIncorrectas;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setParejasAcertadas(Integer parejasAcertadas) {
        this.parejasAcertadas = parejasAcertadas;
    }

    public void setPreguntasCorrrectas(Integer preguntasCorrrectas) {
        this.preguntasCorrrectas = preguntasCorrrectas;
    }

    public void setPreguntasIncorrectas(Integer preguntasIncorrectas) {
        this.preguntasIncorrectas = preguntasIncorrectas;
    }

    public void setPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

}
