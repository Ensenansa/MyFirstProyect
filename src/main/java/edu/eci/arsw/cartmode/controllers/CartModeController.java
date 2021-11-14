
package edu.eci.arsw.cartmode.controllers;

import edu.eci.arsw.cartmode.model.Jugador;
import edu.eci.arsw.cartmode.model.Sala;
import edu.eci.arsw.cartmode.services.CartModeException;
import edu.eci.arsw.cartmode.services.CartModeServices;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author cesar
 *
 */
@RestController
@RequestMapping(value = "/jugadores")
public class CartModeController {

    @Autowired
    private CartModeServices cat;
    private Map<String, List<String>> puntJugador = new HashMap<String, List<String>>();
    private Map<String, Integer> namePlayers = new HashMap<String, Integer>();
    
    private List<String> distingidores=new ArrayList<String>();
    /**
     * Un constructor vacio donde se cargan los valores que serviran para el 
     * distingidor.
     */
    public  CartModeController (){
        distingidores.add("0");
        distingidores.add("1");
        distingidores.add("2");
        distingidores.add("3");
        distingidores.add("4");
        distingidores.add("5");
        distingidores.add("6");
        distingidores.add("7");
        distingidores.add("8");
        distingidores.add("9");
        distingidores.add("10");
        distingidores.add("a");
        distingidores.add("b");
        distingidores.add("c");
        distingidores.add("d");
        distingidores.add("e");
        distingidores.add("f");
        distingidores.add("g");
        distingidores.add("h");
        distingidores.add("i");
        distingidores.add("j");
        distingidores.add("k");
        distingidores.add("l");
        distingidores.add("m");
        distingidores.add("n");            
    }
    
