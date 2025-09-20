
class TrieNode{
	char data;
	TrieNode[] children = new TrieNode[26];
	boolean isTerminal;

	TrieNode(char ch){
		data = ch;

		for(int i=0; i<26; i++){
			children[i] = null;
		}
		isTerminal = false;
	}
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode('\0');
    }
    
    public void insertWord(TrieNode root, String word){
        // base case
        if(word.length() == 0) {
            root.isTerminal = true;
            return;
        }

        int index = word.charAt(0) - 'a';
        TrieNode child;
        // if present
        if(root.children[index] != null){
            child = root.children[index];
        }else { // absent
            child = new TrieNode(word.charAt(0));
            root.children[index] = child;
        }

        // recursion
        insertWord(child, word.substring(1));
    }

    public void insert(String word) {
        insertWord(root, word);
    }

    public boolean searchWord(TrieNode root, String word){
        // base case
        if(word.length() == 0) {
            return root.isTerminal;
        }

        int index = word.charAt(0) - 'a';
        
        // if present
        if(root.children[index] != null){
            root = root.children[index];
        }else { // absent
            return false;
        }

        // recursion
        return searchWord(root, word.substring(1));
    }
    
    public boolean search(String word) {
        return searchWord(root, word);
    }
    
    public boolean prefixUtil(TrieNode root, String word){
        // base case
        if(word.length() == 0) {
            return true;
        }

        int index = word.charAt(0) - 'a';
    
        // if present
        if(root.children[index] != null){
            root = root.children[index];
        }else { // absent
            return false;
        }

        // recursion
        return prefixUtil(root, word.substring(1));
    }

    public boolean startsWith(String prefix) {
        return prefixUtil(root, prefix);
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */