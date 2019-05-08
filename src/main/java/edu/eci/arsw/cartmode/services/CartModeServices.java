/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.cartmode.services;

import edu.eci.arsw.cartmode.model.Carta;
import edu.eci.arsw.cartmode.model.CartaJavSc;
import edu.eci.arsw.cartmode.model.Jugador;
import edu.eci.arsw.cartmode.model.Pregunta;
import edu.eci.arsw.cartmode.model.Sala;
import java.util.List;

/**
 *
 * @author cesar
 */
public interface CartModeServices {
    
    public void statedIdSala(Integer id)throws CartModeException;
    public Integer allPlayerOfSala(Integer id)throws CartModeException;
    public Integer getSalaDisponible()throws CartModeException;    
    public List<String> getNamePlayersBySala(Integer id)throws CartModeException;    
    public List<Jugador> getJugadoresByIdSala(Integer idSala)throws CartModeException;
    public Boolean getListoSala(Integer idSala)throws CartModeException;
    public Sala getSalaById(Integer idlista)throws CartModeException;
    public void SetStade(Integer idlista)throws CartModeException;
    public void eraseAll()throws CartModeException;
    public List<Sala> getSala()throws CartModeException;
    public List<String> nameAllPlayer() throws CartModeException;
    public List<Jugador> nameAlPlayer() throws CartModeException;    
    public void addPlayer(String name)throws CartModeException;   
    public List<CartaJavSc> GenerateBaraja(Integer nivel)throws  CartModeException;
    public List<CartaJavSc> GenerateDuplicadoBaraja(Integer nivel)throws  CartModeException;    
    public Jugador getPlayerAnfiBySala(Integer idSala)throws  CartModeException;    
    public Integer getAllPlayerInGame()throws  CartModeException;    
    public Jugador getPlayerByName(String name)throws  CartModeException;
    public void setPlayerByName(Jugador play)throws  CartModeException;    
    public void upLevelSalaId(Integer id)throws  CartModeException;
    public Integer getIdSalaByPlayer(String nombre)throws  CartModeException;    
    public List<String> getAllPlayersBySala(Integer idSala)throws  CartModeException;    
    public List<List<String>> getPlayersBySala(String name)throws  CartModeException;    
    public List<Pregunta>getListPreguntas()throws  CartModeException;
    public Pregunta getPregunta()throws  CartModeException;    
    public Boolean isPlayerAnfitrion(String nombre, Integer sala)throws  CartModeException;    
    public Integer LevelOfSala(Integer idSala)throws  CartModeException;
    public void levelOfSalaId(Integer idSala)throws  CartModeException;
    
}