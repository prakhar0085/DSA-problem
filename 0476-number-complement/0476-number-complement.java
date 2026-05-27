class Solution {
    public int findComplement(int num) {
        int mask = 1;

        // Create mask with all bits set to 1
        while (mask < num) {
            mask = (mask << 1) | 1;
        }

        return mask ^ num;
    }
}