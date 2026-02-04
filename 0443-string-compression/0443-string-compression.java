class Solution {
    public int compress(char[] chars) {
        int write = 0;   // position to write compressed chars
        int i = 0;       // read pointer

        while (i < chars.length) {
            char currentChar = chars[i];
            int count = 0;

            // count consecutive same chars
            while (i < chars.length && chars[i] == currentChar) {
                i++;
                count++;
            }

            // write the character
            chars[write++] = currentChar;

            // write the count if > 1
            if (count > 1) {
                String cnt = String.valueOf(count);
                for (char c : cnt.toCharArray()) {
                    chars[write++] = c;
                }
            }
        }

        return write;  // new length
    }
}
