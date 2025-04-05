package leetcode.arrayandhashing;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])){
                return true;
            }else {
                set.add(nums[i]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 3};
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        System.out.println(containsDuplicate.hasDuplicate(array));
    }
}
