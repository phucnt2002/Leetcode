package leetcode.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums) {
            queue.add(num);
        }
        if(queue.isEmpty())
            return 0;
        int result = 0;
        for(int i = 0; i < k-1;i++){
            result = queue.poll();
        }
        return result;






    }
}
