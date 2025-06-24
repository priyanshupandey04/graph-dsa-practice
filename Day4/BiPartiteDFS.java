import java.util.*;

public class BiPartiteDFS {
    public static void main(String[] args) {
        int[][] graph = { { 1, 3 }, { 0, 2 }, { 1, 3 }, { 0, 2 } };
        System.out.println(isBipartite(graph));
    }

    static public boolean isBipartite(int[][] graph) {
        int row = graph.length, col = graph[0].length;
        int[] color = new int[row];
        Arrays.fill(color, -1);

        for (int i = 0; i < row; i++) {
            if (color[i] == -1) {
                if (!dfs(i, graph, color, 0))
                    return false;
            }
        }
        return true;
    }

    private static boolean dfs(int node, int[][] graph, int[] color, int currentColor) {
        color[node] = currentColor;
        int[] neighbours = graph[node];

        for (int i : neighbours) {
            if (color[i] == -1) {
                if (!dfs(i, graph, color, currentColor == 0 ? 1 : 0))
                    return false;
            } else if (color[i] == currentColor)
                return false;
        }

        return true;
    }
}
