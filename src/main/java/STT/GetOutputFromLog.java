package STT;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GetOutputFromLog {
	
	private String getLogFileLocation(){
        
		String logfile = "/home/shriram/Final/MainProject/out.txt";
		return logfile;
	
	}
	
	public String[] generateLog(){
		
		SpeechToText SST = new SpeechToText();
		SST.readFromPythonOutput();
		
		String currentLine = "Could not fetch output";
		String[] input = new String[5];
		BufferedReader buffer = null;
		FileReader reader = null;
		int i = 0;

		try {

			reader = new FileReader(getLogFileLocation());
			buffer = new BufferedReader(reader);

			while ((currentLine = buffer.readLine()) != null) {
				input[i] = currentLine;
				i++;
			}
		} 
		
		catch (IOException e) {
			e.printStackTrace();
		} 
		
		finally{

			try{
				if (buffer != null){
					buffer.close();
				}
				if (reader != null){
					reader.close();
				}
			} 
			
			catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return input;
	}
	
}
