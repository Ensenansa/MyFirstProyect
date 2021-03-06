/*/*
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
import edu.eci.arsw.cartmode.model.impl.PreguntaSeleecionMultiple;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.stereotype.Service;
import java.util.Random;
import org.springframework.boot.CommandLineRunner;

/**
 *
 * @author 2098325
 */
@Service
public class CartModeStub implements CartModeServices {  
    
    private static final List<Jugador> player;
    private static final List<Pregunta> preguntas;
    private static final List<String> opcionesrespuesta;
    private static final List<Sala> salas;
    private static final Integer contador;
    private static final Jugador temporal;
    private static final List<String> abecedario;

    public CartModeStub() {
    }

    /**
     * Esta funcion retorna todos los nombres de los jugadores.
     * @return resp Retorna una lista de tipo string con todos los nombres de 
     * los jugadores del juego.
     * @throws CartModeException Genera una excepcion cuando ocurre un error.
     */
    @Override
    public List<String> nameAllPlayer() throws CartModeException {
        List<String> resp = new ArrayList<String>();
        for (Jugador lo : player) {
            resp.add(lo.getNickName());
        }
        return resp;
    }

    /**
     *Retorna la lista con todos los jugadores del juego.
     * @return player Retorna una lista de tipo jugador con todos los jugadores 
     * de  la partida.
     * @throws CartModeException Genera una excepcion cuando ocurre un error.
     */
    @Override
    public List<Jugador> nameAlPlayer() throws CartModeException {
        return player;
    }

    /**
     *Retorna la cantidad de los jugadores en el juego
     * @return  Integer Retorna un entero el cual representa la cantidad 
     * de jugadores en el juego.
     * @throws CartModeException Genera una excepcion cuando ocurre un error.
     */
    public Integer getAllPlayerInGame() throws CartModeException {
        return player.size();
    }

    /**
     * Esta funcion agrega un usuario a una sala existinte o crea una nueva.
     * @param name Nombre del jugador.
     * @throws CartModeException Genera una excepcion cuando ocurre un error.
     */
    @Override
    public void addPlayer(String name) throws CartModeException {
        Jugador play = new Jugador(name);
        System.out.println("Agergaando" + name);
        player.add(play);
        if (salas.size() == 0) {
            List<Jugador> kl = new ArrayList<Jugador>();
            play.setSala(salas.size());
            kl.add(play);
            Sala temp = new Sala(salas.size(), kl, play, 0);
            salas.add(temp);
        } else if (salas.size() > 0) {
            int y = 0;
            boolean puesto = false;
            while (y < salas.size() && !puesto) {
                Sala op = salas.get(y);
                if (op.getJugadores().size() < 4 && op.getListo() != true) {
                    List<Jugador> tr = op.getJugadores();
                    play.setSala(salas.size() - 1);
                    tr.add(play);
                    op.setJugadores(tr);
                    puesto = true;
                    if (op.getJugadores().size() == 4) {
                        op.setListo(true);
                    }
                }
                y++;
            }
            if (!puesto) {
                List<Jugador> kl = new ArrayList<Jugador>();
                kl.add(play);
                Sala tmp2 = new Sala(salas.size(), kl, null, 0);
                salas.add(tmp2); //Para que tenga elid de sala correcto                          
                play.setSala(salas.size() - 1);
                Sala temp3 = salas.get(salas.size() - 1);
                temp3.setJugadorAnfrition(play);
                salas.set(salas.size() - 1, temp3);//Debemos setear al jugador
            }
        }
    }

    /**
     * Esta funcion retorna la cantidad de jugadores de una sala determinada.
     * @param id El ID de la sala indicada.
     * @return Integer Representa la cantidad de jugadores en una sala 
     * especifica.
     * @throws CartModeException Genera una excepcion cuando ocurre un error.
     */
    @Override
    public Integer allPlayerOfSala(Integer id) throws CartModeException {
        Sala f = salas.get(id);
        return f.getJugadores().size();
    }

    /**
     * Retorna el id de la sala disponible. (De no haber retorna -1)
     * @return Integer Indica el id de la sala disponible.
     * @throws CartModeException Genera una excepcion cuando ocurre un error.
     */
    @Override
    public Integer getSalaDisponible() throws CartModeException {
        int resp = -1;
        for (Sala sa : salas) {
            if (sa.getJugadores().size() < 4 && sa.getListo() != true) {
                resp = sa.getId();
            }
        }
        return resp;
    }

