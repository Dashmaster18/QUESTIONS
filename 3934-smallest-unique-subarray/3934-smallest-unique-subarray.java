import java.util.*;

class Solution {
    public int smallestUniqueSubarray(int[] nums) {

        int n = nums.length;

        long base = 1000003L;
        long mod = 1000000007L;

        long[] power = new long[n + 1];
        long[] prefix = new long[n + 1];

        power[0] = 1;
        for (int i = 1; i <= n; i++) {
            power[i] = (power[i - 1] * base) % mod;
        }

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = (prefix[i] * base + nums[i] + 1) % mod;
        }

        int left = 1, right = n;
        int ans = n;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (check(mid, prefix, power, mod, n)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    private boolean check(int len, long[] prefix, long[] power,
                          long mod, int n) {

        HashMap<Long, Integer> map = new HashMap<>();

        for (int i = 0; i + len <= n; i++) {
            long hash = (prefix[i + len]
                    - (prefix[i] * power[len]) % mod + mod) % mod;

            map.put(hash, map.getOrDefault(hash, 0) + 1);
        }

        for (int count : map.values()) {
            if (count == 1)
                return true;
        }

        return false;
    }
}