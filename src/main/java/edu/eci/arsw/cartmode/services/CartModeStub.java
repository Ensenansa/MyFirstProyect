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
import edu.eci.arsw.cartmode.model.impl.PreguntaSeleecionMultiple;
import edu.eci.arsw.cartmode.model.impl.Tripla;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.stereotype.Service;
import java.util.Random;

/**
 *
 * @author 2098325
 */
@Service
public class CartModeStub implements CartModeServices {
    private static final List<Tablero> tableros;
    private static final List<Jugador> player;
    private static final List<Pregunta> preguntas;
    private static final  List<String>opcionesrespuesta;
    private static final List<Sala> salas;
    private static final Integer contador;
    private static final Jugador temporal;

    public CartModeStub() {
    }

    @Override
    public List<String> nameAllPlayer() throws CartModeException {
        List<String> resp = new ArrayList<String>();
        for (Jugador lo : player) {
            resp.add(lo.getNickName());
        }
        return resp;
    }

    @Override
    public List<Jugador> nameAlPlayer() throws CartModeException {
        return player;
    }

    @Override
    public void addPlayer(String name) throws CartModeException {

        Jugador play = new Jugador(name);
        System.out.println("Agergaando" + name);
        player.add(play);

        if (salas.size() == 0) {
            List<Jugador> kl = new ArrayList<Jugador>();
            play.setSala(salas.size());
            kl.add(play);
            Sala temp = new Sala(salas.size(), null, kl, play);
            salas.add(temp);

        } else if (salas.size() > 0) {
            int y = 0;
            boolean puesto = false;
            while (y < salas.size() && !puesto) {
                Sala op = salas.get(y);
                if (op.getJugadores().size() < 4) {
                    List<Jugador> tr = op.getJugadores();
                    play.setSala(salas.size() - 1);
                    tr.add(play);
                    op.setJugadores(tr);
                    puesto = true;
                }
                y++;
            }
            if (!puesto) {
                List<Jugador> kl = new ArrayList<Jugador>();
                kl.add(play);
                Sala tmp2 = new Sala(salas.size(), null, kl, null);
                salas.add(tmp2);
                //Para que tenga elid de sala correcto                          
                play.setSala(salas.size() - 1);
                Sala temp3 = salas.get(salas.size() - 1);
                temp3.setJugadorAnfrition(play);
                salas.set(salas.size() - 1, temp3);
                //Debemos setear al jugador
            }
        }

    }

    @Override
    public List<Carta> GenerateBaraja(Integer nivel) throws CartModeException {
        List<Carta> resp = new CopyOnWriteArrayList<>();
        Random rnd = new Random();
        if (nivel == 1) {
            for (int i = 0; i < 8; i++) {
                resp.add(new Carta(Integer.toString(i), 1));
            }
        } else if (nivel == 2) {
            boolean t = true;
            for (int i = 0; i < 12; i++) {
                if (t) {
                    resp.add(new Carta(Integer.toString(i), nivel));
                    t = false;
                } else if (!t) {
                    char u = (char) (rnd.nextInt(91) + 65);
                    resp.add(new Carta(Character.toString(u), nivel));
                    t = true;
                }
            }
        } else if (nivel == 3) {
            boolean t = true;
            for (int i = 0; i < 10; i++) {
                if (t) {
                    resp.add(new Carta(Integer.toString(i), nivel));
                    t = false;
                } else if (!t) {
                    char u = (char) (rnd.nextInt(91) + 65);
                    resp.add(new Carta(Character.toString(u), nivel));
                    t = true;
                }
            }
        }
        return resp;
    }

    @Override
    public Tablero iniciarPartida(Integer idSala, List<String> players, Integer level) throws CartModeException {
        generateTblero();
        return getTblero(level);
    }

        @Override
    public void iniciarPartida() throws CartModeException {
        generateTblero();
        setTableros();
    }
    
    public void setTableros() throws CartModeException{
        for(Sala sal:salas){
            sal.setTablero(getTblero(1));       
        }
    }
    
    @Override
    public void detenerPartida() throws CartModeException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Tablero getTblero(Integer level)throws  CartModeException{
        Tablero o =new Tablero();
        for(Tablero tab: tableros){
            if(tab.getNivel().equals(level)){
                o=tab;
            }
        }
        return o;
    }     
    
