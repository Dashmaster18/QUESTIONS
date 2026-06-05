class Solution {
    double ans = 0;
    double total = 0;
    int[] balls;
    int n;

    public double getProbability(int[] balls) {
        this.balls = balls;
        n = balls.length;

        int sum = 0;
        for (int x : balls) sum += x;

        dfs(0, 0, 0, 1.0, 1.0, 0, 0, sum / 2);

        return ans / total;
    }

    private void dfs(int idx, int c1, int c2,
                     double ways1, double ways2,
                     int d1, int d2, int half) {

        if (idx == n) {
            if (c1 == half && c2 == half) {
                total += ways1 * ways2;
                if (d1 == d2)
                    ans += ways1 * ways2;
            }
            return;
        }

        for (int i = 0; i <= balls[idx]; i++) {
            if (c1 + i > half || c2 + balls[idx] - i > half)
                continue;

            dfs(idx + 1,
                c1 + i,
                c2 + balls[idx] - i,
                ways1 * comb(balls[idx], i),
                ways2,
                d1 + (i > 0 ? 1 : 0),
                d2 + (balls[idx] - i > 0 ? 1 : 0),
                half);
        }
    }

    private double comb(int n, int r) {
        if (r > n) return 0;
        if (r == 0 || r == n) return 1;
        double res = 1;
        for (int i = 1; i <= r; i++) {
            res = res * (n - i + 1) / i;
        }
        return res;
    }
}