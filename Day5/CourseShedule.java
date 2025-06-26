import java.util.*;

class CourseShedule {
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = { { 1, 0 }, { 0, 1 } };
        System.out.println(canFinish(numCourses, prerequisites));

    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        return topoSort(numCourses, prerequisites) == numCourses;
    }

    public static int topoSort(int V, int[][] edges) {
        int nodes = V;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
        }

        boolean[] visited = new boolean[nodes];
        boolean[] pathVisited = new boolean[nodes];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nodes; i++) {
            if (!visited[i])
                if (dfs(i, adj, visited, stack, pathVisited))
                    return -1;
        }
        return stack.size();
    }

    private static boolean dfs(int node, List<List<Integer>> adj, boolean[] visited, Stack<Integer> stack,
            boolean[] pathVisited) {
        visited[node] = true;
        pathVisited[node] = true;
        List<Integer> neighbors = adj.get(node);
        for (Integer i : neighbors) {
            if (visited[i] && pathVisited[i])
                return true;
            if (!visited[i]) {
                if (dfs(i, adj, visited, stack, pathVisited))
                    return true;
            }
        }

        pathVisited[node] = false;
        stack.push(node);
        return false;
    }
}
