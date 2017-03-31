package NLP;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.InvalidFormatException;

public class Tokenizer {

	private String getFileLocation(){
		
		String location = "en-token.bin";
		return location;
	
	}
	
	public String[] Tokenize(String input) throws InvalidFormatException, IOException {
		
		InputStream fileLocation = new FileInputStream(getFileLocation());
		TokenizerModel model = new TokenizerModel(fileLocation);
		TokenizerME tokenizer = new TokenizerME(model);
		String tokens[] = tokenizer.tokenize(input);
	 
		fileLocation.close();
		
		return tokens;
	
	}
	
}
