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
    
    private Integer id;
    private String enunciado;
    private List<String> opcionesDeRespuesta;
    private String respuestaCorrecta;

    public Pregunta(Integer id, String enunciado, String tema, List<String> opcionesDeRespuesta,String respuestaCorrecta) {
        this.id = id;
        this.enunciado = enunciado;
        this.opcionesDeRespuesta = opcionesDeRespuesta;
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
    public boolean validadorRespuesta(Object respuestaJugador, Object respuestaCorrecta){
        return false;
    }
    @Override
    public String toString() {
        return "Pregunta{" + "id=" + id + ", encunciado=" + enunciado + '}';
    }
}
