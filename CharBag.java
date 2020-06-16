import java.util.Random;

/**
 * This class represents a ADP of a Char bag where we made a set like structure but we remember the duplicates
 */
public class CharBag {

	public int [] list; //how many times each char appears in the bag
	int count;          //the number of all letters
	/**
	 * Constructor
	 * Creates an empty list
	 * Sets count to 0
	 */
	CharBag(){
		list= new int [27];
		count=0;
	}
	
	/**
	 * adds a char to the Char bag
	 */
	public void add(char c) {
		if(c=='.' || !Character.isLetter(c)) {
			list[26]++;
			count++;
			return;
		}
		c=Character.toLowerCase(c);
		list[(int)(c-'a')]++;
		count++;
	}
	/**
	 * removes a char to the Char bag
	 */
	public void remove(Character c) {
		if((!Character.isLetter(c) ||c=='.') && list[26]!=0) {
			list[26]--;
			count--;
			return;
		}
		if(!Character.isLetter(c) ||c=='.') {
			return;
		}
		if(list[(int)(c-'a')]!=0) {
			c=Character.toLowerCase(c);
			list[(int)(c-'a')]--;
			count--;
		}
	}
	/**
	 * returns the number of letters of a certain char in the bag
	 */
	public int getCount(char c) {
		if(!Character.isLetter(c) ||c=='.') {
			return list[26];
		}
		c=Character.toLowerCase(c);
		int place=(int)c - (int)'a';
		return list[place];
	}
	/**
	 * returns the number of letters in the bag
	 */
	public int getSize() {
		return count;
	}
	/**
	 * ToString of the class
	 */
	public String toString() {
		String out="CharBag{";
		for(int i=0; i<27; i++) {
			if(i==26) {
				out+=".:" + list[i];
			}
			else {
				char letter=(char)(i+'a');
				out+= letter+":" + list[i] + " ";
			}
		}
		
		out+="}";
		return out;
	}
	/**
	 * returns a random char from the char bag
	 */
	public char getRandomChar() {
		if(count==0) {
			return '.';
		}
		Random rand = new Random();
		int place=rand.nextInt(count);
		place++;
		for(int i=0; i<26; i++) {
			if(place>list[i]) {
				place-=list[i];
			}
			else
			{
				return (char)(i+'a');
			}
		}
		return '.';
		}
	
	
}
