import java.util.*;

public class _01MatrixDP {
    public static void main(String[] args) {
        int[][] matrix = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 },
                { 1, 1, 1 } };
        _01MatrixDP matrix1 = new _01MatrixDP();
        System.out.println(Arrays.deepToString(matrix1.updateMatrix(matrix)));
    }

    public int[][] updateMatrix(int[][] mat) {
        int r = mat.length, c = mat[0].length;
        int[][] dp = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (mat[i][j] == 1) {
                    int min = 100000;
                    if (i - 1 >= 0) min = Math.min(min, dp[i - 1][j] + 1);
                    if (j - 1 >= 0) min = Math.min(min, dp[i][j - 1] + 1);
                    dp[i][j] = min;
                }
            }
        }

        for (int i = r - 1; i >= 0; i--) {
            for (int j = c - 1; j >= 0; j--) {
                if (mat[i][j] == 1) {
                    int min = 100000;
                    if (i + 1 < r) min = Math.min(min, dp[i + 1][j] + 1);
                    if (j + 1 < c) min = Math.min(min, dp[i][j + 1] + 1);
                    dp[i][j] = Math.min(min, dp[i][j]);
                }
            }
        }
        return dp;
    }
}