    @Override
    public void generateTblero() throws CartModeException {
        for(int i=0;i<3;i++){
            Tablero a=new Tablero(GenerateBaraja(i),getListPreguntas(),opcionesrespuesta,i);
            tableros.add(a);
        
        }

    }

    @Override
    public List<Sala> getSala() throws CartModeException {
        return salas;
    }

    @Override
    public Integer getSalaByPlayer(String nombre) throws CartModeException {
        int resp = -1;
        String temp = nombre.substring(1);
        for (Jugador ht : player) {
            
            if (ht.getNickName().equals(temp)) {
                resp = ht.getSala();
            }
        }
        return resp;
    }

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

    @Override
    public List<List<String>> getPlayersBySala(String name) throws CartModeException {
        List<List<String>> resp = new CopyOnWriteArrayList<>();
        //Segundo arreglo
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
    @Override
    public List<Pregunta> getListPreguntas() throws CartModeException {
        return preguntas;
    }
    static {
        tableros= new CopyOnWriteArrayList<>();
        player = new CopyOnWriteArrayList<>();
        salas = new CopyOnWriteArrayList<>();
        
        preguntas= new CopyOnWriteArrayList<>();
        //Creando las preguntas
        opcionesrespuesta=new ArrayList<String>();
        opcionesrespuesta.add("2x");
        opcionesrespuesta.add("180");
        opcionesrespuesta.add("Imposible");
        opcionesrespuesta.add("300000");
        opcionesrespuesta.add("2x");
        
        
        Pregunta pregunta1= new PreguntaSeleecionMultiple(1, "¿Cuanto es la dereviada de x¨2?", "Matematicas", opcionesrespuesta, 10.0f);
        Pregunta pregunta2= new PreguntaSeleecionMultiple(1, "¿Cuanto es la suma de los angulos internos de un triangulo?", "Matematicas", opcionesrespuesta, 10.0f);
        Pregunta pregunta3= new PreguntaSeleecionMultiple(1, "¿Cuall es el resultado de operar 1390/0?", "Matematicas", opcionesrespuesta, 10.0f);
        Pregunta pregunta4= new PreguntaSeleecionMultiple(1, "¿Cual es la velocidad de la luz en el vacio?", "Matematicas", opcionesrespuesta, 10.0f);
        Pregunta pregunta5= new PreguntaSeleecionMultiple(1, "¿Cuanto es la dereviada de x¨2?", "Matematicas", opcionesrespuesta, 10.0f);
        preguntas.add(pregunta1);
        preguntas.add(pregunta2);
        preguntas.add(pregunta3);
        preguntas.add(pregunta4);
        preguntas.add(pregunta5);
        
        //
        
        contador = 0;
        temporal = null;
        
        
        
        

    }

    @Override
    public void eraseAll() throws CartModeException {
        player.clear();
        salas.clear();
    }

    @Override
    public void printt(String ola) throws CartModeException {
        System.out.println("miremos que dice ola : "+ola);
    }

    @Override
    public Boolean isPlayerAnfitrion(String nombre, Integer sala) throws CartModeException {
        //System.out.println("cual nombre llega"+nombre);
        Boolean resp1=false;
        Jugador resp = new Jugador();
        resp.setNickName("ninguno");
        for (Sala re : salas) {
            
            if (re.getId() == sala) {
                resp = re.getJugadorAnfrition();
            }
        }
        
        String y=resp.getNickName();
        
        //System.out.println("que comparamos : "+y+" con "+nombre);
        if(y.equals(nombre)){
            resp1=true;
        }
        //System.out.println("respuesta es: "+resp1);
        return resp1;
        
    }

    @Override
    public void SetStade(Integer idlista) throws CartModeException {
        System.out.println("Si legamos:"+idlista);
        Sala o=salas.get(idlista);
        o.setListo(true);
    }

    @Override
    public Sala getSalaById(Integer idlista) throws CartModeException {
        return salas.get(idlista);
    }

    @Override
    public Boolean getListoSala(Integer idSala) throws CartModeException {
        return salas.get(idSala).getListo();
    }

    @Override
    public Integer LevelOfTablero(Integer idSala) throws CartModeException {
        int resp=0;
        for(Sala sa: salas){
            System.out.println("que comparamps : "+sa.getId()+" con : "+idSala);
            if(sa.getId().equals(idSala)){
                resp=sa.getTablero().getNivel();
            }
        
        
        }
        
        return resp;
    }



}
