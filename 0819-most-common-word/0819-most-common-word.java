import java.util.*;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        
        // Step 1: lowercase
        paragraph = paragraph.toLowerCase();
        
        // Step 2: remove punctuation
        paragraph = paragraph.replaceAll("[^a-z ]", " ");
        
        // Step 3: split into words
        String[] words = paragraph.split("\\s+");
        
        // Step 4: store banned words
        Set<String> bannedSet = new HashSet<>();
        for (String b : banned) {
            bannedSet.add(b);
        }
        
        // Step 5: count frequency
        Map<String, Integer> map = new HashMap<>();
        String result = "";
        int max = 0;
        
        for (String word : words) {
            if (!bannedSet.contains(word) && word.length() > 0) {
                map.put(word, map.getOrDefault(word, 0) + 1);
                
                if (map.get(word) > max) {
                    max = map.get(word);
                    result = word;
                }
            }
        }
        
        return result;
    }
}