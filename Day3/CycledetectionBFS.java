import java.util.*;

public class CycledetectionBFS {
    public static void main(String[] args) {
        int V = 4;
        int E = 4;
        int[][] edges = { { 0, 1 }, { 0, 2 }, { 1, 2 }, { 2, 3 } };
        CycledetectionBFS cycle = new CycledetectionBFS();
        System.out.println(cycle.isCycle(V, edges));
    }

    public boolean isCycle(int V, int[][] edges) {
        int nodes = V;
        boolean[] visited = new boolean[nodes];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        for (int i = 0; i < nodes; i++) {
            if(!visited[i]){
                if(bfs(visited, adj, i)) return true;
            }
        }
        return false;
    }

    private boolean bfs(boolean[] visited, ArrayList<ArrayList<Integer>> adj, int start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { start, -1 });
        visited[start] = true;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int node = curr[0], parent = curr[1];
            ArrayList<Integer> neighbour = adj.get(node);
            for (Integer v : neighbour) {
                if (!visited[v]) {
                    visited[v] = true;
                    queue.add(new int[] { v, node });
                } else if (v != parent) {
                    return true;
                }
            }
        }
        return false;
    }
}
