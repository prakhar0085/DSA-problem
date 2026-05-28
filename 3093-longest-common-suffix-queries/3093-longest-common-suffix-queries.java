class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int index;
        int length;

        TrieNode(int index, int length) {
            this.index = index;
            this.length = length;
        }
    }

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {

        int minIndex = 0;

        // Find smallest word in container
        for (int i = 1; i < wordsContainer.length; i++) {
            if (wordsContainer[i].length() < wordsContainer[minIndex].length()) {
                minIndex = i;
            }
        }

        TrieNode root = new TrieNode(minIndex, wordsContainer[minIndex].length());

        // Build reversed trie
        for (int i = 0; i < wordsContainer.length; i++) {
            String word = wordsContainer[i];
            TrieNode node = root;

            for (int j = word.length() - 1; j >= 0; j--) {
                int idx = word.charAt(j) - 'a';

                if (node.children[idx] == null) {
                    node.children[idx] = new TrieNode(i, word.length());
                }

                node = node.children[idx];

                // Update best index for this node
                if (word.length() < node.length) {
                    node.index = i;
                    node.length = word.length();
                }
            }
        }

        int[] ans = new int[wordsQuery.length];

        // Process queries
        for (int i = 0; i < wordsQuery.length; i++) {
            String query = wordsQuery[i];
            TrieNode node = root;

            for (int j = query.length() - 1; j >= 0; j--) {
                int idx = query.charAt(j) - 'a';

                if (node.children[idx] == null) {
                    break;
                }

                node = node.children[idx];
            }

            ans[i] = node.index;
        }

        return ans;
    }
}