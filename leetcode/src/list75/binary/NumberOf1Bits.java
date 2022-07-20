package list75.binary;

public class NumberOf1Bits {
    public int hammingWeight(int n) {
        int count = 0;
        for (int i =0; i < 32; i++) {
            count += n&1;
            n >>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new NumberOf1Bits().hammingWeight(-3));
    }
}
