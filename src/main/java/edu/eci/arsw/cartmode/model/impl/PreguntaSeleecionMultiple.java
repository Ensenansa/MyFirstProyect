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
public class PreguntaSeleecionMultiple extends Pregunta{
    
    public PreguntaSeleecionMultiple(int id, String enunciado, String tema, List<String> opcionesDeRespuesta, String respuestaCorrecta) {
        super(id, enunciado, tema, opcionesDeRespuesta, respuestaCorrecta);
    }
    public PreguntaSeleecionMultiple() {
    }
}
