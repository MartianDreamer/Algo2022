package list75.dynamicprogramming;

/**
 * CoinChange
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int[] amountArr = new int[10_001];
        amountArr[0] = 0;
        for (int i = 1; i <= amount; i++) {
            amountArr[i] = -1;
            for (int coin : coins) {
                if (i - coin >= 0 && amountArr[i - coin] >= 0 && (amountArr[i] == -1
                        || amountArr[i - coin] + 1 < amountArr[i])) {
                    amountArr[i] = amountArr[i - coin] + 1;
                }
            }
        }
        return amountArr[amount];
    }
}