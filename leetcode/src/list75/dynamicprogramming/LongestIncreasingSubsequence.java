package list75.dynamicprogramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    // naive implementation
    public int lengthOfLIS(int[] nums) {
        int[] counts = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && counts[j] + 1 > counts[i]) {
                    counts[i] = counts[j] + 1;
                }
            }
        }
        return Arrays.stream(counts).max().orElse(0) + 1;
    }
}
