package daliy;

import java.util.*;

public class Solution {
    // https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
    // 无重复字符的最长字符
    // 滑动窗口
    public int lengthOfLongestSubstring(String s) {

        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;

    }

    // 替换隐藏数字得到的最晚时间
    // https://leetcode-cn.com/problems/latest-time-by-replacing-hidden-digits/
    public String maximumTime(String time) {
        char[] chars = time.toCharArray();
        if (chars[0] == '?') {
            chars[0] = (chars[1] >= '4' && chars[1] <= '9') ? '1' : '2';
        }
        if (chars[1] == '?') {
            chars[1] = chars[0] == '2' ? '3' : '9';
        }
        chars[3] = chars[3] == '?' ? '5' : chars[3];
        chars[4] = chars[4] == '?' ? '9' : chars[4];
        return new String(chars);
    }



    // 返回s中覆盖t所有字符的最小字串
    // https://leetcode-cn.com/problems/minimum-window-substring/
    public String minWindow(String s, String t) {
        Set<Character> tSet = new HashSet<>();
        int rk = -1;
        for (int i = 0; i < t.length(); i++) {
            tSet.add(t.charAt(i));
            while (rk + 1 < s.length()) {

            }
        }
        return null;
    }

    // 最长回文字串 动态规划
    public String longestPalindrome(String s) {
  /*      整体思想就是，申请一个二维的数组初始化为 0，然后判断对应的字符是否相等，相等的话
        arr [ i ][ j ] = arr [ i - 1 ][ j - 1] + 1 。
        当 i = 0 或者 j = 0 的时候单独分析，字符相等的话 arr [ i ][ j ] 就赋为 1 。
        arr [ i ][ j ] 保存的就是公共子串的长度。*/
        // data validate
        if ("".equals(s)) {
            return s;
        }
        // data init
        int len = 0;
        int max = 0;
        int[][] dp = new int[s.length()][s.length()];
        String reverse = new StringBuilder(s).reverse().toString();

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(i) == reverse.charAt(j)) {
                    // 初始化dp容器边界
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] += dp[i - 1][j - 1] + 1;
                    }

                    // 判断这个字符串是否是回文串
                    if (dp[i][j] > max) {
                        int pre = s.length() - j - 1;
                        if (pre + dp[i][j] - 1 == i) {
                            max = dp[i][j];
                            len = i;
                        }
                    }

                }
            }
        }
        return s.substring(len - max + 1, len + 1);
    }


    public boolean isCovered(int[][] ranges, int left, int right) {
        int start = ranges[0][0];
        int end = ranges[ranges.length - 1][ranges[0].length - 1];
        if (left >= start && right <= end) {
            return true;
        }
        return false;
    }


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
}
