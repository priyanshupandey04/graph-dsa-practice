
public class NumberOfIsland {
    public static void main(String[] args) {
        char[][] grid = { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '0', '0', '0' } };
        System.out.println(numIslands(grid));
    }

    static public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length, count = 0;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    count++;
                    dfs(i, j, grid, visited, m, n);
                }
            }
        }
        return count;
    }

    static void dfs(int i, int j, char[][] grid, boolean[][] visited, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0' || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        int[][] neighbours = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        for (int[] v : neighbours) {
            int x = i + v[0], y = j + v[1];
            dfs(x, y, grid, visited, m, n);
        }
    }

}
