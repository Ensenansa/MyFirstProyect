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
    /**
     * 
     */
    public Jugador() {
    }
    /**
     * 
     * @param nickName
     * @param puntaje 
     */
    public Jugador(String nickName,Integer puntaje) {
        this.nickName = nickName;
        this.puntaje = puntaje;
        numCorrrectas = null;
        sala=null;        
    }  
/**
 * 
 * @param nickName 
 */    
    public Jugador(String nickName) {        
        this.nickName = nickName;
        puntaje = 0;
        numCorrrectas = 0;
        sala=0;
    }
    /**
     * 
     * @param sala 
     */
    public void setSala(Integer sala) {
        this.sala = sala;
    }
    /**
     * 
     * @return 
     */
    public Integer getSala() {
        return sala;
    }
    /**
     * 
     * @return 
     */
    public Integer getNumCorrrectas() {
        return numCorrrectas;
    }
    /**
     * 
     * @return 
     */
    public String getNickName() {
        return nickName;
    }
    /**
     * 
     * @return 
     */
    public Integer getPuntaje() {
        return puntaje;
    }
    /**
     * 
     * @param nickName 
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    /**
     * 
     * @param numCorrrectas 
     */
    public void setnumCorrrectas(Integer numCorrrectas) {
        this.numCorrrectas = numCorrrectas;
    }
    /**
     * 
     * @param puntaje 
     */
    public void setPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
    }
    /**
     * 
     * @return 
     */
    @Override
    public String toString() {    
        return "Jugador{"+"nickName="+nickName+",puntaje="+puntaje+",numeroDePreguntasCorrrectas="+numCorrrectas+", sala="+sala+"}";        
    }
}
