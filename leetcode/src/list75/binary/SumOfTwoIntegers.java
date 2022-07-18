package list75.binary;

public class SumOfTwoIntegers {
    public int getSum(int a, int b) {
        int rem = (a & b) << 1;
        if (rem == 0)
            return a ^ b;
        return getSum(a ^ b, rem);
    }

    public static void main(String[] args) {
        SumOfTwoIntegers sumOfTwoIntegers = new SumOfTwoIntegers();
        System.out.println(sumOfTwoIntegers.getSum(17, -12));
    }
}
