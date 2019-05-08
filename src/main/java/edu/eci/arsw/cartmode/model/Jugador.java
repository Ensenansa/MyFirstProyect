/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.cartmode.model;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.data.annotation.Id;

/**
 *
 * @author cesar
 */
public class Jugador {

    private String nickName;
    private Integer puntaje;
    private Integer numCorrrectas;  
    private Integer sala;
    public Jugador() {
    }
    public Jugador(String nickName,Integer puntaje) {
        this.nickName = nickName;
        this.puntaje = puntaje;
        numCorrrectas = null;
        sala=null;        
    }      
    public Jugador(String nickName) {        
        this.nickName = nickName;
        puntaje = 0;
        numCorrrectas = 0;
        sala=0;
    }
    public void setSala(Integer sala) {
        this.sala = sala;
    }
    public Integer getSala() {
        return sala;
    }
    public Integer getNumCorrrectas() {
        return numCorrrectas;
    }
    public String getNickName() {
        return nickName;
    }
    public Integer getPuntaje() {
        return puntaje;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public void setnumCorrrectas(Integer numCorrrectas) {
        this.numCorrrectas = numCorrrectas;
    }
    public void setPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
    }
    @Override
    public String toString() {    
        return "Jugador{"+"nickName="+nickName+",puntaje="+puntaje+",numeroDePreguntasCorrrectas="+numCorrrectas+", sala="+sala+"}";        
    }
}
