import java.util.*;

public class BFS {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = createAdjencyList();
        System.out.println("adj = " + adj);
        BFS(adj);
    }

    static void BFS(ArrayList<ArrayList<Integer>> adj) {
        int nodes = adj.size();
        boolean[] visited = new boolean[nodes];
        ArrayList<Integer> bfs = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int x = queue.poll();
            bfs.add(x);
            ArrayList<Integer> neighbours = adj.get(x);
            for (Integer v : neighbours) {
                if (!visited[v]) {
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }
        System.out.println("bfs = " + bfs);
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
