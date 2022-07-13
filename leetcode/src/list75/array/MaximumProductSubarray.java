package list75.array;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int max  = Integer.MIN_VALUE;
        int current = 1;
        for (int i = 0; i < nums.length; i++) {
            if (current == 0)
                current = 1;
            current *= nums[i];
            max = Math.max(max, current);
        }
        current = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (current == 0)
                current = 1;
            current *= nums[i];
            max = Math.max(max, current);
        }
        return max;
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
