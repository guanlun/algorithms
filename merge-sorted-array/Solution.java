public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int mergeIdx = m + n - 1;
        
        int idx1 = m - 1;
        int idx2 = n - 1;
        
        while (mergeIdx >= 0) {
            if ((idx1 == -1) || ((idx2 >= 0) && (nums1[idx1] < nums2[idx2]))) {
                nums1[mergeIdx] = nums2[idx2];
                idx2--;
            } else {
                nums1[mergeIdx] = nums1[idx1];
                idx1--;
            }
            
            mergeIdx--;
        }
        
        // O(n^2) solution
        // int idx1 = 0;
        
        // for (int idx2 = 0; idx2 < n; idx2++) {
        //     int numToInsert = nums2[idx2];
            
        //     while ((nums1[idx1] < numToInsert) && (idx1 < m)) {
        //         idx1++;
        //     }
            
        //     int currShiftNum = nums1[idx1];
            
        //     for (int i = idx1; i < m; i++) {
        //         int temp = nums1[i + 1];
        //         nums1[i + 1] = currShiftNum;
        //         currShiftNum = temp;
        //     }
            
        //     nums1[idx1] = numToInsert;
            
        //     idx1++;
        //     m++;
        // }
    }
}
