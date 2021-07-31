package dataStructure.string;

import java.util.HashMap;
import java.util.Map;

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

    public static void main(String[] args) {

    }
}
