package leetcode.Algorithm;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction.
 * If you cannot achieve any profit, return 0.
 * Example 1:
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Example 2:
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 */
public class Solution121 {
    public static void main(String[] args) {
        int[] prices = new int[]{2,4,1};
        int i = maxProfit(prices);
        System.out.printf("i=%s", i);
    }

    /**
     * 获取减法值最大
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int min = 0;
        for (int i = 1; i < prices.length; i++) {
            System.out.printf("min=%s,prices[min]=%s,maxProfit=%s \n\r", min, prices[min], maxProfit);
            int num = prices[i] - prices[min];
            if (num > 0 && num > maxProfit) {
                maxProfit = num;
            } else if (num <= 0) {
                min = i;
            }
            System.out.printf("min=%s,prices[min]=%s,maxProfit=%s \n\r", min, prices[min], maxProfit);
        }
        return maxProfit;
    }

    /**
     * int[] prices = new int[]{2,4,1};  不适用了
     *
     * @param prices
     * @return
     */
    public static int maxProfit1(int[] prices) {
        // 查找最小值
        int min = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] <= prices[min]) {
                min = i;
            }
        }
        System.out.printf("min=%s, prices[min]=%s\n\r", min, prices[min]);
        if (min == prices.length - 1) {
            return 0;
        } else {
            int max = min;
            for (int i = min + 1; i < prices.length; i++) {
                System.out.println("---");
                if (prices[i] > prices[max]) {
                    max = i;
                }
            }
            System.out.printf("max=%s, prices[max]=%s\n\r", max, prices[max]);
            return prices[max] - prices[min];
        }
    }
}
