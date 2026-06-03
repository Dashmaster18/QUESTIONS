class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int i = 0; // Pointer for the next unique element position
        
        // Pointer j iterates through the entire array to find unique elements
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++; // Move the unique element pointer
                nums[i] = nums[j]; // Place the new unique element
            }
        }
        
        // i is the last index of a unique element. The count is i + 1.
        return i + 1;
    }
}