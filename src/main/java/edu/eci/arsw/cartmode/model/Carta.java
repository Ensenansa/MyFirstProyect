/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.cartmode.model;

/**
 *
 * @author cesar
 */
public class Carta {
    private String dato;
    //private boolean bloqueado;
    private Integer pos;
    private String nombre;

    public Carta() {
    }

    public Integer getPos() {
        return pos;
    }

    public void setPos(Integer pos) {
        this.pos = pos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
        
    public Carta(String dato){
        this.dato=dato;
        this.pos=null;
        //this.nivel=nivel;
        //this.bloqueado=false;
    }
    public Carta(String dato, Integer pos){
        this.dato=dato;
        this.pos=pos;
        //this.nivel=nivel;
        //this.bloqueado=false;
    }
    public String getDato() {
        return dato;
    }
/*
    public boolean isBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    */
    public void setDato(String dato) {
        this.dato = dato;
    }


    @Override
    public String toString() {
        //return super.toString(); //To change body of generated methods, choose Tools | Templates.
        return "Carta{"+"dato="+dato+"pos="+pos+"nombre="+nombre+'}';
    }
    /*
    public Integer getNivel(){
        return nivel;
    }
    public void setNIvel(Integer nivel){
        this.nivel=nivel;
    
    }
    */
    
    
}
