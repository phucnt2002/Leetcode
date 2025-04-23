package leetcode.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountGood {
    public static long countGood(int[] nums, int k) {
        long res = 0;
        int left = 0;
        Map<Integer, Integer> map = new HashMap<>();
        long countPair = 0;

        for (int right = 0; right < nums.length; right++) {
            int freq = map.getOrDefault(nums[right], 0);
            countPair += freq; // thêm phần tử nums[right] vào, sẽ tạo ra freq cặp mới
            map.put(nums[right], freq + 1);

            // Di chuyển left sao cho số cặp >= k
            while (countPair >= k) {
                res += nums.length - right; // tất cả subarray từ left đến right đều thỏa mãn
                int leftFreq = map.get(nums[left]);
                countPair -= (leftFreq - 1); // bỏ nums[left], mất (leftFreq - 1) cặp
                if (leftFreq == 1) {
                    map.remove(nums[left]);
                } else {
                    map.put(nums[left], leftFreq - 1);
                }
                left++;
            }
        }

        return res;
    }

    public static long countGood2(int[] nums, int k) {
        long result = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], key -> new ArrayList<>()).add(i);
        }

        for (List<Integer> value : map.values()) {
            long size = value.size();
            result += (size * (size - 1)) / 2;
        }
        return result;
    }

    public int countPairs(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] == nums[j] && ((i * j) % k == 0)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countGood2(new int[]{1,1,1,1,1}, 10));

    }
}
