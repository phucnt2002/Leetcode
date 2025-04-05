package leetcode.heap;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                return true;
            }
            map.put(nums[i], 1);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4};
        System.out.println(containsDuplicate(a));
    }
}
