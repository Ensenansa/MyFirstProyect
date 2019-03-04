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
public class CartModeStub implements CartModeServices{
    private static final List<Jugador> player;
    private static final List<Sala> salas;
    private static final Integer contador;
    private static final Jugador  temporal;
    
    
    public CartModeStub() {
    }

    
    
    
    @Override
    public List<String> nameAllPlayer() throws CartModeException {
        List<String> resp=new ArrayList<String>();
        for(Jugador lo : player ){
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
        Jugador playerr=new Jugador(name);
        System.out.println("Agergaando"+name);
        player.add(playerr);
        addSala(playerr);
    }
    
    
    
    @Override
    public void addSala(Jugador play) throws CartModeException {
        
        if(salas.size()==0){
                List<Jugador> kl=new ArrayList<Jugador>();
                kl.add(play);             
                Sala temp=new Sala(salas.size()+1, null,kl,play);
                salas.add(temp);
                
        }else if(salas.size()>0){
            
            int y=0;
            boolean puesto=false;
            while(y<salas.size()&& !puesto){    
                Sala op=salas.get(y);
                if(op.getJugadores().size()<4){
                    List<Jugador> tr=op.getJugadores();
                    tr.add(play);
                    op.setJugadores(tr);
                    puesto=true;
                }
                y++;
            }
            if(!puesto){
                List<Jugador> kl=new ArrayList<Jugador>();
                kl.add(play);
                Sala tmp2=new Sala(salas.size()+1, null,kl,play);
            }
        }
    }

    @Override
    public List<Carta> GenerateBaraja(Integer nivel) throws CartModeException {
        List<Carta>resp= new CopyOnWriteArrayList<>();
        Random rnd = new Random();
        if(nivel==1){
            for(int i=0;i<12;i ++){
                resp.add(new Carta(Integer.toString(i),1));
            }
        }else if(nivel==2 || nivel ==3){
            boolean t=true;
            for(int i=0; i<12;i++){
                if(t){
                    resp.add(new Carta(Integer.toString(i),nivel));                    
                    t=false;
                }else if(!t){
                    char u=(char)(rnd.nextInt(91) + 65);
                    resp.add(new Carta(Character.toString(u),nivel));                    
                    t=true;
                }
            }
        }
        return resp;
    }
    
    @Override
    public void iniciarPartida(Integer idSala, List<Jugador> players, Nivel level) throws CartModeException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void detenerPartida() throws CartModeException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void generateTblero(List<Carta> barajas, List<Pregunta> pregunta, List<Tripla<String, Boolean, Float>> respuestas) throws CartModeException {

        
        
    }    
    static{
    
    player= new CopyOnWriteArrayList<>();
    salas= new CopyOnWriteArrayList<>();
    contador=0;
    temporal=null;
    
    
    
    }

}