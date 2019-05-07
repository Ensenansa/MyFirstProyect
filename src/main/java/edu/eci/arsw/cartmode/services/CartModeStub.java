/*/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.cartmode.services;

import edu.eci.arsw.cartmode.model.Carta;
import edu.eci.arsw.cartmode.model.CartaJavSc;
import edu.eci.arsw.cartmode.model.Jugador;
import edu.eci.arsw.cartmode.model.Nivel;
import edu.eci.arsw.cartmode.model.Pregunta;
import edu.eci.arsw.cartmode.model.Sala;
import edu.eci.arsw.cartmode.model.impl.PreguntaSeleecionMultiple;
import edu.eci.arsw.cartmode.model.impl.Tripla;
import java.util.ArrayList;
import java.util.List;
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

    public Integer getAllPlayerInGame() throws CartModeException {
        return player.size();
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
            Sala temp = new Sala(salas.size(), kl, play,0);
            salas.add(temp);

        } else if (salas.size() > 0) {
            int y = 0;
            boolean puesto = false;
            while (y < salas.size() && !puesto) {
                Sala op = salas.get(y);
                if (op.getJugadores().size() < 4&& op.getListo()!=true) {
                //if (op.getJugadores().size() < 2) {   //CAMBIAR... SOLO PAR APRUEBA Y CAMBIAR EN EL TEST
                    List<Jugador> tr = op.getJugadores();
                    play.setSala(salas.size() - 1);
                    tr.add(play);
                    op.setJugadores(tr);
                    puesto = true;
                    if(op.getJugadores().size() ==4){
                        op.setListo(true);                    
                    }
                }
                y++;
            }
            if (!puesto) {
                List<Jugador> kl = new ArrayList<Jugador>();
                kl.add(play);
                Sala tmp2 = new Sala(salas.size(), kl, null,0);
                salas.add(tmp2); //Para que tenga elid de sala correcto                          
                play.setSala(salas.size() - 1);
                Sala temp3 = salas.get(salas.size() - 1);
                temp3.setJugadorAnfrition(play);
                salas.set(salas.size() - 1, temp3);//Debemos setear al jugador
            }
        }

    }
    @Override
    public Integer allPlayerOfSala(Integer id)throws CartModeException{        
        Sala f=salas.get(id);                
        return f.getJugadores().size();
    }
    
    
    @Override
    public Integer getSalaDisponible()throws CartModeException{
        int resp=-1;
        System.out.println("fuuu");
        for(Sala sa:salas){
            if(sa.getJugadores().size()<4&& sa.getListo()!=true){
                //System.out.println("que sala pone"+sa.getId());
                resp=sa.getId();            
            }       
        }
        System.out.println("que respiuesta regresa : "+resp);
        return resp;
    }
    @Override
    public List<String> getNamePlayersBySala(Integer id)throws CartModeException{
        List<String> resp=new ArrayList<String>();
        Sala temp=salas.get(id);
        List<Jugador> ju=temp.getJugadores();
        for(Jugador tr: ju){
            resp.add(tr.getNickName());        
        }
        return resp;
    }
    
    
    
    @Override
    public List<CartaJavSc> GenerateDuplicadoBaraja(Integer nivel)throws  CartModeException{
        List<CartaJavSc> resp1 = new ArrayList<CartaJavSc>();
        List<CartaJavSc> resp2 = new ArrayList<CartaJavSc>();        
        resp1=GenerateBaraja(nivel);
        resp2=GenerateBaraja(nivel);      
        for(int i=0; i<resp2.size();i++){
            CartaJavSc temp=resp2.get(i);
            if(!temp.getDato().equals("99")){
                resp1.add(temp);
            }
        }
        return resp1;
    
    }

    public List<Jugador> getJugadoresByIdSala(Integer idSala)throws CartModeException{
        Sala t=salas.get(idSala);
        List<Jugador>tt=t.getJugadores();
        return tt;  
    }
    
    
    
    @Override
    public List<CartaJavSc> GenerateBaraja(Integer nivel) throws CartModeException {
        List<CartaJavSc> resp = new CopyOnWriteArrayList<>();
        Random rnd = new Random();
        if (nivel == 1) {
            for (int i = 0; i < 8; i++) {
                //resp.add(new Carta(Integer.toString(i), 1));
                resp.add(new CartaJavSc(Integer.toString(i + 1), false));
            }
        } else if (nivel == 2) {
            boolean t = true;
            for (int i = 0; i < 12; i++) {

                if (t) {
                    resp.add(new CartaJavSc(Integer.toString(i + 1), false));
                    t = false;
                } else if (!t) {
                    //int valorEntero = (int) Math.floor(Math.random() * (26));
                    String tempg = abecedario.get(i);
                    resp.add(new CartaJavSc(tempg, false));
                    //puestas.add(abecedario.get(valorEntero));
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
                    //puestas.add(abecedario.get(valorEntero));
                    t = true;
                }
            }
        }
        return resp;
    }

    public boolean verValor(List<String> puestas, String valor) {
        Boolean respuesta = false;
        boolean tt = false;
        for (int jj = 0; jj < puestas.size(); jj++) {
            String qq = puestas.get(jj);
            if (qq.equals(valor)) {
                tt = true;
            }
        }

        return tt;
    }
    @Override
    public void iniciarPartida() throws CartModeException {
        //generateTblero();
        setTableros();
    }

    public void setTableros() throws CartModeException {
        for (Sala sal : salas) {
            //sal.setTablero(getTblero(1));
        }
    }

    @Override
    public void detenerPartida() throws CartModeException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public List<Sala> getSala() throws CartModeException {
        return salas;
    }

    @Override
    public Integer getIdSalaByPlayer(String nombre) throws CartModeException {
        int resp = -1;
        //System.out.println("miremos nombre antes: "+nombre);
        
        //String temp = nombre.substring(1);
        //System.out.println("miremos nombre despues: "+nombre);
        for (Jugador ht : player) {
            //System.out.println("que comparamos : "+ht.getNickName()+"contra :"+nombre);
            if (ht.getNickName().equals(nombre)) {
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

    @Override
    public void eraseAll() throws CartModeException {
        player.clear();
        salas.clear();
    }

    @Override
    public void printt(String ola) throws CartModeException {
        System.out.println("miremos que dice ola : " + ola);
    }

    @Override
    public Boolean isPlayerAnfitrion(String nombre, Integer sala) throws CartModeException {
        //System.out.println("cual nombre llega"+nombre);
        Boolean resp1 = false;
        Jugador resp = new Jugador();
        resp.setNickName("ninguno");
        for (Sala re : salas) {

            if (re.getId() == sala) {
                resp = re.getJugadorAnfrition();
            }
        }

        String y = resp.getNickName();

        //System.out.println("que comparamos : "+y+" con "+nombre);
        if (y.equals(nombre)) {
            resp1 = true;
        }
        //System.out.println("respuesta es: "+resp1);
        return resp1;

    }

    @Override
    public void upLevelSalaId(Integer id) throws CartModeException {
        Sala temporal = salas.get(id);
        List<Jugador> jugado = temporal.getJugadores();

        int t=temporal.getNivel();
        temporal.setNivel(t+1);

    }

    @Override
    public void SetStade(Integer idlista) throws CartModeException {
        System.out.println("Si legamos:" + idlista);
        Sala o = salas.get(idlista);
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
    public void levelOfSalaId(Integer idSala)throws  CartModeException{
        for (Sala sa : salas) {
            //System.out.println("que comparamps : "+sa.getId()+" con : "+idSala);
            if (sa.getId().equals(idSala) && sa.getNivel()<4) {
                System.out.println("modificando el puntaje DE LA SALA :"+idSala);
                System.out.println("ES :"+sa.getNivel());
                int tem=sa.getNivel();
                //tem++;
                sa.setNivel(tem+1);
                System.out.println("QUEDA EN  :"+sa.getNivel());
            }
        }
        
    
    }
    @Override
    public Integer LevelOfSala(Integer idSala) throws CartModeException {
        int resp = 0;
        
        for (Sala sa : salas) {
            System.out.println("que comparamps : "+sa.getId()+" con : "+idSala);
            if (sa.getId().equals(idSala)) {
                resp = sa.getNivel();
            }
        }
        
        return resp;
    }

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

    public void setPlayerByName(Jugador play) throws CartModeException {
        int ind = player.indexOf(play);
        System.out.println("que improme int" + ind);
        player.set(ind, play);
    }

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
        preguntas = new CopyOnWriteArrayList<>();
        //Creando las preguntas
        opcionesrespuesta = new ArrayList<String>();
        opcionesrespuesta.add("2x");
        opcionesrespuesta.add("180");
        opcionesrespuesta.add("Imposible");
        opcionesrespuesta.add("300000");
        opcionesrespuesta.add("1");

        Pregunta pregunta1 = new PreguntaSeleecionMultiple(1, "¿Cuanto es la dereviada de x¨2?", "Matematicas", opcionesrespuesta,  "2x");
        Pregunta pregunta2 = new PreguntaSeleecionMultiple(2, "¿Cuanto es la suma de los angulos internos de un triangulo?", "Matematicas", opcionesrespuesta, "180");
        Pregunta pregunta3 = new PreguntaSeleecionMultiple(3, "¿Cuall es el resultado de operar 1390/0?", "Matematicas", opcionesrespuesta,  "Imposible");
        Pregunta pregunta4 = new PreguntaSeleecionMultiple(4, "¿Cual es la velocidad de la luz en el vacio? m/s", "Matematicas", opcionesrespuesta, "300000");
        Pregunta pregunta5 = new PreguntaSeleecionMultiple(5, "¿Cuanto es la dereviada de x?", "Matematicas", opcionesrespuesta,  "1");
        preguntas.add(pregunta1);
        preguntas.add(pregunta2);
        preguntas.add(pregunta3);
        preguntas.add(pregunta4);
        preguntas.add(pregunta5);

        //
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

    @Override
    public List<String> getNameOfPlayerBySala() throws CartModeException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}