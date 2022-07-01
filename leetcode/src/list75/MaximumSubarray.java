package list75;

// Bad solution

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int[] snums = new int[nums.length+1];
        snums[0] = 0;
        for (int i = 1; i < snums.length; i++) {
            snums[i] = snums[i - 1] + nums[i-1];
        }
        int mini = 0;
        int max = snums[snums.length-1];
        for (int i = 0; i < snums.length; i++) {
            if (i!= mini) {
                max = Math.max(max, snums[i] - snums[mini]);
            }
            mini = snums[i] < snums[mini] ? i : mini;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,4,-1,7,8};
        System.out.println(new MaximumSubarray().maxSubArray(nums));
    }
}
