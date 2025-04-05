package leetcode.interview;

import java.util.Arrays;
import java.util.PriorityQueue;

public class RelativeRanks {
    //Solution 1
    //Time Complexity nlog(n), Space Complexity O(n)
//    public String[] findRelativeRanks(int[] score) {
//        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
//        for (int i = 0; i < score.length; i++) {
//            heap.add(new int[]{score[i], i});
//        }
//        String[] strResult = new String[score.length];
//        for (int i = 0; i < score.length; i++) {
//            int[] pull = heap.poll();
//            int value = pull[0];
//            int index = pull[1];
//            if (i == 0) {
//                strResult[index] = "Gold Medal";
//            } else if (i == 1) {
//                strResult[index] = "Silver Medal";
//            } else if (i == 2) {
//                strResult[index] = "Bronze Medal";
//            } else {
//                strResult[index] = String.valueOf(i+1);
//            }
//        }
//        return strResult;
//
//    }

    //Solution 2
    public String[] findRelativeRanks(int[] score) {
        int[][] pair = new int[score.length][2];

        for (int i = 0; i < score.length; i++) {
            pair[i][0] = score[i];
            pair[i][1] = i;
        }
        Arrays.sort(pair, (a, b) -> b[0] - a[0]);


        String[] strResult = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            if (i == 0) {
                strResult[pair[i][1]] = "Gold Medal";
            } else if (i == 1) {
                strResult[pair[i][1]] = "Silver Medal";
            } else if (i == 2) {
                strResult[pair[i][1]] = "Bronze Medal";
            } else {
                strResult[pair[i][1]] = String.valueOf(i + 1);
            }
        }
        return strResult;

    }


    public static void main(String[] args) {
        RelativeRanks relativeRanks = new RelativeRanks();
        relativeRanks.findRelativeRanks(new int[]{5, 4, 3, 2, 1});
    }
}
