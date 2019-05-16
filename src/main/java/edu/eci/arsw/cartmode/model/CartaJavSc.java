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
    /**
     * Constructor vacio.
     */
    public CartaJavSc() {
    }
    /**
     * Constructor que recibe 2 parametros, dato y seleccion.
     * @param dato String que representa el dato de la carta.
     * @param seleecion Boolean que representa si la carta ha sido seleccionada 
     * o no.
     */
    public CartaJavSc(String dato,Boolean seleecion) {
        this.dato=dato;
        this.seleccion=seleecion;
    }
    /**
     * Establece el valor de seleecion de la carta
     * @param seleccion Boolean Valor de verdad que representa si la carta 
     * a sido selecionada o no.
     */
    public void setSeleccion(boolean seleccion) {
        this.seleccion = seleccion;
    }
    /**
     * Retorna el valor booleano de seleccion.
     * @return seleccion Boolean Valor booelano de si la carta a sido 
     * seleccionada o no.
     */
    public boolean isSeleccion() {
        return seleccion;
    }  
    /**
     * Retorna el valor del dato de la carta.
     * @return dato String Que representa el valor del dato de la carta.
     */
    public String getDato() {
        return dato;
    }
    /**
     * Establece el valor del dato de la carta.
     * @param dato String Que representa el dato de la carta.
     */
    public void setDato(String dato) {
        this.dato = dato;
    }
    /**
     * Representa el objeto en string.
     * @return String Con la representacion del objeto CartaJavSc.
     */
    @Override
    public String toString() {     
        return "{" + "nombre: '" + dato +"'seleccion: "+seleccion +'}';        
    }    
}
