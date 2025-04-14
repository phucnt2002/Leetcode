package leetcode.interview;

import java.util.Arrays;

public class LIS {
    public static int lengthOfLIS(int[] nums) {

        int[] tempArray = new int[nums.length];
        Arrays.fill(tempArray, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    tempArray[i] = Math.max(tempArray[j] + 1, tempArray[i]);
                }
            }
        }
        return Arrays.stream(tempArray).max().getAsInt();
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
    }

}
