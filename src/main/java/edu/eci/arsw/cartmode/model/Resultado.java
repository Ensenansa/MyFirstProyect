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
    /**
     * Constructor vacio.
     */
    public Resultado(){}
    /**
     * COnstructor que recibe 3 parametros, puntaje total, nombrejugador y resultados.
     * @param puntajeTotal Un entero que representa el puntaje total realizado
     * por el jugador.
     * @param nombreJUgador Es nombre del jugador.
     * @param resultados Son los resultados del jugador.
     */
    /**
    public Resultado(Integer puntajeTotal,String nombreJUgador,String resultados){
        this.puntajeTotal=puntajeTotal;
        this.nombreJugador=nombreJUgador;
        this.resultados=resultados;       
    }*/
    /**
     * Retorna el nombre del jugador.
     * @return nombreJugador String que representa el nombre del jugador.
     */
    public String getNombreJugador() {
        return nombreJugador;
    }
    /**
     * Retorna el puntaje total del jugador
     * @return puntajeTotal Entero que represena el puntaje total del jugador.
     */
    public Integer getPuntajeTotal() {
        return puntajeTotal;
    }
    /**
     * Retorna el resultado del jugador.
     * @return resultados String que representa los resultados del jugador.
     */
    public String getResultados() {
        return resultados;
    }
    /**
     * Establece el nombre del jugador.
     * @param nombreJugador String que representa el nombre del jugador.
     */
    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }
    /**
     * Estable el puntaje total del jugador.
     * @param puntajeTotal Entero que representa el puntaje total.
     */
    public void setPuntajeTotal(Integer puntajeTotal) {
        this.puntajeTotal = puntajeTotal;
    }
    /**
     * Estable el resutlado del jugador.
     * @param resultados String que representa los resultados del jugador.
     */
    public void setResultados(String resultados) {
        this.resultados = resultados;
    }
    /**
     * Representa el objeto en string.
     * @return String Con la representacion del objeto resultado.
     */
    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
}
