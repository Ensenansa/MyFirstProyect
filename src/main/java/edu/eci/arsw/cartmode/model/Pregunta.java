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
public abstract class Pregunta {
    
    private int id;
    private String enunciado;
    private List<String> opcionesDeRespuesta;
    private Float tiempo;
    private Integer respJUgador;

    public Pregunta(int id, String enunciado, String tema, List<String> opcionesDeRespuesta, Float tiempo) {
        this.id = id;
        this.enunciado = enunciado;
        this.opcionesDeRespuesta = opcionesDeRespuesta;
        this.tiempo = tiempo;
        this.respJUgador=null;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public List<String> getOpcionesDeRespuesta() {
        return opcionesDeRespuesta;
    }

    public void setOpcionesDeRespuesta(List<String> opcionesDeRespuesta) {
        this.opcionesDeRespuesta = opcionesDeRespuesta;
    }

    public Float getTiempo() {
        return tiempo;
    }

    public void setTiempo(Float tiempo) {
        this.tiempo = tiempo;
    }
    
    public Integer getRespuestaJugador(){
        return respJUgador;
    }
    public void setRespuestaJugador(Integer ob){
        respJUgador=ob;
    }    
    public boolean validadorRespuesta(Object respuestaJugador, Object respuestaCorrecta){
        return false;
    }
        @Override
    public String toString() {
        return "Pregunta{" + "id=" + id + ", encunciado=" + enunciado + '}';
    }
   
}