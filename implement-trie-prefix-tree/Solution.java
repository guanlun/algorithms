public class Trie {
    
    class Node {
        boolean isEnd;
        HashMap<Character, Node> children;
        
        Node(boolean isEnd) {
            this.isEnd = isEnd;
            
            this.children = new HashMap<Character, Node>();
        }
    }

    private Node root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new Node(false);
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        insertInto(word, 0, root);
    }
    
    private void insertInto(String word, int startingPos, Node currNode) {
        if (startingPos == word.length()) {
            currNode.isEnd = true;
            return;
        }
        
        char c = word.charAt(startingPos);
        
        Node childNode = currNode.children.get(c);
        
        if (childNode == null) {
            Node newNode = new Node(false);
            currNode.children.put(c, newNode);
            
            insertInto(word, startingPos + 1, newNode);
        } else {
            insertInto(word, startingPos + 1, childNode);
        }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return this.contains(word, true, 0, root);
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return this.contains(prefix, false, 0, root);
    }
    
    private boolean contains(String word, boolean isEnd, int idx, Node currNode) {
        if (idx == word.length()) {
            if (isEnd) {
                return currNode.isEnd;
            } else {
                return true;
            }
        }
        
        char c = word.charAt(idx);
        
        Node childNode = currNode.children.get(c);
        
        if (childNode == null) {
            return false;
        }
        
        return contains(word, isEnd, idx + 1, childNode);
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
