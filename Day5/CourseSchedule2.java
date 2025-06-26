import java.util.*;

public class CourseSchedule2 {
    public static void main(String[] args) {
        // numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
        int numCourses = 4;
        int[][] prerequisites = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
        System.out.println(Arrays.toString(findOrder(numCourses, prerequisites)));
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> topo = topoSort(numCourses, prerequisites);
        if (topo.size() != numCourses)
            return new int[] {};
        int[] order = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            order[i] = topo.get(numCourses - i - 1);
        }
        return order;
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
