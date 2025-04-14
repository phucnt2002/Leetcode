package leetcode.arrayandhashing;

public class CountGoodTriplets {

    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int count = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                for (int k = j + 1; k < arr.length; k++) {

                    boolean firstCondition = Math.abs(arr[i] - arr[j]) <= a;
                    boolean secondCondition = Math.abs(arr[j] - arr[k]) <= b;
                    boolean thirdCondition = Math.abs(arr[i] - arr[k]) <= c;

                    if (firstCondition&&secondCondition&&thirdCondition){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
