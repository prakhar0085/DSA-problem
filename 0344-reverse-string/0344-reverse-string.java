class Solution {
    public void reverseString(char[] s) {
        Stack<Character> p = new Stack<>();
        int idx = 0;
        while(idx < s.length){
            p.push(s[idx]);
            idx++;
        }
        idx = 0;
        while(!p.isEmpty()){
            char curr = p.pop();
           s[idx] =curr;
           idx++;
        }
        
    }
}