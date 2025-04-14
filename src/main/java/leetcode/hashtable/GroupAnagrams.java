package leetcode.hashtable;

import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> listsResult = new ArrayList<>();
        List<String> list = new ArrayList<>(Arrays.asList(strs));

        while (!list.isEmpty()) {
            String base = list.get(0);
            List<String> group = new ArrayList<>();
            group.add(base);
            list.remove(0);

            // Duyệt để tìm anagram với phần tử đầu tiên
            for (int i = 0; i < list.size(); ) {
                if (checkAnagrams(base, list.get(i))) {
                    group.add(list.get(i));
                    list.remove(i); // Không tăng i vì đã remove
                } else {
                    i++;
                }
            }

            listsResult.add(group);
        }

        return listsResult;

    }


    public List<List<String>> groupAnagramsOption2(String[] strs) {
        List<List<String>> listsResult = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);


            if (map.getOrDefault(sorted, null) == null) {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(sorted, list);
            } else {
                List<String> newList = map.get(sorted);
                newList.add(str);
                map.put(sorted, newList);
            }

        }
        listsResult.addAll(map.values());


        return listsResult;

    }


    public List<List<String>> groupAnagramsOption3(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] count = new int[26];
            for (char aChar : str.toCharArray()) {
                count[aChar-'a']++;
            }

            String sorted = Arrays.toString(count);



            if(!map.containsKey(sorted)){
                map.put(sorted, new ArrayList<>());
            }
                map.get(sorted).add(str);

        }


        return new ArrayList<>(map.values());

    }


    public static boolean checkAnagrams(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            if (map.getOrDefault(s1.charAt(i), 0) == 0) {
                map.put(s1.charAt(i), 1);
            } else {
                map.put(s1.charAt(i), map.get(s1.charAt(i)) + 1);
            }
        }


        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < s2.length(); i++) {
            if (map2.getOrDefault(s2.charAt(i), 0) == 0) {
                map2.put(s2.charAt(i), 1);
            } else {
                map2.put(s2.charAt(i), map2.get(s2.charAt(i)) + 1);
            }
        }
        return map2.equals(map);
    }


    public static void main(String[] args) {
        System.out.println(checkAnagrams("aaabc", "cbaa"));
    }
}
