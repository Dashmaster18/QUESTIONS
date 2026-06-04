class Solution {
    public int maxCount(int m, int n, int[][] ops) {

        for (int i = 0; i < ops.length; i++) {
            m = Math.min(m, ops[i][0]);
            n = Math.min(n, ops[i][1]);
        }

        return m * n;
    }
}