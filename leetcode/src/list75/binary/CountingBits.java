package list75.binary;

public class CountingBits {

    public int hammingWeight(int num) {
        int count = 0;
        while (num != 0) {
            count += num&1;
            num >>= 1;
        }
        return count;
    }

    public int[] countBits(int n) {
        int[] arr = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            arr[i] = hammingWeight(i);
        }
        return arr;
    }
}
