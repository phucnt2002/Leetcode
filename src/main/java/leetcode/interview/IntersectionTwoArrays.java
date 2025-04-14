package leetcode.interview;

import java.util.*;

public class IntersectionTwoArrays{


//Brute Force Time complexity = O(nxm)
//    public int[] intersection(int[] nums1, int[] nums2) {
//
//
//            List<Integer> integerList = new ArrayList<>();
//
//            for(int a: nums1){
//
//                for(int b: nums2){
//                    if(a == b){
//                        if(!integerList.contains(a)){
//                            integerList.add(a);
//                            break;
//                        }else {
//                            break;
//                        }
//                    }
//                }
//            }
//            return integerList.stream().mapToInt(Integer::intValue).toArray();
//    }
//Set

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> listResult = new HashSet<>();


        HashSet<Integer> set = new HashSet<>();
        for(int i : nums1){
            set.add(i);
        }

        for(int i : nums2){
            if(set.contains(i)){
                listResult.add(i);
            }
        }
        int[] array = new int[listResult.size()];
        int index = 0;
        for (Integer i : listResult) {
            array[index] = i;
            index ++;
        }
        return array;





    }
    public static void main(String[] args) {

    }
}
