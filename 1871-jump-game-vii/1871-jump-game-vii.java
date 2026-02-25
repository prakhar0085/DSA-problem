class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        boolean[] visited = new boolean[n];
        visited[0] = true;

        java.util.Queue<Integer> q = new java.util.LinkedList<>();
        q.offer(0);

        int farthestChecked = 0;  // to avoid re-checking ranges

        while (!q.isEmpty()) {
            int i = q.poll();

            int start = Math.max(i + minJump, farthestChecked + 1);
            int end = Math.min(i + maxJump, n - 1);

            for (int j = start; j <= end; j++) {
                if (s.charAt(j) == '0' && !visited[j]) {
                    if (j == n - 1) return true;
                    visited[j] = true;
                    q.offer(j);
                }
            }

            farthestChecked = Math.max(farthestChecked, end);
        }

        return visited[n - 1];
    }
}