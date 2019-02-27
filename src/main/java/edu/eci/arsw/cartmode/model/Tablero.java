/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.cartmode.model;

import edu.eci.arsw.cartmode.model.impl.Tripla;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author cesar
 */
public class Tablero {
    
    private List<Carta> barajas= new CopyOnWriteArrayList<>();
    private List<Pregunta> preguntas= new CopyOnWriteArrayList<>();
    private List<Tripla<String,Boolean,Float>> respuestas= new CopyOnWriteArrayList<>();
    private float tiempo;

    public Tablero(List<Carta> barajas,List<Pregunta>pregunta, List<Tripla<String,Boolean,Float>> respuestas) {
        this.barajas=barajas;
        this.preguntas=pregunta;
        this.respuestas=respuestas;
        this.tiempo=(float)0.0;
        
    }

    
    
    public List<Carta> getBarajas() {
        return barajas;
    }

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public List<Tripla<String, Boolean, Float>> getRespuestas() {
        return respuestas;
    }

    public float getTiempo() {
        return tiempo;
    }

    public void setBarajas(List<Carta> barajas) {
        this.barajas = barajas;
    }

    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    public void setRespuestas(List<Tripla<String, Boolean, Float>> respuestas) {
        this.respuestas = respuestas;
    }

    public void setTiempo(float tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
