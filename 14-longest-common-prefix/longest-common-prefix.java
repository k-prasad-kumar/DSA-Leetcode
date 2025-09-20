class TrieNode{
	char data;
	TrieNode[] children = new TrieNode[26];
	int childCount;
	boolean isTerminal;

	TrieNode(char ch){
		data = ch;

		for(int i=0; i<26; i++){
			children[i] = null;
		}
		childCount = 0;
		isTerminal = false;
	}
}

class Trie{
	TrieNode root;

	Trie(char ch){
		root = new TrieNode(ch);
	}

    void insertUtil(TrieNode root, String word){
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
            root.childCount++;
        }

        // recursion
        insertUtil(child, word.substring(1));
    }

    void insertWord(String word){
        insertUtil(root, word);
    }

    void lcp(String word, StringBuilder ans){
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);

            if(root.childCount == 1){
                ans.append(ch);

                int index = ch - 'a';
                root = root.children[index];
            }else {
                break;
            }

            if(root.isTerminal) break;
        }
    }
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder ans = new StringBuilder();
        if(strs.length == 0) return ans.toString();

        // // 1st approach

        // for(int i=0; i<strs[0].length(); i++){
        //     char ch = strs[0].charAt(i);
        //     boolean match = true;

        //     for(int j=1; j<strs.length; j++){
        //         if(strs[j].length() <= i || strs[j].charAt(i) != ch) {
        //             match = false;
        //             break;
        //         }
        //     }

        //     if(match == true) ans.append(ch);
        //     else break;
        // }

        // 2nd approach
        Trie t = new Trie('\0');

        // insert all words into trie
        for(String str: strs) {
            if(str.length() == 0) return ans.toString();
            t.insertWord(str);
        }

        t.lcp(strs[0], ans);

        return ans.toString();


    }
}