class Solution {
    public int reverseBits(int n) {
        int ans = 0;

        for (int i = 0; i < 32; i++) {
            ans <<= 1;          // Shift answer left
            ans |= (n & 1);     // Add last bit of n
            n >>>= 1;           // Unsigned right shift
        }

        return ans;
    }
}