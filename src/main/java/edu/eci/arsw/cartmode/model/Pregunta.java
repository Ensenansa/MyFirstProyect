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
    private Integer respJUgador;
    private String respuestaCorrecta;

    public Pregunta(int id, String enunciado, String tema, List<String> opcionesDeRespuesta,String respuestaCorrecta) {
        this.id = id;
        this.enunciado = enunciado;
        this.opcionesDeRespuesta = opcionesDeRespuesta;
        //this.tiempo = tiempo;
        this.respJUgador=null;
        this.respuestaCorrecta=respuestaCorrecta;
    }
    public Pregunta() {
    }
    public void setRespuestaCorrecta(String respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }
    public String getRespuestaCorrecta() {
        return respuestaCorrecta;
    }
    public Integer getRespJUgador() {
        return respJUgador;
    }
    public void setRespJUgador(Integer respJUgador) {
        this.respJUgador = respJUgador;
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
