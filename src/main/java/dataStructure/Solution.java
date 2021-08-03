package dataStructure;

import daliy.Student;
import daliy.TestInterface;

import javax.sound.sampled.EnumControl;
import javax.swing.tree.TreeNode;
import java.util.*;
import java.util.function.Function;

public class Solution {
    //两数之和
    //https://leetcode-cn.com/problems/two-sum/
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                System.out.println(map.get(target - nums[i]));
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
    //https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
    // 两数之和二

    public int[] twoSum2(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                System.out.println(map.get(target - numbers[i]));
                return new int[]{map.get(target - numbers[i]), i + 1};
            }
            map.put(numbers[i], i + 1);
        }
        return null;
    }

    // 最大子序和
    // https://leetcode-cn.com/problems/maximum-subarray/
    public int maxSubArray(int[] nums) {
        int res = nums[0], pre = 0;
        for (int num : nums) {
            // dp公式
            pre = Math.max(pre + num, num);
            // 将当前值与最大值比较
            res = Math.max(res, pre);
        }
        return res;
    }

    //https://leetcode-cn.com/problems/merge-sorted-array/
    //合并两个有序数组

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        /*int t1 = 0 , t2 = 0;
        int[] sorts = new int[m + n];
        while (t1 < m || t2 < n) {
            if (sorts < m) {

            }
        }*/
        for (int i = 0; i < n; ++i) {
            nums1[i + n] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    //https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
    //两个数组的交集2
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] res = new int[nums1.length];
        int t = 0;
        for (int i1 = 0, i2 = 0; i1 < nums1.length && i2 < nums2.length; ) {
            if (nums1[i1] < nums2[i2]) {
                i1++;
            } else if (nums1[i1] > nums2[i2]) {
                i2++;
            } else {
                res[t++] = nums1[i1];
                i1++;
                i2++;
            }
        }
        return Arrays.copyOf(res, t);
    }

    //买卖股票的最佳时机
    //https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);

            maxProfit = Math.max(prices[i] - minPrice, maxProfit);
        }
        return maxProfit;

    }

    //https://leetcode-cn.com/problems/reshape-the-matrix/
    //重塑矩阵
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int maxSize = mat[0].length * mat.length;
        if (maxSize != r * c) {
            return mat;
        }
        int[][] result = new int[r][c];
        for (int i = 0; i < mat.length * mat[0].length; i++) {
            result[i / c][i % c] = mat[i / mat[0].length][i % mat[0].length];
        }
        return result;
    }

    public int[][] matrixReshape1(int[][] nums, int r, int c) {
        int m = nums.length;
        int n = nums[0].length;
        if (m * n != r * c) {
            return nums;
        }

        int[][] ans = new int[r][c];
        for (int x = 0; x < m * n; ++x) {
            ans[x / c][x % c] = nums[x / n][x % n];
        }
        return ans;
    }

    public boolean isValidSudoku(char[][] board) {
        return false;
    }

    //https://leetcode-cn.com/problems/set-matrix-zeroes/
    // 矩阵置零
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean[] row = new boolean[matrix.length];
        boolean[] col = new boolean[matrix[0].length];
        // 找到为0的元素
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = col[j] = true;
                }
            }
        }
        // 把0元素的行和列置零
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }


    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        // list.stream().filter( Objects.nonNull();
        Function<Student, String> getName = Student::getName;
        System.out.println(getName);
        Solution solution = new Solution();
        int[] ints = solution.twoSum(new int[]{2, 7, 11, 15}, 9);
        int[] ints1 = solution.twoSum2(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.toString(ints1));
        System.out.println(new Student().toString());

    }
}
