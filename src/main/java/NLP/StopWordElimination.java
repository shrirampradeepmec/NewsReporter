package NLP;

public class StopWordElimination {
	
	public static final String EX = "EX";
	public static final String VBZ = "VBZ";
	public static final String CC = "CC";
	public static final String DT = "DT";
	public static final String FW = "FW";
	public static final String IN = "IN";
	public static final String jjR = "jjR";
	public static final String jjS = "jjS";
	public static final String LS = "LS";
	public static final String PDT = "PDT";
	public static final String POS = "POS";
	
	public String eliminateStopWords(String[] tokens,String[] POS){
		
		String finalString = "";
		
		for(int i=0;i<tokens.length;i++){
			
			if(POS[i].equals(EX) || POS[i].equals(VBZ) || POS[i].equals(CC) || POS[i].equals(DT) || 
					POS[i].equals(FW) || POS[i].equals(IN) || POS[i].equals(jjR) || POS[i].equals(jjS)
					|| POS[i].equals(LS) || POS[i].equals(PDT) || POS[i].equals(POS)){
				
			}
			else if(i != tokens.length - 1){
				finalString += tokens[i] + "%20";
			}
			else{
				finalString += tokens[i];
			}
		}
		
		return finalString;
	}
	
}
