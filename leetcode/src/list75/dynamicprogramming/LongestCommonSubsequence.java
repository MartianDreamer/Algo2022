package list75.dynamicprogramming;

import java.util.stream.Stream;

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] counts = new int[text2.length()][2];
        for (int i = 0; i < counts.length; i++) {
            counts[i][0] = -1;
        }
        int count = 0;
        for (int i = 0; i < text1.length(); i++) {
            count = 0;
            int countI = -1;
            for (int j = 0; j < text2.length(); j++) {
                if (counts[j][0] < i && counts[j][1] > count) {
                    count = counts[j][1];
                    countI = j;
                }
                if (text1.charAt(i) == text2.charAt(j) && j != countI) {
                    counts[j][0] = i;
                    counts[j][1] = count + 1;
                }
            }
        }
        return Stream.of(counts).map(e -> e[1]).max(Integer::compareTo).orElse(0);
    }

    public static void main(String[] args) {
        var text1 = "abcba";
        var text2 = "abcbcba";
        System.out.println(new LongestCommonSubsequence().longestCommonSubsequence(text1, text2));
    }

}
