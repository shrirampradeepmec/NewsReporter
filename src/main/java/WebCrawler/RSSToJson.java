package WebCrawler;

import java.util.ArrayList;
import java.util.List;

import javax.speech.EngineException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

public class RSSToJson {
	
	String[] title = new String[4];
	String[] des = new String[4];
	
	public JSONObject getJSON(String RSS){
		
		JSONObject JSONobj = null;
		
		try {
			JSONobj = XML.toJSONObject(RSS);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return JSONobj;
		
	}
	public static List<String[]> convertRSSToJson(String RSS) throws JSONException, EngineException{
		
		RSSToJson rssToJson = new RSSToJson();
		
		JSONObject JSONobj = rssToJson.getJSON(RSS);
		MongoDB.insertIntoDb(JSONobj);
		
		JSONObject J1 = JSONobj.getJSONObject("rss");
	    JSONObject J2 = J1.getJSONObject("channel");
	    JSONArray J3 = J2.getJSONArray("item");
	    
	    return rssToJson.readAndDisplayNews(J3);
        
	}
	
	private List<String[]> readAndDisplayNews(JSONArray J3) throws JSONException, EngineException{
		
		List<String[]> list = new ArrayList<String[]>();
		
		for(int i=0;i<4;i++){
            
			System.out.println("\n");
            
			JSONObject J4 = J3.getJSONObject(i);
            
			title[i] = J4.getString("title");
			
            String description = J4.getString("description");
            
            StringBuffer buffer = new StringBuffer();
            
            for(int j=0;j<description.length();j++){
               
            	
                if((description.charAt(j))=='<'){
                    while(description.charAt(j)!='>'){
                        j++;
                    }
                }
                else{
                    if(description.charAt(j)=='&'){
                        while(description.charAt(j)!=';'){
                            j++;
                        }
                        j++;   
                    }
                    buffer.append(description.charAt(j));
                }       
            }
            
            des[i] = buffer.toString();
        
		}
		
		list.add(title);
		list.add(des);
		
		return list;
		
	}
	
}
