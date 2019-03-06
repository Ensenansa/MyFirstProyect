/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.cartmode.services;

import edu.eci.arsw.cartmode.model.Carta;
import edu.eci.arsw.cartmode.model.Jugador;
import edu.eci.arsw.cartmode.model.Nivel;
import edu.eci.arsw.cartmode.model.Pregunta;
import edu.eci.arsw.cartmode.model.Sala;
import edu.eci.arsw.cartmode.model.Tablero;
import edu.eci.arsw.cartmode.model.impl.Tripla;
import java.util.List;

/**
 *
 * @author cesar
 */
public interface CartModeServices {
    //javascript:pasarVariables()
    
    public List<Sala> getSala()throws CartModeException;
    public List<String> nameAllPlayer() throws CartModeException;

    public List<Jugador> nameAlPlayer() throws CartModeException;
    
    public void addPlayer(String name)throws CartModeException;
    
    public void generateTblero(List<Carta> barajas,List<Pregunta>pregunta, List<Tripla<String,Boolean,Float>> respuestas)throws  CartModeException;
            
    public List<Carta> GenerateBaraja(Integer nivel)throws  CartModeException;
    
    
    public void iniciarPartida(Integer idSala,List<Jugador> players, Nivel level)throws  CartModeException;
    
    public List<List<String>> getPlayersBySala(String name)throws  CartModeException;
    public void detenerPartida()throws  CartModeException;
    
}
