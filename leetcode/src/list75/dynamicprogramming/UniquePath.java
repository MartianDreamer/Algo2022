package list75.dynamicprogramming;

public class UniquePath {

    public int uniquePaths(int m, int n) {
        int[][] map = new int[m][n];
        return uniquePaths(map, m - 1, n - 1, m, n);
    }

    public int uniquePaths(int[][] map, int i, int j, int m, int n) {
        if (i == 0 && j == 0) {
            map[i][j] = 1;
            return 1;
        }
        if (i - 1 >= 0 && j - 1 >= 0) {
            if (map[i - 1][j] == 0) {
                map[i - 1][j] = uniquePaths(map, i - 1, j, m, n);
            }
            if (map[i][j - 1] == 0) {
                map[i][j - 1] = uniquePaths(map, i, j - 1, m, n);
            }
            map[i][j] = map[i][j - 1] + map[i - 1][j];
        } else if (i - 1 < 0) {
            if (map[i][j - 1] == 0) {
                map[i][j - 1] = uniquePaths(map, i, j - 1, m, n);
            }
            map[i][j] = map[i][j - 1];
        } else {
            if (map[i - 1][j] == 0) {
                map[i - 1][j] = uniquePaths(map, i - 1, j, m, n);
            }
            map[i][j] = map[i - 1][j];
        }
        return map[i][j];
    }
}