    /**
     * Retorna el nombre de todos los jugadores de la sala indicada.
     * @param id El id de la sala buscada
     * @return resp Retorna una lista de tipo String con todos los nombres de 
     * la sala indicada..
     * @throws CartModeException Genera una excepcion cuando ocurre un error.
     */
    @Override
    public List<String> getNamePlayersBySala(Integer id) throws CartModeException {
        List<String> resp = new ArrayList<String>();
        Sala temp = salas.get(id);
        List<Jugador> ju = temp.getJugadores();
        for (Jugador tr : ju) {
            resp.add(tr.getNickName());
        }
        return resp;
    }

    /**
     * Cambia el estado de una sala a no disponible.
     * @param id El id de la sala a cambiar de estado.
     * @throws CartModeException Genera una excepcion cuando ocurre un error.
     */
    public void statedIdSala(Integer id) throws CartModeException {
        Sala temp = salas.get(id);
        temp.setListo(true);
    }

    /**
     * Esta funcion genera un duplicado de la baraja de cartas y tener asi la 
     * cantidad total que necesita el tablero-
     * @param nivel Representa el nivel que sera jugado, e indica que cartas 
     * brindarle al jugador.    
     * @return resp1 Retorna una lista de tipo CartaJavSc con las cartas necesarias por nivel.
     * @throws CartModeException Genera una excepcion cuando ocurre un error.
     */
    @Override
    public List<CartaJavSc> GenerateDuplicadoBaraja(Integer nivel) throws CartModeException {
        List<CartaJavSc> resp1 = new ArrayList<CartaJavSc>();
        List<CartaJavSc> resp2 = new ArrayList<CartaJavSc>();
        resp1 = GenerateBaraja(nivel);
        resp2 = GenerateBaraja(nivel);
        for (int i = 0; i < resp2.size(); i++) {
            CartaJavSc temp = resp2.get(i);
            if (!temp.getDato().equals("99")) {
                resp1.add(temp);
            }
        }
        return resp1;
    }

    /**
     * Esta funcion le brinda todos los jugadores(como objeto) de una sala 
     * especifica.
     * @param idSala El identificador de la sala.
     * @return tt Retrona una lista de tipo Jugador con todos los jugadores 
     * de la sala especificada.
     * @throws CartModeException Genera una excepcion cuando ocurre un error.
     */
    public List<Jugador> getJugadoresByIdSala(Integer idSala) throws CartModeException {
        Sala t = salas.get(idSala);
        List<Jugador> tt = t.getJugadores();
        return tt;
    }

    /**
     * Genera la baraja de cartas deacuerdo al nivel de la carta.
     * @param nivel Nivel de la baraja generada.
     * @return resp Retorna una lista de tipo CartaJavSc con la baraja de cartas 
     * deacuerdo al nivel solicitado.
     * @throws CartModeException Genera una excepcion cuando ocurre un error.
     */
    @Override
    public List<CartaJavSc> GenerateBaraja(Integer nivel) throws CartModeException {
        List<CartaJavSc> resp = new CopyOnWriteArrayList<>();
        Random rnd = new Random();
        if (nivel == 1) {
            for (int i = 0; i < 8; i++) {
                resp.add(new CartaJavSc(Integer.toString(i + 1), false));
            }
        } else if (nivel == 2) {
            boolean t = true;
            for (int i = 0; i < 12; i++) {
                if (t) {
                    resp.add(new CartaJavSc(Integer.toString(i + 1), false));
                    t = false;
                } else if (!t) {
                    String tempg = abecedario.get(i);
                    resp.add(new CartaJavSc(tempg, false));
                    t = true;
                }
            }
            resp.add(new CartaJavSc(Integer.toString(99), false));
        } else if (nivel == 3) {
            boolean t = true;
            for (int i = 0; i < 10; i++) {
                if (t) {
                    resp.add(new CartaJavSc(Integer.toString(i + 1), false));
                    t = false;
                } else if (!t) {
                    String tempg = abecedario.get(i);
                    resp.add(new CartaJavSc(tempg, false));
                    t = true;
                }
            }
        }
        return resp;
    }

