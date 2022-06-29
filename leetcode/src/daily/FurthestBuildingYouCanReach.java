package daily;

import java.util.PriorityQueue;

//https://leetcode.com/problems/furthest-building-you-can-reach/
// I know it's a terrible solution, feel free to laugh at it...

public class FurthestBuildingYouCanReach {

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        for (int i = 0; i < heights.length - 1; i++) {
            heights[i] = heights[i + 1] - heights[i] > 0 ? heights[i + 1] - heights[i] : 0;
        }
        return 1 + furthestBuilding(heights, heights.length - 1, 0, new PriorityQueue<>((x, y) -> y - x), bricks, ladders);
    }

    public int furthestBuilding(int[] diffs, int len, int start, PriorityQueue<Integer> queue, int bricks, int ladders) {
        int furthest = start - 1;
        for (int i = start; i < len; i++) {
            bricks -= diffs[i];
            queue.add(diffs[i]);
            if (bricks < 0) {
                break;
            }
            furthest = i;
        }
        if (furthest == len - 1)
            return furthest;
        if (ladders > 0) {
            ladders--;
            furthest++;
            int max = queue.poll();
            bricks += max;
            return furthestBuilding(diffs, len, furthest + 1, queue, bricks, ladders);
        }
        return furthest;
    }
}
