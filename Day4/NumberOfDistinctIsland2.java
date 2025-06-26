import java.util.*;

public class NumberOfDistinctIsland2 {
    public static void main(String[] args) {
        int[][] grid = { { 1, 1, 0, 1, 1 }, { 1, 0, 0, 0, 0 }, { 0, 0, 0, 0, 1 }, { 1, 1, 0, 1, 1 } };
        System.out.println(countDistinctIslands(grid));
    }

    static int countDistinctIslands(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        HashSet<ArrayList<Integer>> islands = new HashSet<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    ArrayList<Integer> island = new ArrayList<>();
                    dfs(i, j, i, j, grid, visited, islands, island);
                    islands.add(island);
                }
            }
        }

        return islands.size();
    }

    static private void dfs(int i, int j,int startI, int startJ, int[][] grid, boolean[][] visited, HashSet<ArrayList<Integer>> islands, ArrayList<Integer> island) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || visited[i][j]) return;

        visited[i][j] = true;
        island.add(i - startI);
        island.add(j - startJ);
        
        int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            dfs(x, y, startI, startJ, grid, visited, islands, island);
        }
    }
}
