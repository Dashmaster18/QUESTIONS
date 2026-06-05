class Solution {

    public String longestDupSubstring(String s) {

        int n = s.length();
        int left = 1, right = n - 1;
        int start = -1, maxLen = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int idx = search(s, mid);

            if (idx != -1) {
                start = idx;
                maxLen = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return start == -1 ? "" : s.substring(start, start + maxLen);
    }

    private int search(String s, int len) {

        long mod = (1L << 31) - 1;
        long base = 26;
        long hash = 0;
        long power = 1;

        for (int i = 0; i < len; i++) {
            hash = (hash * base + (s.charAt(i) - 'a')) % mod;
            power = (power * base) % mod;
        }

        HashMap<Long, List<Integer>> map = new HashMap<>();
        map.put(hash, new ArrayList<>());
        map.get(hash).add(0);

        for (int i = len; i < s.length(); i++) {

            hash = (hash * base - (s.charAt(i - len) - 'a') * power % mod + mod) % mod;
            hash = (hash + (s.charAt(i) - 'a')) % mod;

            int start = i - len + 1;

            if (map.containsKey(hash)) {
                for (int idx : map.get(hash)) {
                    if (s.substring(idx, idx + len).equals(s.substring(start, start + len)))
                        return start;
                }
            }

            map.putIfAbsent(hash, new ArrayList<>());
            map.get(hash).add(start);
        }

        return -1;
    }
}