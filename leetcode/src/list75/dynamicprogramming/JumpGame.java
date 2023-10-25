package list75.dynamicprogramming;

import java.util.LinkedList;

public class JumpGame {
    public boolean canJump(int[] nums) {
        boolean[] canJumps = new boolean[nums.length];
        canJumps[nums.length - 1] = true;
        LinkedList<Integer> goodSteps = new LinkedList<>();
        goodSteps.add(nums.length - 1);
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int step: goodSteps) {
                if (canJumps[step] && step - i <= nums[i]) {
                    canJumps[i] = true;
                    break;
                }
            }
        }
        return canJumps[0];
    }
}
