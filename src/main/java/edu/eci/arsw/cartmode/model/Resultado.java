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
public class Resultado {
    
    private Integer puntajeTotal;
    private String nombreJugador;
    private String resultados;
    
    public Resultado(Integer puntajeTotal,String nombreJUgador,String resultados){
        this.puntajeTotal=puntajeTotal;
        this.nombreJugador=nombreJUgador;
        this.resultados=resultados;
    
    
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public Integer getPuntajeTotal() {
        return puntajeTotal;
    }

    public String getResultados() {
        return resultados;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public void setPuntajeTotal(Integer puntajeTotal) {
        this.puntajeTotal = puntajeTotal;
    }

    public void setResultados(String resultados) {
        this.resultados = resultados;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
