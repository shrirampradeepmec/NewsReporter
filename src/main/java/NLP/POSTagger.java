package NLP;

import java.io.File;
import java.io.IOException;
import java.util.List;

import WebCrawler.WebCrawler;
import opennlp.tools.cmdline.PerformanceMonitor;
import opennlp.tools.cmdline.postag.POSModelLoader;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;

public class POSTagger {
	
	public List<String[]> POSTag(String input) throws IOException {
	
		Tokenizer tokenizer = new Tokenizer();
		StopWordElimination eliminate = new StopWordElimination();
		
		POSModel model = new POSModelLoader().load(new File("en-pos-maxent.bin"));
		
		PerformanceMonitor perfMon = new PerformanceMonitor(System.err, "sent");
		POSTaggerME tagger = new POSTaggerME(model);
	 
		perfMon.start();
		
		String[] whitespaceTokenizerLine = tokenizer.Tokenize(input);
		String[] tags = tagger.tag(whitespaceTokenizerLine);
	 
		String finalString = eliminate.eliminateStopWords(whitespaceTokenizerLine, tags);
		
		WebCrawler crawler = new WebCrawler();
		List<String[]> list = crawler.getRSSFeed(finalString);
		return list;
		
	}
	
}
