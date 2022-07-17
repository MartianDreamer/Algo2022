package list75.binary;

public class SumOfTwoIntegers {
    public int getSum(int a, int b) {
        if (a == 0)
            return b;
        if (b == 0)
            return a;
        int rem = (a&b) << 1;
        return getSum(a^b,rem);
    }

    public static void main(String[] args) {
        SumOfTwoIntegers sumOfTwoIntegers = new SumOfTwoIntegers();
        System.out.println(sumOfTwoIntegers.getSum(17,-12));
    }
}
