package WebCrawler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class WebCrawler {
	
	static String readUrl(String urlString) throws Exception {
         
         BufferedReader reader = null;
        
         try{
             URL oracle = new URL(urlString);
             URLConnection yc = oracle.openConnection();
             BufferedReader in = new BufferedReader(new InputStreamReader(
                                         yc.getInputStream()));
             String inputLine;
             inputLine = in.readLine();
             return inputLine;
            
         }finally{
             if(reader != null)
                 reader.close();
         }
    }
	
	public List<String[]> getRSSFeed(String result){
		
		try {
			
			String rss = readUrl("https://news.google.com/news/section?q="+ result+"&output=rss");
			List<String[]> list = RSSToJson.convertRSSToJson(rss);
			return list;
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	 
}
