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
    
    public MongoDBTest(){}
    public List<Jugador> getRespuesta(){
        return jugadores;
    }
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
    public  void insertData(String nombre,String puntaje){	
        MongoClient client = new MongoClient(uri);	
        MongoDatabase db = client.getDatabase(uri.getDatabase());	
        MongoCollection<Document> coll = db.getCollection("jugador");	
        Document master=Document.parse("{jugador:'"+nombre+"', puntaje:'"+puntaje+"'}");        	
        coll.insertOne(master);       	
        client.close();        	
    }	
 }