    /**
     *  Retorna la lista de salas activas en todo el juego.
     * @return salas Retorna la lista con todas las salas del juego.
     * @throws CartModeException Genera una excepcion cuando ocurre un error.
     */
    @Override
    public List<Sala> getSala() throws CartModeException {
        return salas;
    }

    /**
     * Retorna el identificador de la sala de un Jugador en especifico.
     * @param nombre El nombre del jugador
     * @return Integer Identificador de sala.
     * @throws CartModeException Genera una excepcion cuando ocurre un error.
     */
    @Override
    public Integer getIdSalaByPlayer(String nombre) throws CartModeException {
        int resp = -1;
        for (Jugador ht : player) {      //System.out.println("que comparamos : "+ht.getNickName()+"contra :"+nombre);
            if (ht.getNickName().equals(nombre)) {
                resp = ht.getSala();
            }
        }
        return resp;
    }

    /**
     * Retorna los nombres de todos los juagdores por una sala especifica.
     * @param idSala El identificador de la sala.
     * @return resp Retorna una lista de tipo String con todos los nombres de 
     * los jugadores de una sala.
     * @throws CartModeException Genera una excepcion cuando ocurre un error.
     */
    @Override
    public List<String> getAllPlayersBySala(Integer idSala) throws CartModeException {
        List<String> resp = new CopyOnWriteArrayList<>();
        for (Jugador ht : player) {
            if (ht.getSala() == idSala) {
                resp.add(ht.getNickName());
            }
        }
        return resp;
    }

    /**
     * Retorna el anfitrion de una sala en especifico.
     * @param idSala El identificador de la sala
     * @return Jugador El jugador anfitrion de la sala.
     * @throws CartModeException Genera una excepcion cuando ocurre un error.
     */
    @Override
    public Jugador getPlayerAnfiBySala(Integer idSala) throws CartModeException {
        Jugador resp = new Jugador();
        resp.setNickName("ninguno");
        for (Sala re : salas) {
            if (re.getId() == idSala) {
                resp = re.getJugadorAnfrition();
            }
        }
        return resp;
    }

    /**
     * Regresa una lista de listas con los nombres de la sala
     * @param name NOmbre de jugador
     * @return resp Retorna una lista de de listas tipo string con los nombres 
     * del juego.
     * @throws CartModeException Genera una excepcion cuando ocurre un error.
     */
    @Override
    public List<List<String>> getPlayersBySala(String name) throws CartModeException {
        List<List<String>> resp = new CopyOnWriteArrayList<>();        //Segundo arreglo
        List<String> refin = new CopyOnWriteArrayList<>();
        for (Sala sal : salas) {
            List<Jugador> temp = sal.getJugadores();
            refin.clear();
            for (Jugador ju : temp) {
                refin.add(ju.getNickName());
            }
            resp.add(refin);
        }
        return resp;
    }

    /**
     * Retorna la lista de preguntas ya configuradas. 
     * @return preguntas Retorna la lista de tipo ListPregunta que representa 
     * la lista de preguntas del juego.
     * @throws CartModeException Genera una excepcion cuando ocurre un error.
     */
    @Override
    public List<Pregunta> getListPreguntas() throws CartModeException {
        return preguntas;
    }

    /**
     * Esta funcion elimina todos los usuarios y salas del juego.
     * @throws CartModeException Genera una excepcion cuando ocurre un error.
     */
    @Override
    public void eraseAll() throws CartModeException {
        player.clear();
        salas.clear();
    }

    /**
     * Esta funcion indica si el usuario pasado como parametro es o no 
     * anfitrion de la sala pasada como parametro.
     * @param nombre NOmbre del jugador a consultar.
     * @param sala Identificador de la sala consultada.
     * @return Boolean Retorna un valor booleano que representa si el jugador 
     * es el anfitrion de la sala o no.
     * @throws CartModeException Genera una excepcion cuando ocurre un error.
     */
    
    @Override
    public Boolean isPlayerAnfitrion(String nombre, Integer sala) throws CartModeException {
        Boolean resp1 = false;
        Jugador resp = new Jugador();
        resp.setNickName("ninguno");
        for (Sala re : salas) {
            if (re.getId() == sala) {
                resp = re.getJugadorAnfrition();
            }
        }
        String y = resp.getNickName();
        if (y.equals(nombre)) {
            resp1 = true;
        }
        return resp1;
    }

