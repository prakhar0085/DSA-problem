class Solution {
    public boolean isValid(String s) {
        if(s.length() % 2 !=0){
            return false;
        }

        char temp[] = new char[s.length()];
        int index = 0;

        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            if(c=='(' || c == '{' || c == '['){
                temp[index++] = c;
            }
            else{
                if(index == 0){
                    return false;
                }

                char last = temp[index -1];
                if((c == ')' && last == '(') || (c == '}' && last == '{') || (c == ']' && last == '[')){
                    index--;
                }else{
                    return false;
                }
            }
        }
        return index == 0;
    }
}