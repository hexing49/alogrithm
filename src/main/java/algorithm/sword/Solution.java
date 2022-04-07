package algorithm.sword;

import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {

    //https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
    // 数组中重复的数字 sword-03
    public int findRepeatNumber(int[] nums) {
        boolean[] container = new boolean[nums.length];
        for (int i : nums) {
            if (container[i] = true) {
                return i;
            }
            container[i] = true;
        }
        return 0;
    }

    // https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
    // 二维数组的查找 sword-04
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
                j --;
            } else {
                return true;
            }
        }
        return false;
    }


    //https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
    // 替换空格 sword-05
    public String replaceSpace(String s) {
       /* if (s.length() == 0) {
            return s;
        }
        char[] chars = new char[3 * s.length()];
        int t = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == ' ') {
                chars[t++] = '%';
                chars[t++] = '2';
                chars[t++] = '0';
            } else {
                chars[t++] = s.charAt(i);
            }
        }
        return new String(chars, 0, t);*/
        if (s.length() == 0) {
            return s;
        }
        char[] chars = new char[s.length() * 3];
        int aux = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                chars[aux++] = '%';
                chars[aux++] = '2';
                chars[aux++] = '0';
            }else {
                chars[aux++] = s.charAt(i);
            }
        }
        return new String(chars, 0, aux);
       // return s.replace(" ", "%20");
    }


    // 两个数组合并有序
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

    // https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
    // 旋转数组的最小数字 sword-11
    public int minArray(int[] numbers) {
        if (numbers.length == 0) {
            return 0;
        }
        int result = numbers[0];
        for (int i : numbers) {
            if (result > i) {
                return i;
            }
        }
        return result;
    }


    //https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/
    // 矩阵中的路径 sword-12
    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (dfs(i, j, 0, board, chars)) {
                    return true;
                }
            }
        }
        return false;

    }

    private boolean dfs(int i, int j, int length, char[][] board, char[] chars) {
        if (i < 0 || j < 0 || i == board.length || j == board[0].length || board[i][j] != chars[length]) {
            return false;
        }
        if (length == chars.length - 1) {
            return true;
        }
        board[i][j] = '\0';
        boolean res = dfs(i - 1, j, length + 1, board, chars) ||
                dfs(i + 1, j, length + 1, board, chars) ||
                dfs(i, j - 1, length + 1, board, chars) ||
                dfs(i, j + 1, length + 1, board, chars);
        board[i][j] = chars[length];
        return res;
    }

    // https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
    // 机器人的运动范围 sword- 13 上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
    public int movingCount(int m, int n, int k) {
        return 0;
    }

    // https://leetcode-cn.com/problems/jian-sheng-zi-lcof/
    // sword-14- I. 剪绳子
    public int cuttingRope(int n) {
        //定义dp数组，dp[i]表示长度为i的绳子剪成m端后长度的最大乘积(m>1)
        int dp[] = new int[n + 1];
        //初始化
        dp[2] = 1;
        //目标：求出dp[n]
        //dp[2]已知，从dp[3]开始求，直到求出dp[n]
        for (int i = 3; i <= n; i++) {
            //首先对绳子剪长度为j的一段,其中取值范围为 2 <= j < i
            for (int j = 2; j < i; j++) {

                //转移方程如下
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
                //Math.max(j*(i-j),j*dp[i-j]是由于减去第一段长度为j的绳子后，可以继续剪也可以不剪
                //Math.max(dp[i],Math.max(j*(i-j),j*dp[i-j]))是当j不同时，求出最大的dp[i]
            }
        }
        //现在已经求出每个长度i对应的最大乘积，返回dp[n]
        return dp[n];
    }

    // https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
    // 调整数组顺序使奇数位于偶数前面 sword-21
    public int[] exchange(int[] nums) {
        int slow = 0, fast = 0;
        for (; fast < nums.length; fast++) {
            // 如果是奇数，则和前面
            if ((nums[fast] & 1) == 1) {
                int t = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = t;
                slow++;
            }
        }
        return nums;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
      /*  solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
        char c = '\0';
        System.out.println(c);
        System.out.println(6 / 8);*/
        int i = 0;
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ArrayList<String> list = new ArrayList<>();
        list.add("11");

        LinkedList<Object> objects = new LinkedList<>();
        objects.add("1");
  /*      for (String s : list) {
            list.remove(s);
            System.out.println("执行了:" + i ++);
        }*/

        // 实际上在插入数据时候，在ArrayList
        // judge whether expected mod count == modCound
        Iterator<String> iterator = list.iterator();
        Iterator<Object> iterator1 = objects.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            iterator.remove();
            System.out.println(next);
        }

    }
}
