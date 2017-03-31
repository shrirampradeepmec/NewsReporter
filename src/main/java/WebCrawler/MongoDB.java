package WebCrawler;

import org.json.JSONObject;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

public class MongoDB {
	
	public DBCollection establishLocalDB(){
		
		@SuppressWarnings("resource")
		MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
		
		@SuppressWarnings("deprecation")
		DB db = mongoClient.getDB( "Myclient" );
		DBCollection coll = db.createCollection("Client", null);
		
		return coll;
	}
	
	public static void insertIntoDb(JSONObject JSONObject){
		
		MongoDB db = new MongoDB();
		DBCollection collection = db.establishLocalDB();
		
		DBObject dbObject = (DBObject)JSON.parse(JSONObject.toString());
		
	    collection.insert(dbObject);
	
	}
	
	public void getFromDb(){
		
	}
}
