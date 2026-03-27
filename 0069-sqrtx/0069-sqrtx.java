class Solution {
    public int mySqrt(int x) {
        if (x < 2) return x; // handle 0 and 1
        
        int left = 1, right = x / 2;
        int ans = 0;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // use long to avoid overflow
            long square = (long) mid * mid;
            
            if (square == x) {
                return mid;
            } else if (square < x) {
                ans = mid;       // possible answer
                left = mid + 1;  // try bigger
            } else {
                right = mid - 1; // try smaller
            }
        }
        
        return ans;
    }
}