package edu.eci.arsw.cartmode.persistence;	

 import com.mongodb.BasicDBObject;	
import com.mongodb.MongoClient;	
import com.mongodb.MongoClientURI;	
import com.mongodb.client.FindIterable;	
import com.mongodb.client.MongoCollection;	
import com.mongodb.client.MongoCursor;	
import com.mongodb.client.MongoDatabase;	
import edu.eci.arsw.cartmode.model.Jugador;
import java.util.ArrayList;	
import java.util.List;	
import org.bson.Document;	
import org.springframework.stereotype.Service;

 /**	
 *	
 * @author hcadavid	
 */	
@Service
public class MongoDBTest {	
    
    private  List<Jugador> jugadores=new ArrayList<>();	
    private MongoClientURI uri = new MongoClientURI("mongodb://Cartmode:Cartmode1@ds149875.mlab.com:49875/cartmmode");                      	
    /**
     * Constructor vacio.
     */
    public MongoDBTest(){}
    /**
     * Retorna la lista de jugadores ingresados a la base de datos.
     * @return jugadores List<Jugador> Que representa los jugadores ingresados 
     * a la base de datos.
     */
    public List<Jugador> getRespuesta(){
        return jugadores;
    }
    /**
     * Esta funcion extrae todos los datos de la base de datos.
     * Y guarda la informacion de los usuarios en el arreglo jugadores.
     */
    public  void findAndPrintData(){	
        MongoClient client = new MongoClient(uri);	
        MongoDatabase db = client.getDatabase(uri.getDatabase());        	
        MongoCollection<Document> coll = db.getCollection("jugador");        	
        BasicDBObject dbo=new BasicDBObject();		
        FindIterable<Document> res=coll.find(dbo);        	
        MongoCursor<Document> docit=res.iterator();        	
        jugadores.clear();
        while (docit.hasNext()){	
            Document doc=docit.next();	
          jugadores.add(new Jugador((String)doc.get("jugador"), Integer.parseInt((String)doc.get("puntaje"))));
        }        	
        client.close();        	
    }	
    /**
     * Esta funcion inserta los datos en la base de datos.
     * @param nombre String Que representa el nombre del jugador.
     * @param puntaje String Que representa el puntaje del jugador.
     */
    public  void insertData(String nombre,String puntaje){	
        MongoClient client = new MongoClient(uri);	
        MongoDatabase db = client.getDatabase(uri.getDatabase());	
        MongoCollection<Document> coll = db.getCollection("jugador");	
        Document master=Document.parse("{jugador:'"+nombre+"', puntaje:'"+puntaje+"'}");        	
        coll.insertOne(master);       	
        client.close();        	
    }	
 }
