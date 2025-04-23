package leetcode.interview;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CountNumberFairPairs {
    public long countFairPairs(int[] nums, int lower, int upper) {
        long count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                long sum = nums[i] + nums[j];
                if (sum <= upper && lower <= sum) {
                    count++;
                }
            }
        }
        return count;
    }


    public static long countFairPairs2(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return countLower(nums, upper) - countLower(nums, lower - 1);
    }

    private static long countLower(int[] nums, int k) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        long count = 0;
        while (l < r) {
            long sum = nums[l] + nums[r];

            if (sum > k) {
                r--;
            } else {
                count += r - l;
                l++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        countFairPairs2(new int[]{0, 1, 7, 4, 4, 5}, 3, 6);
    }
}
