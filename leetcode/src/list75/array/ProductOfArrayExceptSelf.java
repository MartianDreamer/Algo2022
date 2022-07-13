package list75.array;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int numsi = 1;
                for (int j = 0; j < nums.length; j++) {
                    if (j == i)
                        continue;
                    numsi *= nums[j];
                    nums[j] = 0;
                }
                nums[i] = numsi;
                return nums;
            }
        }
        int nums0 = 1;
        int originalNumsi = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums0 *= nums[i];
        }
        nums[0] = nums0;
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            nums[i] = nums[i-1]*originalNumsi/nums[i];
            originalNumsi = temp;
        }
        return nums;
    }
}
