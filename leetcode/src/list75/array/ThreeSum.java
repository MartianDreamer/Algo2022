package list75.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> rs = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            if (i != 0 && nums[i] == nums[i - 1])
                continue;
            while (start < end) {
                if (nums[start] + nums[end] + nums[i] == 0) {
                    rs.add(List.of(nums[i], nums[start], nums[end]));
                    while (start < end && nums[start + 1] == nums[start])
                        start++;
                    while (start < end && nums[end - 1] == nums[end])
                        end--;
                    start++;
                } else if (nums[start] + nums[end] + nums[i] < 0) {
                    start++;
                } else
                    end--;
            }
        }
        return rs;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        System.out.println(threeSum.threeSum(new int[]{-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0}));
    }
}
