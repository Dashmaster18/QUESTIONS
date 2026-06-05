import java.util.*;

class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {

        int n = queries.length;
        int[][] q = new int[n][2];

        for (int i = 0; i < n; i++) {
            q[i][0] = queries[i];
            q[i][1] = i;
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        Arrays.sort(q, (a, b) -> a[0] - b[0]);

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        ); // {length, end}

        int[] ans = new int[n];
        int i = 0;

        for (int[] query : q) {
            int val = query[0];
            int idx = query[1];

            while (i < intervals.length && intervals[i][0] <= val) {
                int len = intervals[i][1] - intervals[i][0] + 1;
                pq.offer(new int[]{len, intervals[i][1]});
                i++;
            }

            while (!pq.isEmpty() && pq.peek()[1] < val) {
                pq.poll();
            }

            ans[idx] = pq.isEmpty() ? -1 : pq.peek()[0];
        }

        return ans;
    }
}