import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        List<String> sortedKeys = new ArrayList<>(); // Stores sorted version of representative strings

        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];

            // Sort the string to use as a key
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String sortedStr = new String(arr);

            boolean added = false;

            // Compare with each group's sorted key
            for (int j = 0; j < sortedKeys.size(); j++) {
                if (sortedKeys.get(j).equals(sortedStr)) {
                    result.get(j).add(str);  // Add to the correct group
                    added = true;
                    break;
                }
            }

            // If no matching group found, create new one
            if (!added) {
                List<String> newGroup = new ArrayList<>();
                newGroup.add(str);
                result.add(newGroup);
                sortedKeys.add(sortedStr); // Save the key for 
            }
        }

        return result;
    }
}
