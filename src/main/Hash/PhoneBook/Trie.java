package main.Hash.PhoneBook;

public class Trie {
    private TrieNode rootNode;

    Trie(){
        rootNode = new TrieNode();
    }

    boolean insert(String word){
        TrieNode thisNode = this.rootNode;
        for(int i=0; i<word.length(); i++){
            thisNode = thisNode.getChildren().computeIfAbsent(word.charAt(i),c-> new TrieNode());

            if(thisNode.isLeaf()){
                return true;
            }
        }
        thisNode.setLeaf(true);
        return false;
    }

}
