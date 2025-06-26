import java.util.*;

public class KahnAlgo {
    public static void main(String[] args) {
        int V = 6;
        int[][] edges = { { 1, 3 }, { 2, 3 }, { 4, 1 }, { 4, 0 }, { 5, 0 }, { 5, 2 } };
        System.out.println(topoSort(V, edges));
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
            if(indegree[i] == 0) {
                queue.add(i);
            }
        }
        ArrayList<Integer> topo = new ArrayList<>();
        while(!queue.isEmpty()) {
            int first = queue.poll();
            topo.add(first);
            visited[first] = true;

            List<Integer> neighbors = adj.get(first);
            for (Integer i : neighbors) {
                if(visited[i]) continue;
                if(--indegree[i] == 0) queue.add(i); 
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
