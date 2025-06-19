import java.util.*;

class RottingOranges {

    public static void main(String[] args) {
        int[][] grid = { { 0, 1, 2 }, { 1, 1, 0 }, { 2, 1, 0 } };
        System.out.println(orangesRotting(grid));
    }

    static public int orangesRotting(int[][] grid) {
        int r = grid.length, c = grid[0].length;
        int[][] temp = new int[r][c];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[] { i, j, 0 });
                }
            }
        }
        int max = 0;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int i = curr[0], j = curr[1], time = curr[2];
            int[][] neighbors = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

            for (int[] u : neighbors) {
                int x = i + u[0], y = j + u[1];
                if (x >= 0 && x < r && y >= 0 && y < c && grid[x][y] == 1 && temp[x][y] == 0) {
                    queue.add(new int[] { x, y, time + 1 });
                    temp[x][y] = 2;
                    max = Math.max(max, time + 1);
                }
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1 && temp[i][j] != 2)
                    return -1;
            }
        }
        return max;
    }

}