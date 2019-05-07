/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.cartmode.controllers;

import edu.eci.arsw.cartmode.model.Jugador;
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
//@Service
//@CrossOrigin("*")
@RestController
@RequestMapping(value = "/jugadores")
public class CartModeController {

    @Autowired
    private CartModeServices cat;
    private Map<String, List<String>> puntJugador = new HashMap<String, List<String>>();

    /**
     *
     * @return CopyOnWriteArrayList
     */
    List<String> tr = new ArrayList<>();

    @RequestMapping(method = RequestMethod.GET, path = "/all")
    public ResponseEntity<?> getAllJugadores() {
        try {
            return new ResponseEntity<>(cat.nameAllPlayer(), HttpStatus.ACCEPTED);
        } catch (CartModeException ex) {
            Logger.getLogger(CartModeController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<?> getAllJugadoresBySala(@PathVariable String nombre) {
        try {
            return new ResponseEntity<>(cat.getPlayersBySala(nombre), HttpStatus.ACCEPTED);
        } catch (CartModeException ex) {
            Logger.getLogger(CartModeController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("add/{nombre}")
    public ResponseEntity<?> addNewPlayers(@PathVariable String nombre) {
        try {
            cat.addPlayer(nombre);
            int resp = cat.getIdSalaByPlayer(nombre);
            return new ResponseEntity<>(resp, HttpStatus.ACCEPTED);
        } catch (CartModeException ex) {
            Logger.getLogger(CartModeController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
        }
    }

    //DATOS DEL JUGADOR
    @RequestMapping(method = RequestMethod.GET, path = "/datos")
    public ResponseEntity<?> getDataJugadores() {
        try {
            return new ResponseEntity<>(cat.nameAlPlayer(), HttpStatus.ACCEPTED);
        } catch (CartModeException ex) {
            Logger.getLogger(CartModeController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/datos/idsala/{id}")
    public ResponseEntity<?> getDataJugadoresIdSala(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(cat.getJugadoresByIdSala(id), HttpStatus.ACCEPTED);
        } catch (CartModeException ex) {
            Logger.getLogger(CartModeController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/sala")
    public ResponseEntity<?> getSalas() {
        try {
            return new ResponseEntity<>(cat.getSala(), HttpStatus.ACCEPTED);
        } catch (CartModeException ex) {
            Logger.getLogger(CartModeController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/sala/{nombre}")
    public ResponseEntity<?> getSalasIdByPlayer(@PathVariable String nombre) {
        try {

            return new ResponseEntity<>(cat.getIdSalaByPlayer(nombre), HttpStatus.ACCEPTED);
        } catch (CartModeException ex) {
            Logger.getLogger(CartModeController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
        }
    }

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

    @RequestMapping(method = RequestMethod.GET, path = "/players/{sala}")
    public ResponseEntity<?> getPlayersBySala(@PathVariable Integer sala) {
        try {
            return new ResponseEntity<>(cat.getAllPlayersBySala(sala), HttpStatus.ACCEPTED);
        } catch (CartModeException ex) {
            Logger.getLogger(CartModeController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/playAnfi/{sala}")
    public ResponseEntity<?> getAnfritionPlayerBySala(@PathVariable Integer sala) {
        try {
            return new ResponseEntity<>(cat.getPlayerAnfiBySala(sala), HttpStatus.ACCEPTED);
        } catch (CartModeException ex) {
            Logger.getLogger(CartModeController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/playAnfi/{sala}/{nombre}")
    public ResponseEntity<?> IsAnfritionPlayerOfSala(@PathVariable Integer sala, @PathVariable String nombre) {
        try {
            //Mejorar esto con la funcion de callback de javascript
            return new ResponseEntity<>(cat.isPlayerAnfitrion(nombre, sala), HttpStatus.ACCEPTED);
        } catch (CartModeException ex) {
            Logger.getLogger(CartModeController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/nivel/{sala}")
    public ResponseEntity<?> getLevelOfSala(@PathVariable Integer sala) {
        try {

            System.out.println("que viene de sala : " + sala);
            int t = cat.LevelOfSala(sala);
            System.out.println("que vemos sala : " + t);
            return new ResponseEntity<>(t, HttpStatus.ACCEPTED);
        } catch (CartModeException ex) {
            Logger.getLogger(CartModeController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST, path = "/puntaje/{nombre}/{puntos}")
    public ResponseEntity<?> addScore(@PathVariable String[] puntos, @PathVariable String nombre) throws CartModeException {
        List<String> pnOK = new CopyOnWriteArrayList<String>();
        List<String> pnOK2 = new CopyOnWriteArrayList<String>();
        List<String> tempS = new CopyOnWriteArrayList<String>();
        int contador = 0;
        //NUevo array para almacenar las nuevas parejas
        List<String> nuevoArrayP = new CopyOnWriteArrayList<String>();
        //
        System.out.println("nombre" + nombre);

        List<String> prueba = Arrays.asList(puntos);
        System.out.println("puntos" + prueba.toString());
        if (puntJugador.containsKey(nombre)) {
            System.out.println("ENtramos jugador ya existia");
            pnOK = puntJugador.get(nombre);
            
            
            System.out.println("puntos DEaARRAYLIST" + pnOK.toString());
            int list1 = pnOK.size();
            int list2 = prueba.size();//los de prueba son losnuevos, asi que compararemos a esta con los anteriores.
            int a = 0;//pnOK
            int b = 0;//prueba
            while (a < list1 && b < list2) {
                System.out.println("que es a "+a);
                System.out.println("que es b "+b);
                String temOKr = pnOK.get(a);
                System.out.println("que es temok : "+temOKr);
                String tempPr = prueba.get(b);
                System.out.println("que es tempPr : "+tempPr);
                //System.out.println("ejecuta la igualdad : "+!tempPr.equals(temOKr));
                //System.out.println("Y esta otra : "+ (a == (list1 - 1)));
                if (tempPr.equals(temOKr)) {
                    a++;
                    b++;
                } else if (!tempPr.equals(temOKr) && a < list1 - 1) {
                    a++;
                } else if (!tempPr.equals(temOKr) && a == list1 - 1) {
                    contador++;
                    System.out.println("como va el tempPr : "+tempPr);
                    //nuevoArrayP.
                    nuevoArrayP.add(tempPr);
                    
                    b++;
                    System.out.println("paso "+b);
                    int c=b;
                    System.out.println("que es a"+c);
                    a=c;
                    System.out.println("que es a"+a);
                }
            }

        } else {
            System.out.println("ENtramos jugador nuevo");
            

            for (int y = 0; y < prueba.size(); y++) {
                String tem = prueba.get(y);
                contador += 1;
            }
            puntJugador.put(nombre, prueba);
        }

        //System.out.println("que es temp : " + tempS.toString() + "y su longitud : " + tempS.size());
        Jugador f = cat.getPlayerByName(nombre);
        int cont = f.getPuntaje();
        int punta = ((contador / 2) * 100);
        //int dif = punta - cont;

        //
        System.out.println("CUANTO TENIA EL JUGADOR : " + cont);
        System.out.println("CUANTO DIO EL PUNTAJE NUEVO JUGADOR ahora : " + punta+cont);
        //System.out.println("CUANTO DIO LADIFERENCIA NUEVO JUGADOR : " + dif);
        /*
        if (dif > 0) {
            f.setPuntaje(cont + dif);
        } else {
            f.setPuntaje(cont + punta);
        }*/
        System.out.println("COON CUANTO  pyntaje QUEDA JUGADOR : " + f.getPuntaje());
        //f.setPuntaje(cont + dif); punta+cont
        f.setPuntaje(punta+cont); 
        cat.setPlayerByName(f);
        return new ResponseEntity<>("", HttpStatus.ACCEPTED);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/puntajePregunta/{nombre}/{correcto}")
    public void addScoreByPregunta(@PathVariable String correcto, @PathVariable String nombre) throws CartModeException {
        int contador = 0;
        System.out.println("nombre" + nombre);
        System.out.println("puntos" + correcto);
        if (correcto.equals("1")) {
            System.out.println("pregunta correcta, subido");
            Jugador f = cat.getPlayerByName(nombre);
            int cont = f.getPuntaje();
            cont += 50;
            f.setPuntaje(cont);
            cat.setPlayerByName(f);

        }
    }

}
