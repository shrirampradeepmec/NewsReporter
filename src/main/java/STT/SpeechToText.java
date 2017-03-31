package STT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SpeechToText {
	
	private String getPythonFileLocation(){
        
		String pythonFile = "speechToText.py";
		return pythonFile;
	
	}
	
	private String getFileType(){
		
		String fileType = "python";
		return fileType;
	
	}
	
	public String readFromPythonOutput(){

		String input = null;
		
        try{
        	String[] callFile = {
        			getFileType(),getPythonFileLocation()
        	};
        	
        	Process process = Runtime.getRuntime().exec(callFile);
        	
            BufferedReader stdInput = new BufferedReader(new 
            InputStreamReader(process.getInputStream()));
            BufferedReader stdError = new BufferedReader(new 
            InputStreamReader(process.getErrorStream()));
            
       		while ((input = stdInput.readLine()) != null) {
       			System.err.println(input);
       		}
       
       		while ((input = stdError.readLine()) != null) {
       			System.err.println(input);
       		}
        }
        
        catch (IOException e) {

        	System.out.println("Exception");
            e.printStackTrace();
            System.exit(-1);

        }
        
        return input;
       		
	}
}
