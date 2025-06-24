import java.util.*;

public class CycleDetectionInDirectedGraph {
    public static void main(String[] args) {
        int[][] prerequisites = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 }, { 5, 6 } };
        System.out.println((detectCycle(7, prerequisites)));
    }

    static public boolean  detectCycle(int numCourses, int[][] prerequisites) {
        int row = prerequisites.length;

        ArrayList<ArrayList<Integer>> directAdj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            directAdj.add(new ArrayList<>());
        }

        for (int i = 0; i < row; i++) {
            int u = prerequisites[i][0], v = prerequisites[i][1];
            directAdj.get(v).add(u);
        }
        boolean isCycle = isCycle(directAdj);
        if (isCycle) return true;

        return false;
    }

    private static boolean isCycle(ArrayList<ArrayList<Integer>> directAdj) {
        boolean[] visited = new boolean[directAdj.size()];
        boolean[] pathVisited = new boolean[directAdj.size()];

        for (int i = 0; i < pathVisited.length; i++) {
            if (!visited[i]) {
                if (isCycleExists(i, directAdj, visited, pathVisited))
                    return true;
            }
        }
        return false;
    }

    private static boolean isCycleExists(int node, ArrayList<ArrayList<Integer>> directAdj, boolean[] visited,
            boolean[] pathVisited) {
        visited[node] = true;
        pathVisited[node] = true;

        ArrayList<Integer> neighbours = directAdj.get(node);
        for (int i : neighbours) {
            if (pathVisited[i])
                return true;
            if (visited[i])
                continue;
            if (isCycleExists(i, directAdj, visited, pathVisited))
                return true;
        }

        pathVisited[node] = false;
        return false;
    }
}
