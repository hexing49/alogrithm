package sword;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Solution {

    // https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
    // 二维数组的查找
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
     /*   for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (target < matrix[i][j]) {
                    break;
                } else if (target == matrix[i][j]) {
                    return true;
                }
            }
        }
        return false;*/
        // 右顶点旋转45°为二叉搜索树
        if (matrix.length == 0) {
            return false;
        }
        int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] < target) {
                i ++;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                return true;
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

    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if(dfs(board, chars, i, j, 0)) {
                    return true;
                }

            }
        }
        return false;
    }
    //https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/
    // 矩阵中的路径
    private boolean dfs(char[][] board, char[] chars, int i, int j, int k) {
        // 越界大咩
        if (i >= board.length || j >= board[0].length || i < 0 || j < 0 ||  board[i][j] != chars[k]) {
            return false;
        }
        if (k == chars.length - 1) {
            return true;
        }
        board[i][j] = '\0';

        boolean res = dfs(board, chars, i - 1, j, k + 1) ||
                dfs(board, chars, i + 1, j, k + 1) ||
                dfs(board, chars, i, j - 1, k + 1) ||
                dfs((board), chars, i, j + 1, k + 1);
        board[i][j] = chars[k];

        return res;
    }
    // https://leetcode-cn.com/problems/jian-sheng-zi-lcof/
    // 剑指 Offer 14- I. 剪绳子
    public int cuttingRope(int n) {
        //定义dp数组，dp[i]表示长度为i的绳子剪成m端后长度的最大乘积(m>1)
        int dp[] = new int[n+1];
        //初始化
        dp[2] = 1;
        //目标：求出dp[n]
        //dp[2]已知，从dp[3]开始求，直到求出dp[n]
        for(int i = 3;i <= n;i++){
            //首先对绳子剪长度为j的一段,其中取值范围为 2 <= j < i
            for(int j = 2;j < i;j++){

                //转移方程如下
                dp[i] = Math.max(dp[i],Math.max(j*(i-j),j*dp[i-j]));
                //Math.max(j*(i-j),j*dp[i-j]是由于减去第一段长度为j的绳子后，可以继续剪也可以不剪
                //Math.max(dp[i],Math.max(j*(i-j),j*dp[i-j]))是当j不同时，求出最大的dp[i]
            }
        }
        //现在已经求出每个长度i对应的最大乘积，返回dp[n]
        return dp[n];
    }

    public int movingCount(int m, int n, int k) {
        return 0;
    }




    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
        char c = '\0';
        System.out.println(c);
        System.out.println(6 / 8);

    }
}
