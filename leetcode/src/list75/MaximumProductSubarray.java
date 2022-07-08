package list75;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
// Bad solution
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        List<Integer> l = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 || i == nums.length-1) {
                l.add(calculate(nums, start, i));
                start = i + 1;
            }
        }
        return l.stream().max(Comparator.comparingInt(a -> a)).orElse(0);
    }
    public int calculate(int[] nums, int start, int end) {
        int maxNegativeI = start;
        int minNegativeI = start;
        for (int i = start + 1; i <= end; i++) {
            nums[i] *= nums[i-1];
            if (nums[minNegativeI] > 0 && nums[i] < 0) {
                maxNegativeI = i;
                minNegativeI = i;
            }
        }
        int defValue = start;
        for (int i = start; i <= end; i++) {
            if (nums[i] >= 0) {
                if (nums[i] > nums[defValue])
                    defValue = i;
            } else {
                if (nums[i] <= nums[minNegativeI]) {
                    minNegativeI = i;
                }
                if (nums[i] > nums[maxNegativeI]) {
                    maxNegativeI = i;
                }
            }
        }
        if (minNegativeI == maxNegativeI || nums[minNegativeI] > 0)
            return nums[defValue];
        return Math.max(nums[defValue], nums[minNegativeI]/nums[maxNegativeI]);
    }

    public static void main(String[] args) {
        MaximumProductSubarray maximumProductSubarray = new MaximumProductSubarray();
        System.out.println(maximumProductSubarray.maxProduct(new int[]{-2,1,0}));
//        int[] arr = new int[8];
//        Random rand = new Random();
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = rand.nextInt(20) + -10;
//            System.out.print(arr[i] + ",");
//        }
//        System.out.println();
//        System.out.println(maximumProductSubarray.maxProduct(arr));
    }
}
