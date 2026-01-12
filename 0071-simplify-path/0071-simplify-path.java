class Solution {
    public String simplifyPath(String path) {
        // Stack to store valid directory names
        Deque<String> stack = new ArrayDeque<>();

        // Split by '/' to process each part
        String[] parts = path.split("/");

        for (String part : parts) {
            if (part.equals("") || part.equals(".")) {
                // Skip empty and current directory
                continue;
            } 
            else if (part.equals("..")) {
                // Go to parent directory if possible
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } 
            else {
                // Valid directory name
                stack.push(part);
            }
        }

        // Build result from stack
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append("/").append(stack.removeLast());
        }

        // If empty, return root
        return result.length() == 0 ? "/" : result.toString();
    }
}
