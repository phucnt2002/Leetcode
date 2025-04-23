package leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

public class CountLargestGroup {
    public static int countLargestGroup(int n) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            int sum = sumDigit(i);
            if (!map.containsKey(sum)) {
                map.put(sum, 1);
            } else {
                map.put(sum, map.get(sum) + 1);
            }
        }
        int max = 0;
        int count = 0;

        for (Integer integer : map.values()) {
            if (max < integer){
                max = integer;
                count = 1;
            }else if(max == integer){
                count++;
            }
        }

        return count;
    }

    private static int sumDigit(int n) {
        int sum = 0;
        while (n > 0) {
            int a = n % 10;
            n = n / 10;
            sum += a;
        }
        return sum;
    }

    public static void main(String[] args) {

        System.out.println(countLargestGroup(26));
    }
}
