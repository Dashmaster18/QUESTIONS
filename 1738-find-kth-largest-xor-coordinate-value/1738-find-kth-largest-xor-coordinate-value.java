import java.util.*;

class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] pre = new int[m + 1][n + 1];
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                pre[i][j] = pre[i - 1][j]
                          ^ pre[i][j - 1]
                          ^ pre[i - 1][j - 1]
                          ^ matrix[i - 1][j - 1];

                list.add(pre[i][j]);
            }
        }

        Collections.sort(list, Collections.reverseOrder());

        return list.get(k - 1);
    }
}