    /**
     * Este metodo retorna todos los jugadores que se encuentren en una sala 
     * esoecifica.
     * @return CopyOnWriteArrayList
     */
    @RequestMapping(method = RequestMethod.GET, path = "/all")
    public ResponseEntity<?> getAllJugadores() {
        try {
            return new ResponseEntity<>(cat.nameAllPlayer(), HttpStatus.ACCEPTED);
        } catch (CartModeException ex) {
            Logger.getLogger(CartModeController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(method = RequestMethod.GET, path = "/all/h")
    public ResponseEntity<?> getHola() {
        return new ResponseEntity<>("hola mundo", HttpStatus.ACCEPTED);
    }
/**
 *  Retorna todos los jugadores de una sala pasando por parametro un nombre.
 * @param nombre Nombre del jugador a buscar
 * @return ResponseEntity Con la representacion de las listas con los 
 * jugadores de una sala dada.
 */
    @GetMapping("/{nombre}")
    public ResponseEntity<?> getAllJugadoresBySala(@PathVariable String nombre) {
        try {
            return new ResponseEntity<>(cat.getPlayersBySala(nombre), HttpStatus.ACCEPTED);
        } catch (CartModeException ex) {
            Logger.getLogger(CartModeController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
        }
    }
/**
 * Esta funcion me trae la cantidad de jugadores que tiene una sala.
 * @param id El identificador de la sala a consultar.
 * @return ResponseEntity La cantidad de todos los jugadores de una sala.
 */
    @GetMapping("sala/cantidad/{id}")
    public ResponseEntity<?> getCantPlayerOfSala(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(cat.allPlayerOfSala(id), HttpStatus.ACCEPTED);
        } catch (CartModeException ex) {
            Logger.getLogger(CartModeController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
        }
    }
   /**
    * Retorna un valor numerico para seleccinoar un valor para el distinguidor.
    * @return Integer Un valor que este entre el tamaño del arreglo.
    */ 
    public Integer getAleatoroVal(){
        int valorEntero = (int) Math.floor(Math.random() * distingidores.size()-1);
        return valorEntero;
    }
      /**
       * Esta funcion agrega un  nuevo jugador al juego.
       * @param nombre El nombre que identificara al nuevo jugador
       * @return ResponseEntity La representacion en String del jugador 
       * creado.
       */  
    @GetMapping("add/{nombre}")
    public ResponseEntity<?> addNewPlayers(@PathVariable String nombre) {
        List<String> nombres = new ArrayList<String>();        
        try {
            if (cat.getSala().isEmpty()) {
                cat.addPlayer(nombre);
                Jugador temp = cat.getPlayerByName(nombre);
                int resp = cat.getIdSalaByPlayer(nombre);
            } else {
                if (cat.getSalaDisponible() == -1) {
                    cat.addPlayer(nombre);
                    Jugador temp = cat.getPlayerByName(nombre);
                    int resp = cat.getIdSalaByPlayer(nombre);
                }else{
                    int valorEntero = getAleatoroVal();
                    List<Sala> tp=cat.getSala();
                    String nomn= "";
                    int idsala=cat.getSalaDisponible();
                    List<String>nomc=cat.getNamePlayersBySala(idsala);
                    for(String g:nomc){
                        if(nombre.equals(g)){
                            while(namePlayers.containsKey(nombre+distingidores.get(valorEntero))){                            
                                valorEntero=getAleatoroVal();
                            }                         
                            namePlayers.put(nombre+distingidores,idsala);
                            nomn=nombre+distingidores.get(valorEntero);
                            nombre=nomn;        
                        }                    
                    }
                    cat.addPlayer(nombre);                    
                }
            }
            Jugador temp = cat.getPlayerByName(nombre);
            int resp = cat.getIdSalaByPlayer(nombre);
            return new ResponseEntity<>(temp, HttpStatus.ACCEPTED);
        } catch (CartModeException ex) {
            Logger.getLogger(CartModeController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
        }
    }//DATOS DEL JUGADOR
    /**
     * Retorna toda  la informacion de todos los jugadores.
     * @return ResponseEntity La representacion en String de todos los 
     * jugadores que estan actualmente en el juego.
     */
    @RequestMapping(method = RequestMethod.GET, path = "/datos")
    public ResponseEntity<?> getDataJugadores() {
        try {
            return new ResponseEntity<>(cat.nameAlPlayer(), HttpStatus.ACCEPTED);
        } catch (CartModeException ex) {
            Logger.getLogger(CartModeController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
        }
    }
/**
 * Retorna toda la informacin de los jugadores de una sala especifica.
 * @param id El identificador de la sala.
 * @return La representacion en String de todos los 
 * jugadores que estan actualmente en una sala especifica.
 */
    @RequestMapping(method = RequestMethod.GET, path = "/datos/idsala/{id}")
    public ResponseEntity<?> getDataJugadoresIdSala(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(cat.getJugadoresByIdSala(id), HttpStatus.ACCEPTED);
        } catch (CartModeException ex) {
            Logger.getLogger(CartModeController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
        }
    }
/**
 * Retorna todas las salas que esten en la aplicacion.
 * @return ResponseEntity La representacion en String de todas las salas que 
 * esten en la aplicacion.
 */
    @RequestMapping(method = RequestMethod.GET, path = "/sala")
    public ResponseEntity<?> getSalas() {
        try {
            return new ResponseEntity<>(cat.getSala(), HttpStatus.ACCEPTED);
        } catch (CartModeException ex) {
            Logger.getLogger(CartModeController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
        }
    }
/**
 * Retorna el identificador de la sala a la cual pertenece el nombre del jugador
 * pasado como parametro.
 * @param nombre El nombre del jugador.
 * @return ResponseEntity  La representacion en String del identificador de 
 * la sala.
 */
    @RequestMapping(method = RequestMethod.GET, path = "/sala/{nombre}")
    public ResponseEntity<?> getSalasIdByPlayer(@PathVariable String nombre) {
        try {
            return new ResponseEntity<>(cat.getIdSalaByPlayer(nombre), HttpStatus.ACCEPTED);
        } catch (CartModeException ex) {
            Logger.getLogger(CartModeController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
        }
    }
/**
 *  Retorna el valor booleano del estado de una sala que se paso como parametro.
 * @param id  El identificador de la sala a buscar.
 * @return ResponseEntity La representacion en String del valor del 
 * booleano del estado de la sala consultada.
 */
    @RequestMapping(method = RequestMethod.GET, path = "/sala/listo/{id}")
    public ResponseEntity<?> getListoSalas(@PathVariable String id) {
        try {
            int idsala = Integer.parseInt(id);
            return new ResponseEntity<>(cat.getListoSala(idsala), HttpStatus.ACCEPTED);
        } catch (CartModeException ex) {
            Logger.getLogger(CartModeController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
        }
    }
/**
 * Retorna todos los jugadores de una sala en especifico.
 * @param sala l identificador de una sala.
 * @return ResponseEntity  La representacion en String de todos los 
 * jugadores de la sala consultada.
 */
    @RequestMapping(method = RequestMethod.GET, path = "/players/{sala}")
    public ResponseEntity<?> getPlayersBySala(@PathVariable Integer sala) {
        try {
            return new ResponseEntity<>(cat.getAllPlayersBySala(sala), HttpStatus.ACCEPTED);
        } catch (CartModeException ex) {
            Logger.getLogger(CartModeController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
        }
    }
/**
 * Retorna el jugador anfitrion de una sala especifica.
 * @param sala El identificador de la sala.
 * @return  ResponseEntity  La representacion en String del objeto jugador
 * que representa al jugador anfriotion de esa sala.
 */
    @RequestMapping(method = RequestMethod.GET, path = "/playAnfi/{sala}")
    public ResponseEntity<?> getAnfritionPlayerBySala(@PathVariable Integer sala) {
        try {
            return new ResponseEntity<>(cat.getPlayerAnfiBySala(sala), HttpStatus.ACCEPTED);
        } catch (CartModeException ex) {
            Logger.getLogger(CartModeController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Esta funcion regresa el valor booleano de saber si el jugador pasado 
     * como parametro es o no el anfitrion del identificador de la sala pasado
     * como parametro.
     * @param sala  Identificador de la sala.
     * @param nombre Identificador del jugador de la sala.
     * @return ResponseEntity  La representacion en String del valor 
     * booleano del resultado de si el jugador es o no el anfitrion de la sala.
     */
    @RequestMapping(method = RequestMethod.GET, path = "/playAnfi/{sala}/{nombre}")
    public ResponseEntity<?> IsAnfritionPlayerOfSala(@PathVariable Integer sala, @PathVariable String nombre) {
        try { //Mejorar esto con la funcion de callback de javascript
            return new ResponseEntity<>(cat.isPlayerAnfitrion(nombre, sala), HttpStatus.ACCEPTED);
        } catch (CartModeException ex) {
            Logger.getLogger(CartModeController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
        }
    }
/**
 * Esta funcion aumenta el nivel de la sala.
 * @param sala El identificador de la sala.
 * @return ResponseEntity La representacion en String del valor del nuevo
 * nivel de la sala.
 */
    @RequestMapping(method = RequestMethod.GET, path = "/nivel/{sala}")
    public ResponseEntity<?> getLevelOfSala(@PathVariable Integer sala) {
        try {
            int t = cat.LevelOfSala(sala);
            return new ResponseEntity<>(t, HttpStatus.ACCEPTED);
        } catch (CartModeException ex) {
            Logger.getLogger(CartModeController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
        }
    }

/**
 *  Esta funcion aumenta el puntaje por las preguntas contestadas correctamete.
 * @param correcto Indica el estado de la respuesta.
 * @param nombre El nombre del jugador que resolvio la pregunta.
 * @throws CartModeException Genera una excepcion cuando ocurre un error. 
 */
    @RequestMapping(method = RequestMethod.POST, path = "/puntajePregunta/{nombre}/{correcto}")
    public void addScoreByPregunta(@PathVariable String correcto, @PathVariable String nombre) throws CartModeException {
        int contador = 0;
        if (correcto.equals("1")) {
            Jugador f = cat.getPlayerByName(nombre);
            int cont = f.getPuntaje();
            int contp=f.getNumCorrrectas();
            f.setnumCorrrectas(contp+1);
            cont += 50;
            f.setPuntaje(cont);
            cat.setPlayerByName(f);
        }
    }
}
