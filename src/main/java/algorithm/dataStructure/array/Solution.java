package algorithm.dataStructure.array;

import javax.swing.plaf.multi.MultiButtonUI;
import java.util.Arrays;

public class Solution {
    // 数组场景1，前缀和presum

    // https://leetcode.cn/problems/range-sum-query-immutable/
    //leecode-303 区域和检索 - 数组不可变
    static class NumArray {
        //         0 1 2 3 4 5
        //    nums[3 5 2 -2 4 1]
        // preNums[0 3 8 10 8 12 13]
        private final int[] preNums;

        public NumArray(int[] nums) {
            preNums = new int[nums.length + 1];
            // 核心是preNums[i] 记录的是0 -i的和,正向思维更好理解
            for (int i = 0; i < nums.length; ++i) {
                if (i == 0) {
                    preNums[i] = nums[i];
                    continue;
                }
                preNums[i] = preNums[i - 1] + nums[i];
            }
        }

        public int sumRange(int left, int right) {
            if (left == 0) {
                return preNums[right];
            }
            return preNums[right ] - preNums[left - 1];
        }
    }

    //leecode-304 二维数组的前缀和
    // https://leetcode.cn/problems/range-sum-query-2d-immutable/
    static class NumMatrix {
        private int[][] preSums;

        public NumMatrix(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            preSums = new int[m + 1][n + 1];
            // 因为1.1代表的是第一个元素
            for (int i = 1; i <= m; ++i) {
                for (int j = 1; j <= n; ++j) {
                    preSums[i][j] = preSums[i - 1][j] + preSums[i][j - 1] + matrix[i - 1][j - 1] - preSums[i - 1][j - 1];
                }
            }
            System.out.println(Arrays.stream(preSums).iterator());
        }

        // 计算⼦矩阵 [x1, y1, x2, y2] 的元素和
        public int sumRegion(int x1, int y1, int x2, int y2) {
// ⽬标矩阵之和由四个相邻矩阵运算获得
            return preSums[x2 + 1][y2 + 1] - preSums[x1][y2 + 1] - preSums[x2 + 1][y1] +
                    preSums[x1][y1];
        }
    }

    // leecode 560
    // https://leetcode.cn/problems/subarray-sum-equals-k/
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] preSums = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            preSums[i] = preSums[i - 1] + nums[i - 1];
        }
        for (int i = 0;)
        return 0;
    }

    public static void main(String[] args) {
        int[] a = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(a);
        System.out.println();

        int[][] array = {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        NumMatrix numMatrix = new NumMatrix(array);
        System.out.println(numMatrix.sumRegion(0,0,1,0));
    }
}
