package leetcode.Algorithm;

/**
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
 * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time.
 * However, you can buy it then immediately sell it on the same day.
 * Find and return the maximum profit you can achieve.
 * Example 1:
 * Input: prices = [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3. Total profit is 4 + 3 = 7.
 * Example 2:
 * Input: prices = [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4. Total profit is 4.
 * Input: prices = [6,1,3,2,4,7]
 */
public class Solution122 {

    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        int i = maxProfit(prices);
        System.out.printf("i=%s", i);
    }

    /**
     * 买入、卖出
     * 查找相邻的两位数相减为负数，则前面的应该卖掉，一直为正，
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int j = 0;
        int numProfit = 0;
        int i = 1;
        while (i < prices.length) {
            int num = prices[i] - prices[j];
            if (num > 0) {
                if (i < prices.length - 1 && prices[i + 1] - prices[i] < 0) {
                    numProfit += num;
                    j = i + 1;
                    i += 2;
                    continue;
                }else if(i == prices.length - 1) {
                    numProfit += num;
                }
            } else {
                j = i;
            }
            i++;
        }
        return numProfit;
    }

    /**
     * Input: prices = [6,1,3,2,4,7] 不适用
     * @param prices
     * @return
     */
    public static int maxProfit1(int[] prices) {
        int j = 0;
        int numProfit = 0;
        int i = 1;
        while (i < prices.length) {
            int num = prices[i] - prices[j];
            if (num > 0) {
                if (i + 1 < prices.length && prices[i + 1] - prices[i] < 0) {
                    // 有增有减
                    numProfit += num;
                    j = i + 1;
                    i += 2;
                    continue;
                } else if (i == prices.length - 1 && numProfit == 0) {
                    // 递增
                    numProfit = num;
                }
            } else {
                j = i;
            }
            i++;
        }
        return numProfit;
    }
}
