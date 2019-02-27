/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.cartmode.model;

import edu.eci.arsw.cartmode.model.impl.Tupla;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author cesar
 */
public abstract class Nivel {
    private float tiempo=(float) 0.0;
    private boolean hermafrodita=false;
    private Tupla<Integer,Integer> tamaño=new Tupla(0,0);
    private List<Carta> barajas= new CopyOnWriteArrayList<>();
    private Integer puntaje=0;
    
    
    public Nivel(float tiempo, boolean hermafrodita, Tupla<Integer,Integer> tamaño,List<Carta> barajas) {
        this.barajas=barajas;
        this.hermafrodita=hermafrodita;
        this.puntaje=puntaje;
        this.tamaño=tamaño;
        this.tiempo=tiempo;
        
    }

    public List<Carta> getBarajas() {
        return barajas;
    }

    public Integer getPuntaje() {
        return puntaje;
    }

    public Tupla<Integer, Integer> getTamaño() {
        return tamaño;
    }

    public float getTiempo() {
        return tiempo;
    }

    public boolean isHermafrodita() {
        return hermafrodita;
    }

    public void setBarajas(List<Carta> barajas) {
        this.barajas = barajas;
    }

    public void setHermafrodita(boolean hermafrodita) {
        this.hermafrodita = hermafrodita;
    }

    public void setPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
    }

    public void setTamaño(Tupla<Integer, Integer> tamaño) {
        this.tamaño = tamaño;
    }

    public void setTiempo(float tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }    
    
}
