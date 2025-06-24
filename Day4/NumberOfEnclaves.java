import java.util.*;

public class NumberOfEnclaves {
    public static void main(String[] args) {
        int[][] grid = { { 0, 1, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 } };
        System.out.println(numEnclaves(grid));
    }

    static public int numEnclaves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            if (grid[i][0] == 1) {
                visited[i][0] = true;
                queue.add(new int[] { i, 0 });
            }
            if (grid[i][cols - 1] == 1) {
                visited[i][cols - 1] = true;
                queue.add(new int[] { i, cols - 1 });
            }
        }

        for (int i = 0; i < cols; i++) {
            if (grid[0][i] == 1) {
                visited[0][i] = true;
                queue.add(new int[] { 0, i });
            }
            if (grid[rows - 1][i] == 1) {
                visited[rows - 1][i] = true;
                queue.add(new int[] { rows - 1, i });
            }
        }

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int i = node[0], j = node[1];

            int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
            for (int[] dir : dirs) {
                int x = i + dir[0], y = j + dir[1];
                if (x >= 0 && x < rows && y >= 0 && y < cols && !visited[x][y] && grid[x][y] == 1) {
                    queue.add(new int[] { x, y });
                    visited[x][y] = true;
                }
            }
        }
        
        return getEnclavedIslands(grid, visited);
    }

    static private int getEnclavedIslands(int[][] grid, boolean[][] visited) {
        int rows = grid.length, cols = grid[0].length, cnt = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited[i][j])
                    cnt++;
            }
        }
        return cnt;
    }

}
