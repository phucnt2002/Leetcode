package leetcode.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> mappingValue = new HashMap<>();
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            mappingValue.put(nums1[i], mappingValue.getOrDefault(nums1[i], 0) + 1);
        }


        for (int i = 0; i < nums2.length; i++) {
            if (mappingValue.getOrDefault(nums2[i], 0) > 0) {
                mappingValue.put(nums2[i], mappingValue.get(nums2[i]) - 1);
                resultList.add(nums2[i]);
            }
        }


        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;

    }

    public static void main(String[] args) {
        int[] arrayA = new int[]{1, 2, 2, 1};
        int[] arrayB = new int[]{2, 2};


        IntersectionTwoArraysII intersectionTwoArraysII = new IntersectionTwoArraysII();
        intersectionTwoArraysII.intersect(arrayA, arrayB);
    }


}