    /**
     * Esta funcion retorna un valor booleano donde indica si el jugador pasado 
     * como parametro es o no anfrition de la sala indicada.
     * @param idSala Sala a consultar.
     * @param jugador A consultar en la sala.
     * @return Boolean Que representa si ese jugador es o no es el anfriotion.
     * @throws CartModeException Genera una excepcion cuando ocurre un error.
     */
    @Override
    public Boolean IsAnfitrion(Integer idSala, Jugador jugador) throws CartModeException {
        Boolean resp=false;
        Sala fu=salas.get(idSala);
        if(fu.getJugadorAnfrition().getNickName().equals(jugador.getNickName())){
            resp=true;
        }
        return resp;
    }    
    
    /**
     * Esta funcion cmbia el estado de la sala indicada, y la cierra  a que otros jugadores entren en ella.
     * @param idlista El identificador de la sala.
     * @throws CartModeException Genera una excepcion cuando ocurre un error.
     */
    @Override
    public void SetStade(Integer idlista) throws CartModeException {
        System.out.println("Si legamos:" + idlista);
        Sala o = salas.get(idlista);
        o.setListo(true);
    }

    /**
     * Retorna la sala con el identificador que se le paso como parametro.
     * @param idlista Integer El identificAdor de la sala.
     * @return Sala Que tiene el Id que se le paso como parametro.
     * @throws CartModeException Genera una excepcion cuando ocurre un error.
     */
    @Override
    public Sala getSalaById(Integer idlista) throws CartModeException {
        return salas.get(idlista);
    }

    /**
     * Retorna un valor booleano que indica si la sala esta o no lista.
     * @param idSala Representa el id de la sala.
     * @return Boolean El valor que representa si la sala indicada esta o no 
     * lista. (si inicio o no partida.)
     * @throws CartModeException Genera una excepcion cuando ocurre un error.
     */
    @Override
    public Boolean getListoSala(Integer idSala) throws CartModeException {
        return salas.get(idSala).getListo();
    }

    /**
     * Esta funcion eleva el nivel de la sala pasada como parametro.
     * @param idSala El identificador de la sala que se elevara su nivel.
     * @throws CartModeException Genera una excepcion cuando ocurre un error.
     */
    
    @Override
    public void levelOfSalaId(Integer idSala) throws CartModeException {
        for (Sala sa : salas) {  //System.out.println("que comparamps : "+sa.getId()+" con : "+idSala);
            if (sa.getId().equals(idSala) && sa.getNivel() < 4) {
                System.out.println("modificando el puntaje DE LA SALA :" + idSala);
                System.out.println("ES :" + sa.getNivel());
                int tem = sa.getNivel();
                //tem++;
                sa.setNivel(tem + 1);
                System.out.println("QUEDA EN  :" + sa.getNivel());
            }
        }
    }

    /**
     * Retorna el nivel que tenga actualemente la sala que se pasa por 
     * parametro.
     * @param idSala El identificador de la sala a buscar.
     * @return Integer Un entero que representa el nivel en el que se encuentra 
     * la sala.
     * @throws CartModeException Genera una excepcion cuando ocurre un error.
     */
    
    @Override
    public Integer LevelOfSala(Integer idSala) throws CartModeException {
        int resp = 0;
        for (Sala sa : salas) {
            System.out.println("que comparamps : " + sa.getId() + " con : " + idSala);
            if (sa.getId().equals(idSala)) {
                resp = sa.getNivel();
            }
        }
        return resp;
    }

    /**
     * Regresa el jugador asociado al nombre pasado como parametro.
     * @param name Nombre del jugador
     * @return Jugador El objeto jugador que se asocie al nombre pasado como 
     * parametro.
     * @throws CartModeException Genera una excepcion cuando ocurre un error.
     */
    @Override
    public Jugador getPlayerByName(String name) throws CartModeException {
        Jugador temp = new Jugador();
        for (Jugador ja : player) {
            if (ja.getNickName().equals(name)) {
                temp = ja;
            }
        }
        return temp;
    }

