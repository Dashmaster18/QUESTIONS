class Solution {
    Set<String> seen = new HashSet<>();
    StringBuilder ans = new StringBuilder();

    public String crackSafe(int n, int k) {

        String start = "0".repeat(n - 1);

        dfs(start, k);

        ans.append(start);

        return ans.toString();
    }

    private void dfs(String node, int k) {
        for (int i = 0; i < k; i++) {
            String next = node + i;

            if (!seen.contains(next)) {
                seen.add(next);
                dfs(next.substring(1), k);
                ans.append(i);
            }
        }
    }
}