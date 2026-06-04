class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;

        if (m * n != r * c)
            return mat;

        int[][] ans = new int[r][c];
        int idx = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[idx / c][idx % c] = mat[i][j];
                idx++;
            }
        }
        return ans;
    }
}