package daily;

import java.util.ArrayList;
import java.util.Arrays;

//https://leetcode.com/problems/queue-reconstruction-by-height/

public class QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> b[0] * people.length + a[1] - a[0] * people.length - b[1]);
        ArrayList<int[]> list = new ArrayList<>();
        for (var per : people) {
            list.add(per[1], per);
        }
        return list.toArray(new int[][]{});
    }
}
