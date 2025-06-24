import java.util.*;

public class BiPartiteBFS {
    public static void main(String[] args) {
        int[][] graph = { { 1, 2, 3 }, { 0, 2 }, { 0, 1, 3 }, { 0, 2 } };
        System.out.println(isBipartite(graph));
    }

    static public boolean isBipartite(int[][] graph) {
        int row = graph.length, col = graph[0].length;
        int[] color = new int[row];
        Arrays.fill(color, -1);

        for (int i = 0; i < row; i++) {
            if (color[i] == -1) {
                if (!bfs(i, graph, color, 0))
                    return false;
            }
        }
        return true;
    }

    private static boolean bfs(int node, int[][] graph, int[] color, int currentColor) {

        Queue<Integer> queue = new LinkedList<>();
        color[node] = currentColor;
        queue.add(node);

        while (!queue.isEmpty()) {
            int i = queue.poll(), nextColor = color[i] == 0 ? 1 : 0;
            int[] neighbours = graph[i];
            for (int j : neighbours) {
                if (color[j] == -1) {
                    color[j] = nextColor;
                    queue.add(j);
                } else if (color[j] == color[i])
                    return false;
            }
        }

        return true;
    }

}
