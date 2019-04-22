/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.cartmode.model;

/**
 *
 * @author cefa-dico-asus
 */
public class CartaJavSc {
        private String dato;
    private boolean seleccion;

    public CartaJavSc() {
    }

    public CartaJavSc(String dato,Boolean seleecion) {
        this.dato=dato;
        this.seleccion=seleecion;
    }

    public void setSeleccion(boolean seleccion) {
        this.seleccion = seleccion;
    }

    public boolean isSeleccion() {
        return seleccion;
    }
    
    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    @Override
    public String toString() {
        //return super.toString(); //To change body of generated methods, choose Tools | Templates.
        return "{" + "nombre: '" + dato +"'seleccion: "+seleccion +'}';
        
    }
    
}
