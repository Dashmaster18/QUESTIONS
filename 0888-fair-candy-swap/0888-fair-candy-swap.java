import java.util.*;

class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {

        int sumA = 0, sumB = 0;

        for (int x : aliceSizes) sumA += x;
        for (int x : bobSizes) sumB += x;

        int diff = (sumA - sumB) / 2;

        HashSet<Integer> set = new HashSet<>();
        for (int x : bobSizes)
            set.add(x);

        for (int x : aliceSizes) {
            if (set.contains(x - diff))
                return new int[]{x, x - diff};
        }

        return new int[0];
    }
}