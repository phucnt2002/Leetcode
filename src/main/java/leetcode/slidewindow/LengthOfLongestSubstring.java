package leetcode.slidewindow;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
    int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int r = 0;
        int l = 0;
        int max = 0;
        int n = s.length() - 1;
        while (l <= n && r <= n) {
            if (map.getOrDefault(s.charAt(r), 0) == 0) {
                map.put(s.charAt(r), 1);
                r++;
            } else {
                map.put(s.charAt(r), map.get(s.charAt(r)) + 1);
                map.remove(s.charAt(l));
                l++;
            }
            max = Math.max(max, r - l);
        }
        return max;
    }


    public static void main(String[] args) {
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("pwwkew"));
    }
}
