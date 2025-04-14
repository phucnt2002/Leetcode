package leetcode.interview;

import java.util.HashSet;
import java.util.Set;

public class MinOperations {
    public int minOperations(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int a : nums) {
            if (a < k) {
                return -1;
            }
            if(a > k) {
                set.add(a);
            }
        }
        return set.size();


    }

    public static void main(String[] args) {
        MinOperations min = new MinOperations();

        int[] array = new int[]{5, 2, 5, 4, 5};
        System.out.println(min.minOperations(array, 2));


    }
}
