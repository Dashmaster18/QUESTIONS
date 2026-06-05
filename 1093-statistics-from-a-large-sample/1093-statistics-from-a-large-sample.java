class Solution {
    public double[] sampleStats(int[] count) {

        int min = -1, max = 0, mode = 0;
        long totalCount = 0, sum = 0;

        for (int i = 0; i < 256; i++) {
            if (count[i] > 0) {
                if (min == -1)
                    min = i;

                max = i;

                if (count[i] > count[mode])
                    mode = i;

                totalCount += count[i];
                sum += (long) i * count[i];
            }
        }

        double mean = (double) sum / totalCount;

        double median;
        int m1 = -1, m2 = -1;
        long c = 0;

        for (int i = 0; i < 256; i++) {
            c += count[i];

            if (m1 == -1 && c >= (totalCount + 1) / 2)
                m1 = i;

            if (c >= (totalCount + 2) / 2) {
                m2 = i;
                break;
            }
        }

        median = (m1 + m2) / 2.0;

        return new double[]{min, max, mean, median, mode};
    }
}