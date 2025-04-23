package leetcode.interview;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class LIS {
    public static int lengthOfLIS(int[] nums) {

//        nums = Arrays.stream(nums).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();
        Collections.binarySearch(Arrays.stream(nums).boxed().collect(Collectors.toList()), 1);

        int[] tempArray = new int[nums.length];
        Arrays.fill(tempArray, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    tempArray[i] = Math.max(tempArray[j] + 1, tempArray[i]);
                }
            }
        }
        return Arrays.stream(tempArray).max().getAsInt();
    }

    public static void main(String[] args) {
//        System.out.println(lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
        Map<String, Integer> map = new ConcurrentHashMap<>() {
        };

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                for (int j = 0; j < 3; j++) {
                    map.put("home", map.getOrDefault("home", 0)+j);
                }
            }, executorService);

            futures.add(future);
        }
        CompletableFuture<Void> allOf = CompletableFuture.allOf(
                futures.toArray(new CompletableFuture[0])
        );
        allOf.join();
//        allOf.get();
        executorService.shutdown();
    }

}
