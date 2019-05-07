package edu.eci.arsw.cartmode.persistence;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author hcadavid
 */
public class MongoDBTest {
    private  List<String> trr=new ArrayList<>();
    private MongoClientURI uri = new MongoClientURI("mongodb://Cartmode:Cartmode1@ds149875.mlab.com:49875/cartmmode");                
    public  void findAndPrintData(){
        
        MongoClient client = new MongoClient(uri);
        MongoDatabase db = client.getDatabase(uri.getDatabase());        
        MongoCollection<Document> coll = db.getCollection("jugador");        
        BasicDBObject dbo=new BasicDBObject();
        //dbo.append("id", 123);        
        FindIterable<Document> res=coll.find(dbo);        
        MongoCursor<Document> docit=res.iterator();        
        while (docit.hasNext()){
            Document doc=docit.next();
            System.out.println(doc.get("jugador"));
            System.out.println(doc.get("puntaje"));
            trr.add("jugador{"+"nombre="+doc.get("jugador")+","+"puntaje="+doc.get("puntaje")+"}");
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