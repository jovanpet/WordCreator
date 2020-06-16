
/**
 * This class represents a string segment and what letter follows it
 */
public class LetterSample {
	private String segment;
	private char nextLetter;
	
	/**
	 * Constructor
	 * @param segment
	 * @param nextLetter
	 */
	public LetterSample(String segment, char nextLetter) {
		super();
		this.segment = segment;
		this.nextLetter = nextLetter;
	}

	/**
	 * Gets a segment
	 * */
	public String getSegment() {
		return segment;
	}

	/**
	 * Gets the next letter
	 * */
	public char getNextLetter() {
		return nextLetter;
	}

	/**
	 * ToString for the class
	 * */
	public String toString() {
		return "\""+segment+"\" " + "-> " + nextLetter;
	}

	public  static  final  char  STOP = '.';
	
	/**
	 * Extra method that changes a word in a wanted form
	 * */
	private static String cleanUp(String input) {
		input = input.toLowerCase();
		input= input.replaceAll("[^a-zA-Z0-9]", "");
		return input;
		
	}
	/**
	 * Takes in a String a strips is into segments and the letters that follow them
	 * */
	public  static  LetterSample []  toSamples(String  input , int  segmentSize) {
		input=cleanUp(input);
		input+= STOP;
		LetterSample [] samples= new LetterSample [input.length()];
		for(int i=0; i<input.length(); i++) {
			int end=0;
			if(i-segmentSize>=0) end=i-segmentSize;
				
			samples[i]= new LetterSample(input.substring(end, i),input.charAt(i));
		}
		
		return samples;
	}
	
	
}
