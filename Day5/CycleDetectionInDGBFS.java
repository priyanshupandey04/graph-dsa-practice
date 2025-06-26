import java.util.*;

public class CycleDetectionInDGBFS {
    public static void main(String[] args) {
        // V = 4, edges[][] = [[0, 1], [0, 2], [1, 2], [2, 0], [2, 3]]
        int V = 4;
        int[][] edges = { { 0, 1 }, { 0, 2 }, { 1, 2 }, { 2, 3 } };
        System.out.println(isCyclic(V, edges));
    }

    public static boolean isCyclic(int V, int[][] edges) {
        return topoSort(V, edges).size() != V;
    }

    private static ArrayList<Integer> topoSort(int v, int[][] edges) {
        int nodes = v;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int U = edges[i][0];
            int V = edges[i][1];
            adj.get(U).add(V);
        }

        Queue<Integer> queue = new LinkedList<>();

        int[] indegree = new int[nodes];
        calculateIndegree(nodes, adj, indegree);

        boolean[] visited = new boolean[nodes];
        for (int i = 0; i < nodes; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        ArrayList<Integer> topo = new ArrayList<>();
        while (!queue.isEmpty()) {
            int first = queue.poll();
            topo.add(first);
            visited[first] = true;

            List<Integer> neighbors = adj.get(first);
            for (Integer i : neighbors) {
                if (visited[i])
                    continue;
                if (--indegree[i] == 0)
                    queue.add(i);
            }
        }

        return topo;
    }

    private static void calculateIndegree(int nodes, List<List<Integer>> adj, int[] indegree) {
        for (int i = 0; i < nodes; i++) {
            for (Integer j : adj.get(i)) {
                indegree[j]++;
            }
        }
    }
}
