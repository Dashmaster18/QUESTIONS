class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int max = 0;

        for (int i = 0; i < n; i++) {
            boolean[] vis = new boolean[128];
            int count = 0;

            for (int j = i; j < n; j++) {
                if (vis[s.charAt(j)])
                    break;

                vis[s.charAt(j)] = true;
                count++;
                max = Math.max(max, count);
            }
        }

        return max;
    }
}