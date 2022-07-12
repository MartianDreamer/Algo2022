package list75;

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int current = nums.length - 1;
        int left = 0;
        while (current - left > 1) {
            if (nums[(current + left) / 2] < nums[current])
                current = (current + left) / 2;
            else
                left = (current + left) / 2;
        }
        return Math.min(nums[left], nums[current]);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4};
        System.out.println(new FindMinimumInRotatedSortedArray().findMin(arr));
    }
}
