//Project 3, CSCI 1913, Daniel Kluver
//Jovan Petrovic, 5584954

/**
 * 
 * @class This class is for nodes that are represented in the trie
 * 
 * */
public class TrieNode <T> {
	
	private T data; //certain data in the node
	private TrieNode<T>[] children; //List of children 
	
	/**
	 * @param data
	 * @param children
	 */
	@SuppressWarnings("unchecked")
	public TrieNode() {
		this.data = null;
		this.children =  new TrieNode[27];
	}

	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * @return the child node of char letter
	 */
	public TrieNode<T> getChild(char letter){
		if(Character.isLetter(letter) && Character.isLowerCase(letter)) {
			int place=(int)letter - (int)'a';
			if(children[place]==null) {
				children[place]=new TrieNode<T>();
			}
			return children[place];
		}
		return null;
	}
	/**
	 * @return the number of nodes that are stored after the node
	 */
	public int getTreeSize() {
		int count=1;
		for(int i=0; i<children.length; i++) {
			if(children[i]!=null) {
				count++;
				count+=children[i].getTreeSize()-1;
			}
		}
		return count;
	}
}
