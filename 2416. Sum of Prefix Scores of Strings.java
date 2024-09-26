class Solution {
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int count = 0;
    }
    
    private void insert(TrieNode root, String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
            node.count++;
        }
    }
    
    private int calculateScore(TrieNode root, String word) {
        TrieNode node = root;
        int score = 0;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            node = node.children[index];
            score += node.count;
        }
        return score;
    }
    
    public int[] sumPrefixScores(String[] words) {
        TrieNode root = new TrieNode();
        
        for (String word : words) {
            insert(root, word);
        }
       
        int[] result = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            result[i] = calculateScore(root, words[i]);
        }
        
        return result;
    }
}