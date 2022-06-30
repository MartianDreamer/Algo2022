package daily;

import java.util.Arrays;

public class MinimumMovesToEqualArrayElementsII {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int median = nums[nums.length/2];
        int rs = 0;
        for (int i = 0; i < nums.length; i++) {
            rs += Math.abs(nums[i] - median);
        }
        return rs;
    }
}
