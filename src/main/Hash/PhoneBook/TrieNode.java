package main.Hash.PhoneBook;

import java.util.HashMap;

class TrieNode{
    HashMap<Character,TrieNode> children = new HashMap<>();
    boolean isLeaf = false;

    TrieNode(){}
    public HashMap<Character, TrieNode> getChildren() {
        return children;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public void setLeaf(boolean leaf) {
        isLeaf = leaf;
    }
}
