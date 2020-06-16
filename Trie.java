

/**
 * 
 * @class that represents a Trie data structure
 * 
 * */
public class Trie <T>{
	private TrieNode<T> root; //root of this tree

	/**
	 * @param root
	 */

	public Trie() {
		root = new TrieNode<T>();
	}
	
	/**
	 * @return the node we can access with slogan slog
	 */
	private TrieNode<T> getNode(String slog) {
		TrieNode<T> end= root;
		for(int i=0; i<slog.length(); i++) {
			end=end.getChild(slog.charAt(i));
		}
		
		return end;
	}
	/**
	 * @return the data on the node we can access with slogan slog
	 */
	public T get(String slog) {
		
		return getNode(slog).getData();
	}
	/**
	 * @set changes the data on the node we can access with slogan slog
	 */
	public void put(String slog, T elem) {
		getNode(slog).setData(elem);
	}
	/**
	 * @return the root of the tree
	 */
	public TrieNode<T> getRoot(){
		return root;
	}
}
