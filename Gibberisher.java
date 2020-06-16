

/**
 * 
 * @class that makes new words
 * 
 * */
public class Gibberisher {

	private Trie<CharBag> model; //trie tree that will be trained
	private int sampleLanght; //the length of samples we will be using
	private int trackLetterSample; //the number of training that is being done
	
	/**
	 * @param sampleLanght
	 */
	public Gibberisher(int sampleLanght) {
		this.sampleLanght = sampleLanght;
		model= new Trie<CharBag>();
		trackLetterSample=0;
	}
	/**
	 * @see here is the code that takes in the Letter Sample and adds the nextChar to to the CharBag accessable by the slogan
	 */
	void train(LetterSample samp) {
		if(model.get(samp.getSegment())==null)
		{
			model.put(samp.getSegment(), new CharBag());
		}
		model.get(samp.getSegment()).add(samp.getNextLetter());
		trackLetterSample++;
	}
	/**
	 * @see rips a String into LetterSamples and feeds it to train
	 */
	public void train(String samp) {
		
		LetterSample[] sample=LetterSample.toSamples(samp, sampleLanght);
		
		for(int i=0; i<sample.length; i++) {
			train(sample[i]);
		}
	}
	/**
	 * @see feeds variouse string for traingning
	 */
	public void train(String[] samp) {
		
		for(int i=0; i<samp.length; i++) {
			train(samp[i]);
		}
	}
	/**
	 * @return the number of trainings done
	 */
	public int getSampleCount()
	{
		return trackLetterSample;
	}
	
	/**
	 * @return a randomly generated word
	 */
	public String generate() {
		String word="";

		while(!word.endsWith(".")) {
			int end=0;
			if(word.length()-sampleLanght>0) end=word.length()-sampleLanght;
			
			String sample=word.substring(end);
		
			
			char radnLetter=model.get(sample).getRandomChar();
			word+=radnLetter;
		}
		return word;
		
		
	}
	
}
