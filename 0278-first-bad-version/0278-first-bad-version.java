/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version);
*/

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1, right = n;

        while (left < right) {
            int mid = left + (right - left) / 2; // Avoid overflow

            if (isBadVersion(mid)) {
                right = mid;      // First bad version could be mid
            } else {
                left = mid + 1;   // Search in the right half
            }
        }

        return left;
    }
}