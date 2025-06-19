import java.util.*;

public class FloodFill {
    public static void main(String[] args) {
        int[][] image = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
        System.out.println(Arrays.deepToString(floodFill(image, 1, 1, 2)));
    }

    static public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int r = image.length, c = image[0].length, initialColor = image[sr][sc];
        boolean[][] visited = new boolean[r][c];
        dfs(image, sr, sc, initialColor, color, visited, r, c);
        return image;
    }

    static void dfs(int[][] image, int i, int j, int startColor, int newColor, boolean [][] visited, int r, int c) {
        if(i < 0 || i >= r || j < 0 || j >= c || visited[i][j] || image[i][j] != startColor)
            return;
        image[i][j] = newColor;
        visited[i][j] = true;
        dfs(image, i + 1, j, startColor, newColor, visited, r, c);
        dfs(image, i - 1, j, startColor, newColor, visited, r, c);
        dfs(image, i, j + 1, startColor, newColor, visited, r, c);
        dfs(image, i, j - 1, startColor, newColor, visited, r, c);
    }
}