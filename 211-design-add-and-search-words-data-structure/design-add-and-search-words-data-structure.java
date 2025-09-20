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

class WordDictionary {
    TrieNode root;
    public WordDictionary() {
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

    public void addWord(String word) {
        insertWord(root, word);
    }

    public boolean searchWord(TrieNode root, String word){
        // base case
        if(word.length() == 0) {
            return root.isTerminal;
        }
        char ch = word.charAt(0);

        if(ch == '.'){ // if char is dot then find any next path or word is there
            for(TrieNode child: root.children){
                if(child != null && searchWord(child, word.substring(1)) ) {
                    return true;
                }
            }
            // if any patn or word doesn't exist then return false
            return false;
        }else{
            int index = ch - 'a';

        // if present
        if(root.children[index] != null){
            root = root.children[index];
        }else { // absent
            return false;
        }
        }

        // recursion
        return searchWord(root, word.substring(1));
    }
    
    public boolean search(String word) {
        return searchWord(root, word);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */