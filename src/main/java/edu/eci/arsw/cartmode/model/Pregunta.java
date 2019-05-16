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
 * COnstructor que recibe como parametro identificador de pregunta, eninciado, 
 * tema, opciones de respuesta y respuesta correcta.
 * @param id Integer que representa el identificador de la pregunta.
 * @param enunciado String que repreesnta el enunciado de la pregunta.
 * @param tema String que representa el tema de la pregunta.
 * @param opcionesDeRespuesta List<String> que representa las opciones de respuesta de las preguntas.
 * @param respuestaCorrecta String que representa la respuesta correcta de la pregutna.
 */
    public Pregunta(Integer id, String enunciado, String tema, List<String> opcionesDeRespuesta,String respuestaCorrecta) {
        this.id = id;
        this.enunciado = enunciado;
        this.opcionesDeRespuesta = opcionesDeRespuesta;
        this.respuestaCorrecta=respuestaCorrecta;
    }
    /**
     * Constructor vacio.
     */
    public Pregunta() {
    }
    /**
     * Establece la respuesta correcta del jugador.
     * @param respuestaCorrecta String que representa la respesuta correcta de 
     * la pregunta.
     */
    public void setRespuestaCorrecta(String respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }
    /**
     * Retorna la resuesta correecta de la pregunta
     * @return respuestaCorrecta String que representa la respuesta correcta de
     * la pregunta.
     */
    public String getRespuestaCorrecta() {
        return respuestaCorrecta;
    }
    /**
     * Retorna el identificador de la pregunta.
     * @return id Entero que representa el identificador de la pregunta.
     */
    public Integer getId() {
        return id;
    }  
    /**
     * Establece el identificador de la pregunta.
     * @param id Integer que representa el identificador de la pregunta.
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * Retorna el enunciado de la pregunta.
     * @return enunciado String que representa el enunciado de la pregunta.
     */
    public String getEnunciado() {
        return enunciado;
    }
    /**
     * Establece el enunciado de la pregunta.
     * @param enunciado String que representa el enunciado de la pregunta.
     */
    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }
    /**
     * Retorna la lista de opciones de respuesta de la pregunta.
     * @return opcionesDeRespuesta List<String> que representa las opciones
     * de respuesta de la pregunta.
     */
    public List<String> getOpcionesDeRespuesta() {
        return opcionesDeRespuesta;
    }
    /**
     * Establece las opciones de respuesta de la pregunta.
     * @param opcionesDeRespuesta List<String> Es la lista que representa las 
     * opciones de respuseta de la pregunta.
     */
    public void setOpcionesDeRespuesta(List<String> opcionesDeRespuesta) {
        this.opcionesDeRespuesta = opcionesDeRespuesta;
    }  
    /**
     * Retorna el valor booleano de comprobar si la respuesta es correcta o no.
     * @param respuestaJugador Objeto que representa la respuesta del jugador.
     * @param respuestaCorrecta Objeto que representa la respuesta correcta 
     * de la pregunta.
     * @return resp Boolean que representa si la respuesta del jugador es 
     * correcta o no.
     */
    public boolean validadorRespuesta(Object respuestaJugador, Object respuestaCorrecta){
        boolean resp=false;
        if(respuestaJugador.equals(respuestaCorrecta)){
            resp=true;        
        };
        return resp;
    }
    /**
     * Representa el objeto en string.
     * @return String Con la representacion del objeto Pregunta.
     */
    @Override
    public String toString() {
        return "Pregunta{" + "id=" + id + ", encunciado=" + enunciado + '}';
    }
}
