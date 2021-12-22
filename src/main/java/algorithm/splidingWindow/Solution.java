package splidingWindow;


import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

public class Solution {
    //https://leetcode-cn.com/problems/get-equal-substrings-within-budget/
    // 尽可能使得字符串相等
    public int equalSubstring(String s, String t, int maxCost) {
        int left = 0, right = 0;
        int sum = 0;
        int res = 0;
        while (right < s.length()) {
            // 构造窗口
            sum += Math.abs(s.charAt(right) - t.charAt(right));
            right++;

            while (sum > maxCost) {
                // 走到这一步说明窗口已经满足条件，调整窗口左边界继续枚举所有窗口情况
                sum -= Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }
            // 走到这一步说明窗口已经满足条件，则对比历史数据找到最满足题解的组合
            res = Math.max(res, right - left);
        }
        return res;
    }


    // https://leetcode-cn.com/problems/sliding-window-maximum/
    // 滑动窗口最大值
    // 固定窗口
    // 超时原因在于每次滑动后都重新遍历寻找最大值，实际上再滑动的过程中只需要计算新放入窗口的值是否大于当前窗口的最大值即可找到新的最大值
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int right = 0,index = 0;
        LinkedList<Integer> list = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        while (right < nums.length) {
            // 如果队列不为空，且当前元素大于队尾元素，说明队尾元素不可能是最大的元素，移除掉
            while (!list.isEmpty() && nums[list.peekLast()] < nums[right]) {
                list.removeLast();
            }
            list.addLast(right);
            // 当队首元素小于队列长度后，出列
            if (list.peekFirst() < right - k + 1) {
                list.removeFirst();
            }
            if (right - k + 1 >= 0) {
                res[index ++] = nums[list.peekFirst()];
            }
            right ++;
        }
        return res;
    }
    //12321
    //1 2 3 2

    public static int[] maxSlidingWindow1(int[] nums, int k) {
        int right = 0;
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        LinkedList<Integer> list = new LinkedList<>();
        while (right < nums.length) {
            // 重点理解窗口的最大值是第一个元素
            // 如果链表不给空同时数组元素大于窗口有边界元素，则删除最后一个元素
            while (!list.isEmpty() && nums[right] > list.peekLast()) {
                list.removeLast();
            }
            list.addLast(nums[right]);
            right++;
            // 保证第一个滑动窗口size满足题目给的k
            if (right >= k) {
                res[index++] = list.peekFirst();
                // 操作窗口滑动同时移除窗口第一个元素，针对与size -1 = k的情况,right -k 刚好出数组第一个元素位置
                // 1 2 3 4 5
                // 0 1 2 3
                if (list.peekFirst() == nums[right - k]) {
                    list.removeFirst();
                }
            }
        }
        return res;
    }


    // 定长字串中元音的最大数目
    // https://leetcode-cn.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
    public int maxVowels(String s, int k) {
        int right = 0, res = 0, sum = 0;
        while (right < s.length()) {
            sum += isVowels(s.charAt(right));
            right++;
            if (right >= k) {
                res = Math.max(res, sum);
                // 进入新的窗口移除最左边的元素
                sum -= isVowels(s.charAt(right - k));
            }

        }
        return res;

    }



    public int isVowels(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ? 1 : 0;
    }


    // https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
    // 无重复字符的最长字串
    public int lengthOfLongestSubstring(String s) {
        int res = 0, left = 0, right = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (right < s.length()) {
            if (map.containsKey(s.charAt(right))) {
                // 如果遇到了重复的元素，窗口左边界滑动到这个重复元素的第一个的坐标进行遍历
                left = Math.max(left, map.get(s.charAt(right)) + 1);
            }
            map.put(s.charAt(right), right);
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }

    // https://leetcode-cn.com/problems/contains-duplicate-ii/
    // 存在重复元素 II
    // [1,2,3,1,2,3] // 2 false
    // 1 1 2 1 // 2 true
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // 题目的关键在于维护一个k大小的滑动窗口进行遍历寻找
        Set<Integer> container = new HashSet<>();
        int right = 0;
        while (right < nums.length) {
            if (container.contains(nums[right])) {
                return true;
            }
            container.add(nums[right]);
            if (container.size() > k) {
                container.remove(nums[right - k]);
            }
            right ++;
        }
        return false;
    }

    // https://leetcode-cn.com/problems/contains-duplicate-iii/
    //  存在重复元素 III
    // 给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得 abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k。
    //输入：nums = [1,2,3,4,2], k = 3, t = 0
    //输出：true
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        TreeSet<Long> set = new TreeSet<Long>();
        for (int i = 0; i < n; i++) {
            Long ceiling = set.ceiling((long) nums[i] - (long) t);
            if (ceiling != null && ceiling <= (long) nums[i] + (long) t) {
                return true;
            }
            set.add((long) nums[i]);
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = solution.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7, 3}, 3);
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));

        System.out.println(solution.containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
        //Arrays.stream(ints).forEach(System.out::println);
    }
}
