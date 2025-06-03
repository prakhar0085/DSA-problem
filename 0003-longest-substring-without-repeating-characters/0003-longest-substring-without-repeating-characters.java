class Solution {
    public int lengthOfLongestSubstring(String s) {
        int freq[] = new int[256];
        int left = 0;
        int right = 0;
        int maxLength = 0;
        while(right < s.length()){
            char currChar = s.charAt(right);
            freq[currChar]++;

            while(freq[currChar] > 1){
                freq[s.charAt(left)]--;
                left++;
            }
            maxLength = Math.max(maxLength , right-left+1);

            right++;
        }
        return maxLength;

        
    }
}