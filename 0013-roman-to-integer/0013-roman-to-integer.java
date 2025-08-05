class Solution {
    public int romanToInt(String s) {
        // Map to store Roman numeral values
        int[] values = new int[128]; // ASCII table size
        values['I'] = 1;
        values['V'] = 5;
        values['X'] = 10;
        values['L'] = 50;
        values['C'] = 100;
        values['D'] = 500;
        values['M'] = 1000;
        
        int result = 0;
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            int currentValue = values[s.charAt(i)];
            
            // If current character is smaller than next character, subtract it
            if (i + 1 < n && currentValue < values[s.charAt(i + 1)]) {
                result -= currentValue;
            } else {
                // Otherwise, add it
                result += currentValue;
            }
        }
        
        return result;
    }
}