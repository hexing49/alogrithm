package algorithm.dataStructure.array;

import javax.swing.plaf.multi.MultiButtonUI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

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
            return preNums[right] - preNums[left - 1];
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
// map：前缀和 -> 该前缀和出现的次数
        HashMap<Integer, Integer>
                preSum = new HashMap<>();
// base case

        preSum.put(0, 1);
        int res = 0, sum0_i = 0;
        for (int i = 0; i < n; i++) {
            sum0_i += nums[i];
// 这是我们想找的前缀和 nums[0..j]
            int sum0_j = sum0_i - k;
// 如果前⾯有这个前缀和，则直接更新答案
            if (preSum.containsKey(sum0_j))
                res += preSum.get(sum0_j);
// 把前缀和 nums[0..i] 加⼊并记录出现次数
            preSum.put(sum0_i, preSum.getOrDefault(sum0_i, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) throws ParseException {
        int[] a = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(a);
        System.out.println();

        int[][] array = {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        NumMatrix numMatrix = new NumMatrix(array);
        System.out.println(numMatrix.sumRegion(0, 0, 1, 0));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date time = new Date(); // 获取当前时间
        Date parse = sdf.parse("2022-06-01");
        System.out.println(parse.getTime());
    }
}
