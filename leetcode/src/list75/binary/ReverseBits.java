package list75.binary;

public class ReverseBits {
    public static int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int temp = n & 1;
            result = (result << 1) | temp;
            n >>= 1;
        }
        return result;
    }
}
