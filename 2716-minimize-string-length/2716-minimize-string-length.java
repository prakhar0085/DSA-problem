class Solution {
    public int minimizedStringLength(String s) {
        HashSet<Character> c = new HashSet<>();
        for(int i = 0 ; i < s.length() ; i++){
            if(!c.contains(s.charAt(i))){
                c.add(s.charAt(i));
            }
        }
        return c.size();
        
    }
}



// class Solution {
//     public int minimizedStringLength(String s) {
//         boolean[] seen = new boolean[26];
//         int count = 0;

//         for (char c : s.toCharArray()) {
//             if (!seen[c - 'a']) {
//                 seen[c - 'a'] = true;
//                 count++;
//             }
//         }

//         return count;
//     }
// }