package leetcode.interview;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    private static Map<Integer, Integer> memory = new HashMap<>();

    public static void check(int n) {
        System.out.println(fibo(n));
    }

    private static int fibo(int n) {
        if (n <= 2)
            return n;
        if (memory.containsKey(n))
            return memory.get(n);
        int result = fibo(n - 1) + fibo(n - 2);
        memory.putIfAbsent(n, result);
        return result;
    }

    public static void main(String[] args) {
        check(11);
    }
}
