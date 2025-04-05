package leetcode.slidewindow;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (maxProfit < prices[i] - minPrice) {
                maxProfit = prices[i] - minPrice;
            }
            if (minPrice > prices[i]) {
                minPrice = prices[i];
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        System.out.println(maxProfit.maxProfit(new int[]{10, 1, 5, 6, 7, 1}));
    }
}
