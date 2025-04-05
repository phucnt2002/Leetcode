package leetcode.interview;

import java.util.Arrays;
import java.util.Comparator;

public class WiggleSort {
    public void wiggleSort(int[] nums) {
//        int[] tem = Arrays.stream(nums)
//                .boxed()
//                .sorted((a, b) -> b - a)
//                .mapToInt(Integer::intValue)
//                .toArray();
//        Arrays.sort(nums);
//
//        Arrays.sort(Arrays.stream(nums).boxed().toArray(Integer[]::new), Comparator.reverseOrder());


        int[] tem = Arrays.copyOf(nums, nums.length);

        int l = (nums.length - 1) / 2;
        int r = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i % 2 == 0 ? tem[l--] : tem[r--];
        }
        return;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 2, 2, 3, 1};
        WiggleSort wiggleSort = new WiggleSort();
        wiggleSort.wiggleSort(array);
    }


}
