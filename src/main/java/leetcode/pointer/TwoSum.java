package leetcode.pointer;

import java.util.Arrays;

public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int k = numbers.length - 1;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] + numbers[k] < target) {
                continue;
            } else if (numbers[i] + numbers[k] > target) {
                k--;
                i--;
            } else {
                return new int[]{i+1, k+1};
            }
        }
        return new int[]{};

    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] array = new int[]{1,2,3,4};
        twoSum.twoSum(array, 3);
        System.out.println(Arrays.stream(twoSum.twoSum(array, 3)).toArray().toString());
    }
}
