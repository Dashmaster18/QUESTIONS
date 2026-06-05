class Solution {
    public int rectangleArea(int[][] rectangles) {
        long MOD = 1000000007L;
        List<Integer> xs = new ArrayList<>();

        for (int[] r : rectangles) {
            xs.add(r[0]);
            xs.add(r[2]);
        }

        Collections.sort(xs);

        long area = 0;

        for (int i = 0; i < xs.size() - 1; i++) {
            int x1 = xs.get(i);
            int x2 = xs.get(i + 1);

            if (x1 == x2)
                continue;

            List<int[]> intervals = new ArrayList<>();

            for (int[] r : rectangles) {
                if (r[0] <= x1 && r[2] >= x2) {
                    intervals.add(new int[]{r[1], r[3]});
                }
            }

            if (intervals.isEmpty())
                continue;

            intervals.sort((a, b) -> Integer.compare(a[0], b[0]));

            long totalY = 0;
            int start = intervals.get(0)[0];
            int end = intervals.get(0)[1];

            for (int j = 1; j < intervals.size(); j++) {
                if (intervals.get(j)[0] > end) {
                    totalY += end - start;
                    start = intervals.get(j)[0];
                    end = intervals.get(j)[1];
                } else {
                    end = Math.max(end, intervals.get(j)[1]);
                }
            }

            totalY += end - start;
            area = (area + totalY * (x2 - x1)) % MOD;
        }

        return (int) area;
    }
}