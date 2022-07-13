package list75.array;

import java.util.*;
import java.util.stream.Collectors;

//Bad solution

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rs = new ArrayList<>();
        Set<Integer> passedI = new HashSet<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (passedI.contains(nums[i]))
                continue;
            Map<Integer, Integer> met = new HashMap<>();
            for (int j = i + 1; j < nums.length; j++) {
                if (passedI.contains(nums[j]))
                    continue;
                if (met.getOrDefault(-nums[i] - nums[j], 0) == 1) {
                    rs.add(List.of(nums[i], -nums[i]-nums[j], nums[j]));
                    met.put(-nums[i] - nums[j], 0);
                    met.putIfAbsent(nums[j], 0);
                } else {
                    met.putIfAbsent(nums[j], 1);
                }
            }
            passedI.add(nums[i]);
        }
        return rs;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        System.out.println(threeSum.threeSum(new int[]{-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0}));
    }
}
