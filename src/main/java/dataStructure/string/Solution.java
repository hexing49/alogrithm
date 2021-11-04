package dataStructure.string;

import javax.swing.tree.TreeNode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    public int firstUniqChar1(String s) {
        int[] dp = new int[26];
        for (int i = 0; i < s.length(); i++) {
            dp[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (dp[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;

    }

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] rCount = new int[26];
        int[] mCount = new int[26];
        for (int i = 0; i < ransomNote.length(); i++) {
            rCount[ransomNote.charAt(i) - 'a']++;
        }
        for (int i = 0; i < magazine.length(); i++) {
            mCount[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (rCount[ransomNote.charAt(i) - 'a'] > mCount[ransomNote.charAt(i) - 'a'] ) {
                return false;
            }
        }
        return true;
    }
    public boolean isAnagram(String s, String t) {
        int[] charsCount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charsCount[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            charsCount[t.charAt(i) - 'a'] --;
            if (charsCount[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        for (int i = 0; i < charsCount.length; i++) {
            if (charsCount[i] != 0) {
                return false;
            }
        }
        return true;

    }

    //https://leetcode-cn.com/problems/reverse-words-in-a-string/
    // 反转字符串中的所有单词
    public String reverseWords(String s) {
        String trim = s.trim();
        String[] words = trim.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = words.length - 1; i >= 0; --i) {
            if (Objects.equals(words[i], "")) {
                continue;
            }
            stringBuilder.append(words[i]);
            if (i == 0) {
                break;
            }
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String the_sky_is_blue = solution.reverseWords("a good   example");
        System.out.println(the_sky_is_blue);
        Long l = 1234567890L;
        System.out.println(l.toString());
    }
}
