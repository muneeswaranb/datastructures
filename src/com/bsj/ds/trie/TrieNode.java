package com.bsj.ds.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    Map<Character, TrieNode> children;
    Boolean endOfWord;

    public TrieNode() {
        trieMap = new HashMap<>();
        endOfWord = false;
    }
}
