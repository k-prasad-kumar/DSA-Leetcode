
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

    Trie(){
        root = new TrieNode('\0'); // making root node null
    }

    void insertUtil(TrieNode root, String word){
        // base case 
        if(word.length() == 0) {
            root.isTerminal = true;
            return;
        }
        // assuming all chars are uppercase in stirng
        int index = word.charAt(0) - 'a';

        TrieNode child;
        // if char already present than move on
        if(root.children[index] != null){
            child = root.children[index];
        }else{  // if char absent create new and assing it to root
            child = new TrieNode(word.charAt(0)); // create new children
            root.children[index] = child; // assign it to root as children
        }

        // recursion
        insertUtil(child, word.substring(1)); // removing word 1st char evrey iteration
    }

    void insertWord(String word){
        insertUtil(root, word);
    }

    void getAllSuggestions(TrieNode curr, StringBuilder prefix, List<String> temp){
        if(curr.isTerminal && temp.size() < 3) temp.add(prefix.toString());

        for(char ch = 'a'; ch <= 'z'; ch++){
            TrieNode next = curr.children[ch - 'a'];

            if(next != null){
                prefix.append(ch);
                getAllSuggestions(next, prefix, temp);
                prefix.deleteCharAt(prefix.length()-1);  // backtracking 
            }
        }
    }

    List<List<String>> getSuggestions(String word){
        List<List<String>> ans = new ArrayList<>();

        TrieNode prev = root;
        StringBuilder prefix = new StringBuilder();

        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);

            prefix.append(ch);

            TrieNode curr = prev.children[ch-'a'];

            if(curr == null) {
                while(i++ < word.length()) ans.add(new ArrayList<>());
                break;
            }

            List<String> temp = new ArrayList<>();
            getAllSuggestions(curr, prefix, temp);

            ans.add(temp);
            prev = curr;
        }

        return ans;
    }
}

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie t = new Trie();

        for(String str: products){
            t.insertWord(str);
        }

        return t.getSuggestions(searchWord);
    }
}