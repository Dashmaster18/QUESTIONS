class Solution {
    public int distributeCandies(int[] candyType) {
        int[] freq = new int[200001];
        int distinct = 0;

        for (int x : candyType) {
            if (freq[x + 100000] == 0)
                distinct++;
            freq[x + 100000]++;
        }

        return Math.min(distinct, candyType.length / 2);
    }
}