    /**
     * Esta funcion remplaza al jugador que se encuentre en el arreglo de 
     * jugadores. Por el que se pasa como parametro.
     * @param play El Objeto jugador que reemplazara los datos del mismo jugador
     * en la lista de jugadores.
     * @throws CartModeException Genera una excepcion cuando ocurre un error.
     */
    
    public void setPlayerByName(Jugador play) throws CartModeException {
        int ind = player.indexOf(play);
        System.out.println("que improme int" + ind);
        player.set(ind, play);
    }

    /**
     * Esta funcion retorn una pregunta de la lista de preguntas.
     * @return Pregunta El objeto pregunta que contiene una pregunta que 
     * respondera el usuario.
     * @throws CartModeException Genera una excepcion cuando ocurre un error.
     */
    @Override
    public Pregunta getPregunta() throws CartModeException {
        Pregunta resp = new PreguntaSeleecionMultiple();
        int valorEntero = (int) Math.floor(Math.random() * (preguntas.size()));
        resp = preguntas.get(valorEntero);
        return resp;
    }
    
    static {
        player = new CopyOnWriteArrayList<>();
        salas = new CopyOnWriteArrayList<>();
        abecedario = new CopyOnWriteArrayList<>();
        preguntas = new CopyOnWriteArrayList<>(); //Creando las preguntas
        opcionesrespuesta = new ArrayList<String>();
        opcionesrespuesta.add("2x");
        opcionesrespuesta.add("180");
        opcionesrespuesta.add("Imposible");
        opcionesrespuesta.add("300000");
        opcionesrespuesta.add("1");
        opcionesrespuesta.add("Infinitas");
        Pregunta pregunta1 = new PreguntaSeleecionMultiple(1, "??Cuanto es la derivada de x??2?", "Matematicas", opcionesrespuesta, "2x");
        Pregunta pregunta2 = new PreguntaSeleecionMultiple(2, "??Cuanto es la suma de los ??ngulos internos de un triangulo?", "Matematicas", opcionesrespuesta, "180");
        Pregunta pregunta3 = new PreguntaSeleecionMultiple(3, "??Cual es el resultado de operar 1390/0?", "Matematicas", opcionesrespuesta, "Imposible");
        Pregunta pregunta4 = new PreguntaSeleecionMultiple(4, "??Cual es la velocidad de la luz en el vaci??? m/s", "Matematicas", opcionesrespuesta, "300000");
        Pregunta pregunta5 = new PreguntaSeleecionMultiple(5, "??Cuanto es la derivada de x?", "Matematicas", opcionesrespuesta, "1");
        Pregunta pregunta6 = new PreguntaSeleecionMultiple(6, "??En grados, cuanto es la mitad de una circunferencia?", "Matematicas", opcionesrespuesta, "180");
        Pregunta pregunta7 = new PreguntaSeleecionMultiple(7, "!??Si cayeras por un risco infinito!, ??Podr??as alcanzar la velocidad de la luz ?", "Matematicas", opcionesrespuesta, "Imposible");
        Pregunta pregunta8 = new PreguntaSeleecionMultiple(8, "??Que cantidad de posibles jugadas hay en el ajedrez?", "Matematicas", opcionesrespuesta, "Infinitas");
        Pregunta pregunta9 = new PreguntaSeleecionMultiple(9, "??Cuanto ama Morgan Start a su padre?", "Matematicas", opcionesrespuesta, "300000");
        Pregunta pregunta10 = new PreguntaSeleecionMultiple(10, "??Existe una ecuaci??n para calcular numero primos?", "Matematicas", opcionesrespuesta, "Imposible");
        preguntas.add(pregunta1);
        preguntas.add(pregunta2);
        preguntas.add(pregunta3);
        preguntas.add(pregunta4);
        preguntas.add(pregunta5);
        preguntas.add(pregunta6);
        preguntas.add(pregunta7);
        preguntas.add(pregunta8);
        preguntas.add(pregunta9);
        preguntas.add(pregunta10);        //
        contador = 0;
        temporal = null;
        abecedario.add("a");
        abecedario.add("b");
        abecedario.add("c");
        abecedario.add("d");
        abecedario.add("e");
        abecedario.add("f");
        abecedario.add("g");
        abecedario.add("h");
        abecedario.add("i");
        abecedario.add("j");
        abecedario.add("k");
        abecedario.add("l");
    }

}
