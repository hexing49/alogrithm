package sword;

public class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (target < matrix[i][j]) {
                    break;
                } else if (target == matrix[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        int targetIndex = length / 2;
        int tempIndex = 0;
        int[] tempArray = new int[targetIndex + 1];
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
            if (tempIndex < targetIndex) {
                if (nums1[i] <= nums2[j]) {
                    tempArray[tempIndex++] = nums1[i];
                    i++;
                } else {
                    tempArray[tempIndex++] = nums2[j];
                    j++;
                }
            } else if (tempIndex >= targetIndex) {
                break;
            }
        }
        if (tempIndex < targetIndex) {

        }
        double result = length % 2 == 0 ? ((tempArray[targetIndex] + tempArray[tempIndex - 1]) / 2.0) : tempArray[targetIndex];
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});

    }
}
