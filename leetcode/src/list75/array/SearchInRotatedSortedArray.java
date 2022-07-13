package list75.array;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int minI = findMin(nums);
        int min1 = binSearch(nums, minI, nums.length - 1, target);
        int min2 = binSearch(nums, 0, minI - 1, target);
        return min1 != -1 ? min1 : min2;
    }

    public int binSearch(int nums[], int start, int end, int target) {
        if (start < 0 || end < 0)
            return -1;
        while (end - start > 1) {
            int mid = (start + end) / 2;
            if (nums[mid] > target) {
                end = mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                return mid;
            }
        }
        return nums[start] == target ? start : nums[end] == target ? end : -1;
    }

    public int findMin(int[] nums) {
        int current = nums.length - 1;
        int left = 0;
        while (current - left > 1) {
            if (nums[(current + left) / 2] < nums[current])
                current = (current + left) / 2;
            else
                left = (current + left) / 2;
        }
        return nums[left] < nums[current] ? left : current;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,5,6,7,0,1,2};
        SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();
        System.out.println(searchInRotatedSortedArray.search(arr, 0));
    }
}
