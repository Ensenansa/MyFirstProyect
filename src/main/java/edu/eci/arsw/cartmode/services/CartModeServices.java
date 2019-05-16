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

    /**
     * Cambia el estado de una sala a no disponible.
     *
     * @param id El id de la sala a cambiar de estado.
     * @throws CartModeException
     */
    public void statedIdSala(Integer id) throws CartModeException;

    /**
     * Esta funcion retorna la cantidad de jugadores de una sala determinada.
     *
     * @param id El ID de la sala indicada.
     * @return Integer
     * @throws CartModeException
     */
    public Integer allPlayerOfSala(Integer id) throws CartModeException;

    /**
     * Retorna el id de la sala disponible. (De no haber retorna -1)
     *
     * @return Integer Indica el id de la sala disponible.
     * @throws CartModeException
     */
    public Integer getSalaDisponible() throws CartModeException;

    /**
     * Retorna el nombre de todos los jugadores de la sala indicada.
     *
     * @param id El id de la sala buscada
     * @return List<String> Lista de string con los nombres de los jugadores.
     * @throws CartModeException
     */
    public List<String> getNamePlayersBySala(Integer id) throws CartModeException;

    /**
     * Esta funcion le brinda todos los jugadores(como objeto) de una sala
     * especifica.
     *
     * @param idSala El identificador de la sala.
     * @return List<Jugador> Una lista de jugadores de una sala especifica.
     * @throws CartModeException
     */
    public List<Jugador> getJugadoresByIdSala(Integer idSala) throws CartModeException;

   /**
     * Retorna un valor booleano que indica si la sala esta o no lista.
     * @param idSala Representa el id de la sala.
     * @return Boolean El valor que representa si la sala indicada esta o no 
     * lista. (si inicio o no partida.)
     * @throws CartModeException
     */
    public Boolean getListoSala(Integer idSala) throws CartModeException;

    /**
     * Retorna la sala con el identificador que se le paso como parametro.
     * @param idlista Integer El identificAdor de la sala.
     * @return Sala Que tiene el Id que se le paso como parametro.
     * @throws CartModeException
     */
    public Sala getSalaById(Integer idlista) throws CartModeException;

    /**
     * Esta funcion cmbia el estado de la sala indicada, y la cierra  a que otros jugadores entren en ella.
     * @param idlista El identificador de la sala.
     * @throws CartModeException
     */
    public void SetStade(Integer idlista) throws CartModeException;

    /**
     * Esta funcion elimina todos los usuarios y salas del juego.
     *
     * @throws CartModeException
     */
    public void eraseAll() throws CartModeException;

    /**
     * Retorna la lista de salas activas en todo el juego.
     *
     * @return List<Sala> Lista de salas.
     * @throws CartModeException
     */
    public List<Sala> getSala() throws CartModeException;

    /**
     * Esta funcion retorna todos los nombres de los jugadores.
     *
     * @return Un List<String>
     * @throws CartModeException
     * @return @throws CartModeException
     */
    public List<String> nameAllPlayer() throws CartModeException;

    /**
     * Retorna la lista con todos los jugadores del juego.
     *
     * @return List<Jugador>
     * @throws CartModeException
     */
    public List<Jugador> nameAlPlayer() throws CartModeException;

    /**
     * Esta funcion agrega un usuario a una sala existinte o crea una nueva.
     *
     * @param name Nombre del jugador.
     * @throws CartModeException
     */
    public void addPlayer(String name) throws CartModeException;

    /**
     * Genera la baraja de cartas deacuerdo al nivel de la carta.
     *
     * @param nivel Nivel de la baraja generada.
     * @return List<CartaJavSc> Una lista de cartas.
     * @throws CartModeException
     */
    public List<CartaJavSc> GenerateBaraja(Integer nivel) throws CartModeException;

    /**
     * Esta funcion genera un duplicado de la baraja de cartas y tener asi la
     * cantidad total que necesita el tablero-
     *
     * @param nivel Representa el nivel que sera jugado, e indica que cartas
     * brindarle al jugador.
     * @return List<CartaJavSc> Una Lista con las cartas necesarias por nivel.
     * @throws CartModeException
     */
    public List<CartaJavSc> GenerateDuplicadoBaraja(Integer nivel) throws CartModeException;

    /**
     * Retorna el anfitrion de una sala en especifico.
     *
     * @param idSala El identificador de la sala
     * @return Jugador El jugador anfitrion de la sala.
     * @throws CartModeException
     */
    public Jugador getPlayerAnfiBySala(Integer idSala) throws CartModeException;

    /**
     * Retorna la cantidad de los jugadores en el juego
     *
     * @return Integer
     * @throws CartModeException
     */
    public Integer getAllPlayerInGame() throws CartModeException;

    /**
     * Regresa el jugador asociado al nombre pasado como parametro.
     * @param name Nombre del jugador
     * @return Jugador El objeto jugador que se asocie al nombre pasado como 
     * parametro.
     * @throws CartModeException
     */
    public Jugador getPlayerByName(String name) throws CartModeException;

    /**
     * Esta funcion remplaza al jugador que se encuentre en el arreglo de 
     * jugadores. Por el que se pasa como parametro.
     * @param play El Objeto jugador que reemplazara los datos del mismo jugador
     * en la lista de jugadores.
     * @throws CartModeException
     */
    public void setPlayerByName(Jugador play) throws CartModeException;

    /**
     * Retorna el identificador de la sala de un Jugador en especifico.
     *
     * @param nombre El nombre del jugador
     * @return Integer Identificador de sala.
     * @throws CartModeException
     */
    public Integer getIdSalaByPlayer(String nombre) throws CartModeException;

    /**
     * Retorna los nombres de todos los juagdores por una sala especifica.
     *
     * @param idSala El identificador de la sala.
     * @return List<String> Una lista con nombres-.
     * @throws CartModeException
     */
    public List<String> getAllPlayersBySala(Integer idSala) throws CartModeException;

    /**
     * Regresa una lista de listas con los nombres de la sala
     *
     * @param name NOmbre de jugador
     * @return List<List<String>>
     * @throws CartModeException
     */
    public List<List<String>> getPlayersBySala(String name) throws CartModeException;

    /**
     * Retorna la lista de preguntas ya configuradas.
     *
     * @return preguntas List<Pregunta> Que representa la lista de preguntas del
     * juego.
     * @throws CartModeException
     */
    public List<Pregunta> getListPreguntas() throws CartModeException;

    /**
     * Esta funcion retorn una pregunta de la lista de preguntas.
     * @return Pregunta El objeto pregunta que contiene una pregunta que 
     * respondera el usuario.
     * @throws CartModeException
     */
    public Pregunta getPregunta() throws CartModeException;

    /**
     * Esta funcion indica si el usuario pasado como parametro es o no anfitrion  
     * de la sala pasada como parametro.
     * @param nombre NOmbre del jugador a consultar.
     * @param sala Identificador de la sala consultada.
     * @return Boolean 
     * @throws CartModeException
     */
    public Boolean isPlayerAnfitrion(String nombre, Integer sala) throws CartModeException;

    /**
     * Retorna el nivel que tenga actualemente la sala que se pasa por 
     * parametro.
     * @param idSala El identificador de la sala a buscar.
     * @return Integer Un entero que representa el nivel en el que se encuentra 
     * la sala.
     * @throws CartModeException
     */
    public Integer LevelOfSala(Integer idSala) throws CartModeException;

    /**
     * Esta funcion eleva el nivel de la sala pasada como parametro.
     * @param idSala El identificador de la sala que se elevara su nivel.
     * @throws CartModeException
     */
    public void levelOfSalaId(Integer idSala) throws CartModeException;

    /**
     * Esta funcion retorna un valor booleano donde indica si el jugador pasado 
     * como parametro es o no anfrition de la sala indicada.
     * @param idSala Sala a consultar.
     * @param jugador A consultar en la sala.
     * @return Boolean Que representa si ese jugador es o no es el anfriotion.
     * @throws CartModeException 
     */
    public Boolean IsAnfitrion(Integer idSala, Jugador jugador) throws CartModeException;

}
