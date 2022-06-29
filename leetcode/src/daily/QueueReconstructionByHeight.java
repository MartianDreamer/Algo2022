package daily;

import java.util.Arrays;

//Input: people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
//        Output: [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
// Bad version, although it works...

public class QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[1] * 1000000 + a[0] - b[1] * 1000000 - b[0]);
        for (int i = 1; i < people.length; i++) {
            if (people[i][1] != people[i-1][1]) {
                int count = 0;
                for (int j = 0; j < i; j++) {
                    if (people[j][0] >= people[i][0]) {
                        count++;
                    }
                }
                int swapi = i;
                while(count != people[swapi][1]) {
                    int[] temp = people[swapi-1];
                    people[swapi-1] = people[swapi];
                    people[swapi] = temp;
                    count--;
                    swapi--;
                }
            }
        }
        return people;
    }
}
