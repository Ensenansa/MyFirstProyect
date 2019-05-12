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
/**
 * 
 * @param id
 * @param enunciado
 * @param tema
 * @param opcionesDeRespuesta
 * @param respuestaCorrecta 
 */
    public Pregunta(Integer id, String enunciado, String tema, List<String> opcionesDeRespuesta,String respuestaCorrecta) {
        this.id = id;
        this.enunciado = enunciado;
        this.opcionesDeRespuesta = opcionesDeRespuesta;
        this.respuestaCorrecta=respuestaCorrecta;
    }
    /**
     * 
     */
    public Pregunta() {
    }
    /**
     * 
     * @param respuestaCorrecta 
     */
    public void setRespuestaCorrecta(String respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }
    /**
     * 
     * @return 
     */
    public String getRespuestaCorrecta() {
        return respuestaCorrecta;
    }
    /**
     * 
     * @return 
     */
    public int getId() {
        return id;
    }  
    /**
     * 
     * @param id 
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * 
     * @return 
     */
    public String getEnunciado() {
        return enunciado;
    }
    /**
     * 
     * @param enunciado 
     */
    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }
    /**
     * 
     * @return 
     */
    public List<String> getOpcionesDeRespuesta() {
        return opcionesDeRespuesta;
    }
    /**
     * 
     * @param opcionesDeRespuesta 
     */
    public void setOpcionesDeRespuesta(List<String> opcionesDeRespuesta) {
        this.opcionesDeRespuesta = opcionesDeRespuesta;
    }  
    /**
     * 
     * @param respuestaJugador
     * @param respuestaCorrecta
     * @return 
     */
    public boolean validadorRespuesta(Object respuestaJugador, Object respuestaCorrecta){
        return false;
    }
    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        return "Pregunta{" + "id=" + id + ", encunciado=" + enunciado + '}';
    }
}
