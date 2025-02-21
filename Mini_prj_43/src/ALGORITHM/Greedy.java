package ALGORITHM;

import java.util.Arrays;

public class Greedy {
    public static int[] makeChange(int[] coins, int amount) {
        Arrays.sort(coins); // Sort coins in ascending order
        int[] result = new int[coins.length]; // Array to store the count of each coin used

        for (int i = coins.length - 1; i >= 0; i--) {
            while (amount >= coins[i]) {
                result[i]++;
                amount -= coins[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] coins = {25, 10, 5, 1}; // Denominations of coins
        int amount = 49; // Amount to make change for

        int[] result = makeChange(coins, amount);

        System.out.println("Coins used to make change for " + amount + ":");
        for (int i = 0; i < coins.length; i++) {
            if (result[i] > 0) {
                System.out.println(result[i] + " x " + coins[i] + " cents");
            }
        }
    }
}

