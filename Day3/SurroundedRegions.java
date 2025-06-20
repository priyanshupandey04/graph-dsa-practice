import java.util.*;

public class SurroundedRegions {
    public static void main(String[] args) {
        char[][] board = { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
                { 'X', 'O', 'X', 'X' } };
        SurroundedRegions surroundedRegions = new SurroundedRegions();
        surroundedRegions.solve(board);
        for (char[] cs : board) {
            System.out.println(Arrays.toString(cs));
        }
    }

    public void solve(char[][] board) {
        int r = board.length, c = board[0].length;
        boolean[][] visited = new boolean[r][c];
        for (int i = 0; i < c; i++) {
            if (board[0][i] == 'O')
                dfs(0, i, visited, board, r, c);
            if (board[r - 1][i] == 'O')
                dfs(r - 1, i, visited, board, r, c);
        }

        for (int i = 0; i < r; i++) {
            if (board[i][0] == 'O')
                dfs(i, 0, visited, board, r, c);
            if (board[i][c - 1] == 'O')
                dfs(i, c - 1, visited, board, r, c);
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 'O' && !visited[i][j])
                    board[i][j] = 'X';
            }
        }
    }

    private void dfs(int i, int j, boolean[][] visited, char[][] board, int r, int c) {
        if (i < 0 || i >= r || j < 0 || j >= c || visited[i][j] || board[i][j] == 'X')
            return;
        visited[i][j] = true;
        dfs(i + 1, j, visited, board, r, c);
        dfs(i - 1, j, visited, board, r, c);
        dfs(i, j + 1, visited, board, r, c);
        dfs(i, j - 1, visited, board, r, c);
    }
}
