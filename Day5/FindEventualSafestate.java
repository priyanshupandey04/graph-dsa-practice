import java.util.*;

public class FindEventualSafestate {
    public static void main(String[] args) {
        int[][] graph = { { 1, 2 }, { 3, 2 }, { 5 }, { 0 }, { 5 }, {}, {} };
        System.out.println(eventualSafeNodes(graph));
    }

    public static List<Integer> eventualSafeNodes(int[][] graph) {
        int nodes = graph.length;
        boolean[] visited = new boolean[nodes];
        boolean[] pathVisited = new boolean[nodes];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                dfs(i, graph, visited, pathVisited);
            }
        }

        List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            if (!pathVisited[i])
                safeNodes.add(i);
        }
        return safeNodes;
    }

    private static boolean dfs(int node, int[][] adj, boolean[] visited, boolean[] pathVisited) {
        visited[node] = true;
        pathVisited[node] = true;

        boolean isCycle = false;
        int[] neighbors = adj[node];

        for (int i : neighbors) {
            if (visited[i] && pathVisited[i])
                return true;
            if (!visited[i] && dfs(i, adj, visited, pathVisited)) {
                return true;
            }
        }
        pathVisited[node] = isCycle;
        return isCycle;
    }
}
