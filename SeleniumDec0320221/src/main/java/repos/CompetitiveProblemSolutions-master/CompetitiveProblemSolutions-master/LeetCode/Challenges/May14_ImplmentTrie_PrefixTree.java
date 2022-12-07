/*
Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");   
trie.search("app");     // returns true
Note:

You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.
*/
// Explanatory video : https://www.youtube.com/watch?v=NscT5CQLeqY
class Trie {
    
    private Trie children[];
    private boolean isEndOfWord;

    /** Initialize your data structure here. */
    public Trie() {
        children = new Trie[26];
        isEndOfWord = false;
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie cur = this;
        for (char c: word.toCharArray()){
            if((cur.children[c - 'a']) == null){
                cur.children[c -'a'] = new Trie();
            }
            cur = cur.children[c - 'a'];
        }
        cur.isEndOfWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie cur = this;
        for(char c: word.toCharArray()){
            cur = cur.children[c - 'a'];
            if(cur == null)
                return false;
        }
        if(cur.isEndOfWord)
            return true;
        return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
         Trie cur = this;
        for(char c: prefix.toCharArray()){
            cur = cur.children[c - 'a'];
            if(cur == null)
                return false;
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
