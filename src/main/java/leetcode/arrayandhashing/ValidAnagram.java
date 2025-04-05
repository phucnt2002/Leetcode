package leetcode.arrayandhashing;

import java.util.*;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        for (char i : s.toCharArray()) {
            if (sMap.containsKey(i)) {
                Integer count = sMap.get(i);
                count++;
                sMap.put(i, count);
            } else {
                sMap.put(i, 1);
            }
        }

        for (char i : t.toCharArray()) {
            if (tMap.containsKey(i)) {
                Integer count = tMap.get(i);
                count++;
                tMap.put(i, count);
            } else {
                tMap.put(i, 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
            if (sMap.containsKey(entry.getKey()) && Objects.equals(sMap.get(entry.getKey()), entry.getValue())) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {

    }
}
