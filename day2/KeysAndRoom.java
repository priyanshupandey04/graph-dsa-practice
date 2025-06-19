import java.util.*;
public class KeysAndRoom {
    public static void main(String[] args) {
        // [[1,3],[3,0,1],[2],[0]]
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(Arrays.asList(1, 3));
        rooms.add(Arrays.asList(3, 0, 1));
        rooms.add(Arrays.asList(2));
        rooms.add(Arrays.asList(0));
        System.out.println(canVisitAllRooms(rooms));
    }

    static public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int numRooms = rooms.size();
        boolean[] visited = new boolean[numRooms];
        Queue<Integer> queue = new LinkedList<>();
        visited[0] = true;
        queue.add(0);
        while (!queue.isEmpty()) {
            int currentRoom = queue.poll();
            List<Integer> currentRooms = rooms.get(currentRoom);
            for (Integer room : currentRooms) {
                if (!visited[room]) {
                    visited[room] = true;
                    queue.add(room);
                }
            }
        }
        for (boolean b : visited) {
            if (!b)
                return false;
        }
        return true;
    }

}
