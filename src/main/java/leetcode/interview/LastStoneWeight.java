package leetcode.interview;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {

    //Solution 1 Time Complexity O(nlog(n)) Space Complexity O(n)
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < stones.length; i++) {
            heap.add(stones[i]);
        }
        while (heap.size() != 1) {
            int stone1 = heap.poll();
            int stone2 = heap.poll();
            int newStone = Math.abs(stone2 - stone1);
            heap.add(newStone);
        }
        return heap.poll();

    }


    public static void main(String[] args) {

    }
}
