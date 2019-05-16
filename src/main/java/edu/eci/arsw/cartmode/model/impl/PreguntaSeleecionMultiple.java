/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.cartmode.model.impl;

import edu.eci.arsw.cartmode.model.Pregunta;
import java.util.List;

/**
 *
 * @author cesar
 */
public class PreguntaSeleecionMultiple extends Pregunta {

    /**
     * Constructor que pide atributos como Identificador, enunciado, tema,
     * opciones de respuesta, respuesta correcta.
     * @param id Integer que representa el identificador de la pregunta.
     * @param enunciado String que repreesnta el enunciado de la pregunta.
     * @param tema String que representa el tema de la pregunta.
     * @param opcionesDeRespuesta List<String> que representa las opciones de
     * respuesta de las preguntas.
     * @param respuestaCorrecta String que representa la respuesta correcta de
     * la pregutna.
     *
     */
    public PreguntaSeleecionMultiple(int id, String enunciado, String tema, List<String> opcionesDeRespuesta, String respuestaCorrecta) {
        super(id, enunciado, tema, opcionesDeRespuesta, respuestaCorrecta);
    }

    /**
     * Constructor vacio.
     */
    public PreguntaSeleecionMultiple() {
    }
}
