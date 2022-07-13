package list75.array;

public class BestTimeToBuyAndSellStock {


    public int maxProfit(int[] prices) {
        int currentMin = Integer.MAX_VALUE;
        int maxP = 0;
        for (int i = 0; i < prices.length; i++) {
            currentMin = Math.min(currentMin, prices[i]);
            maxP = Math.max(maxP, prices[i] - currentMin);
        }
        return maxP;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();
        System.out.println(bestTimeToBuyAndSellStock.maxProfit(new int[]{23, 27, 28, 8, 15, 22, 2, 5, 7}));
    }
}
