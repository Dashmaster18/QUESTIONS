class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] next = new int[10001];
        java.util.Arrays.fill(next, -1);

        java.util.Stack<Integer> st = new java.util.Stack<>();

        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() < nums2[i])
                st.pop();

            if (!st.isEmpty())
                next[nums2[i]] = st.peek();

            st.push(nums2[i]);
        }

        int[] ans = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            ans[i] = next[nums1[i]];
        }

        return ans;
    }
}