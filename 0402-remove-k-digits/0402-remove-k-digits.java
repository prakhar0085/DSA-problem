class Solution {
    public String removeKdigits(String num, int k) {
        if(k == num.length()){
            return "0";
        }
        Stack<Character> s = new Stack<>();
        for(char digit : num.toCharArray()){
            while(!s.isEmpty() && s.peek() > digit && k > 0){
                s.pop();
                k--;
            }
            s.push(digit);
        }
        while(k >0){
            s.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        boolean leadingZero = true;
        for(char digit : s){
            if(leadingZero && digit == '0'){
                continue;
            }
            leadingZero = false;
            sb.append(digit);
        }

        return sb.length() == 0 ?"0" : sb.toString();
        
    }
}