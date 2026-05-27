class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num <= 1) {
            return false;
        }

        int sum = 1;

        // Find divisors
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                sum += i;

                if (i != num / i) {
                    sum += num / i;
                }
            }
        }

        return sum == num;
    }
}