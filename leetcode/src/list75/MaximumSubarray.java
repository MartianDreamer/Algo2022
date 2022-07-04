package list75;


public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int curent = 0;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            curent = Math.max(curent+num, num);
            max = Math.max(max, curent);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,-1};
        System.out.println(new MaximumSubarray().maxSubArray(nums));
    }
}
