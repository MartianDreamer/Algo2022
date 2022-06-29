package daily;

import java.util.ArrayList;
import java.util.Arrays;

//Input: people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
//        Output: [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
// Bad version, although it works...

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
