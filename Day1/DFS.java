import java.util.*;

public class DFS {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = createAdjencyList();
        System.out.println("adj = " + adj);
        DFS(adj);
    }

    static void DFS(ArrayList<ArrayList<Integer>> adj) {
        int nodes = adj.size();
        boolean[] visited = new boolean[nodes];
        ArrayList<Integer> dfs = new ArrayList<>();
        dfs(1, adj, dfs, visited);
        System.out.println("dfs = " + dfs);
    }

    static void dfs(int node, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> dfs, boolean[] visited) {
        visited[node] = true;
        dfs.add(node);
        ArrayList<Integer> neighbour = adj.get(node);
        for (Integer v : neighbour) {
            if (!visited[v]) {
                dfs(v, adj, dfs, visited);
            }
        }
    }

    static ArrayList<ArrayList<Integer>> createAdjencyList() {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(1).add(3);

        adj.get(2).add(1);
        adj.get(2).add(7);

        adj.get(3).add(1);
        adj.get(3).add(4);
        adj.get(3).add(6);

        adj.get(4).add(3);
        adj.get(4).add(5);

        adj.get(5).add(4);
        adj.get(5).add(6);

        adj.get(6).add(3);
        adj.get(6).add(5);

        adj.get(7).add(2);
        return adj;
    }
}
