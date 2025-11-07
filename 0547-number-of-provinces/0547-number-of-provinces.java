class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;
        
        // Iterate through each city
        for (int i = 0; i < n; i++) {
            // If city hasn't been visited, it's a new province
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                provinces++;
            }
        }
        
        return provinces;
    }
    
    // DFS to mark all cities in the same province
    private void dfs(int[][] isConnected, boolean[] visited, int city) {
        visited[city] = true;
        
        // Check all other cities
        for (int j = 0; j < isConnected.length; j++) {
            // If connected and not visited, explore that city
            if (isConnected[city][j] == 1 && !visited[j]) {
                dfs(isConnected, visited, j);
            }
        }
    }
}