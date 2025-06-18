import java.util.*;

public class CountCompleteComponents {
    public static void main(String[] args) {
        // [[0,1],[0,2],[1,2],[3,4],[3,5]]
        int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {3, 4}, {3, 5}};
        System.out.println(countCompleteComponents(6, edges));
    }

    static public int countCompleteComponents(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        int count = 0;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                boolean[] allNodesOfComponent = new boolean[n];
                dfs(i, adj, visited, allNodesOfComponent);
                count+= isCompleteComponent(allNodesOfComponent, adj) ? 1 : 0;
            }
        }
        return count;
    }

    static boolean isCompleteComponent(boolean[] allNodesOfComponent, List<List<Integer>> adj) {
        int total = 0;
        for (boolean isComplete : allNodesOfComponent) {
            total += isComplete ? 1 : 0;
        }
        for (int i = 0; i < allNodesOfComponent.length; i++) {
            if (allNodesOfComponent[i]) {
                List<Integer> neighbours = adj.get(i);
                int count = 0;
                for (Integer v : neighbours) {
                    if(allNodesOfComponent[v]){
                        count++;
                    }
                }
                if(count + 1 != total) return false;
            }
        }

        return true;
    }

    static void dfs(int node, List<List<Integer>> adj, boolean[] visited, boolean[] allNodesOfComponent) {
        visited[node] = true;
        allNodesOfComponent[node] = true;
        List<Integer> neighbours = adj.get(node);
        for (Integer v : neighbours) {
            if (!visited[v]) {
                dfs(v, adj, visited, allNodesOfComponent);
            }
        }
    }
}