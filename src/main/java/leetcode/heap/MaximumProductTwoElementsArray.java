package leetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumProductTwoElementsArray {
    public int maxProduct(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : nums) {
            queue.add(num);
        }

        int top = queue.poll();
        int second = queue.poll();
        return (top -1)*(second-1);
    }
}
