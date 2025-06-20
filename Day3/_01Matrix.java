import java.util.*;

public class _01Matrix {
    public static void main(String[] args) {
        // [[0,0,0],[0,1,0],[1,1,1]]
        int[][] matrix = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };
        _01Matrix matrix1 = new _01Matrix();
        System.out.println(Arrays.deepToString(matrix1.updateMatrix(matrix)));
    }

    public int[][] updateMatrix(int[][] mat) {
        int r = mat.length, c = mat[0].length;
        int[][] temp = new int[r][c];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[] { i, j , 0});
                }
            }
        }

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int i = curr[0], j = curr[1], step = curr[2];
            int[][] directions = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
            for (int[] u : directions) {
                int x = i + u[0], y = j + u[1];
                if(x >= 0 && x < r && y >= 0 && y < c && temp[x][y] == 0 && mat[x][y] == 1){
                    queue.add(new int[] { x, y, step + 1 });
                    temp[x][y] = step + 1;
                }
            }
        }

        return temp;
    }
}
