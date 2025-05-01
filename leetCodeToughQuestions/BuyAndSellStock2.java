package leetCodeToughQuestions;

import java.util.Arrays;

public class BuyAndSellStock2 {


        int findProfit(int[] prices, int i, int taken, int[][] dp){
            if(i >= prices.length){
                return 0;
            }

            if(dp[i][taken] != -1){
                return dp[i][taken];
            }

            int profit = 0;
            if(taken == 0){
                // Option 1: Do nothing
                profit = Math.max(findProfit(prices, i+1, 0, dp),
                        -prices[i] + findProfit(prices, i+1, 1, dp));  // Buy
            } else {
                // Option 2: Either Hold or Sell
                profit = Math.max(findProfit(prices, i+1, 1, dp),
                        prices[i] + findProfit(prices, i+1, 0, dp));  // Sell
            }

            dp[i][taken] = profit;
            return profit;
        }

        public int maxProfit(int[] prices) {

            int n = prices.length;
            int[][] dp = new int[n][2];
            for (int[] row : dp) Arrays.fill(row, -1);
            return findProfit(prices, 0, 0, dp);


        }


        public static void main(String[] args){
            int[] arr=new int[]{
                    7,1,5,3,6,4
            };
            BuyAndSellStock2 buyAndSellStock2=new BuyAndSellStock2();
           System.out.println(buyAndSellStock2.maxProfit(arr));
        }

}
