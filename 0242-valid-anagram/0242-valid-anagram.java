class Solution {
    public boolean isAnagram(String s, String t) {
        s = s.toLowerCase();
        t = t.toLowerCase();
        if(s.length() == t.length()){
            char c1[] = s.toCharArray();
            char c2[] = t.toCharArray();
            Arrays.sort(c1);
            Arrays.sort(c2);
            boolean result = Arrays.equals(c1 , c2);
            if(result){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
            
        }
    
        
    }
}