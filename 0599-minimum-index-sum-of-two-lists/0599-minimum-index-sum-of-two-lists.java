class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {

        int minSum = Integer.MAX_VALUE;
        String[] temp = new String[list1.length];
        int k = 0;

        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {

                if (list1[i].equals(list2[j])) {
                    int sum = i + j;

                    if (sum < minSum) {
                        minSum = sum;
                        k = 0;
                        temp[k++] = list1[i];
                    } 
                    else if (sum == minSum) {
                        temp[k++] = list1[i];
                    }
                }
            }
        }

        String[] ans = new String[k];
        for (int i = 0; i < k; i++) {
            ans[i] = temp[i];
        }

        return ans;
    }
}