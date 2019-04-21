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
    
    private List<CartaJavSc> barajas= new CopyOnWriteArrayList<>();
    private List<Pregunta> preguntas= new CopyOnWriteArrayList<>();
    //private List<Tripla<String,Boolean,Float>> respuestas= new CopyOnWriteArrayList<>();
    private List<String> respuestas= new CopyOnWriteArrayList<>();
    private float tiempo;
    private Integer Nivel;

    public Tablero() {
    }

    //public Tablero(List<Carta> barajas,List<Pregunta>pregunta, List<Tripla<String,Boolean,Float>> respuestas, Integer Nivel) {
    public Tablero(List<CartaJavSc> barajas,List<Pregunta>pregunta, List<String> respuestas, Integer Nivel) {
        this.barajas=barajas;
        this.preguntas=pregunta;
        this.respuestas=respuestas;
        this.tiempo=(float)0.0;
        this.Nivel=Nivel;
        
    }

    public void setNivel(Integer Nivel) {
        this.Nivel = Nivel;
    }

    public Integer getNivel() {
        return Nivel;
    }

    
    public List<CartaJavSc> getBarajas() {
        return barajas;
    }

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    //public List<Tripla<String, Boolean, Float>> getRespuestas() {
    public List<String> getRespuestas() {
        return respuestas;
    }

    public float getTiempo() {
        return tiempo;
    }

    public void setBarajas(List<CartaJavSc> barajas) {
        this.barajas = barajas;
    }

    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    //public void setRespuestas(List<Tripla<String, Boolean, Float>> respuestas) {
    public void setRespuestas(List<String> respuestas) {
        this.respuestas = respuestas;
    }

    public void setTiempo(float tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public String toString() {
        return "Tablero{"+"barajas="+barajas.toString()+", preguntas="+preguntas.toString()+", tiempo="+tiempo +",erspuestas="+respuestas.toString()+", nivel="+Nivel+"}";
    }
    
    
    
    
}
