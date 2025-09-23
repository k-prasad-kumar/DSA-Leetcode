class Solution {

    public void construct(char[][] board, List<List<String>> ans, int n){
        List<String> temp = new ArrayList<>();

        for(char[] row: board) temp.add(new String(row));

        ans.add(temp);
    }

    public boolean isSafe(int row, int col, char[][] board, int n){
        int x = row;
        int y = col;

        // check for same row
        while(y >= 0){
            if(board[x][y] == 'Q') return false;
            y--;
        }

        // check for diagnal - left upside
        x = row;
        y = col;
        while(x >= 0 && y >= 0){
            if(board[x][y] == 'Q') return false;
            x--;
            y--;
        }

        // check for diagnal - left downside
        x = row;
        y = col;
        while(x < n && y >= 0){
            if(board[x][y] == 'Q') return false;
            x++;
            y--;
        }

        return true;
    }

    public void solve(int col, char[][] board, List<List<String>> ans, int n){
        // base case
        if(col == n) {
            construct(board, ans, n);
            return;
        }

        for(int row = 0; row < n; row++){
            if(isSafe(row, col, board, n)){
                board[row][col] = 'Q';
                solve(col+1, board, ans, n);
                board[row][col] = '.';
            }
        }
    }

    public int totalNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        
        // fill board with dot '.' as default
        for (char[] row : board) Arrays.fill(row, '.');

        solve(0, board, ans, n);

        return ans.size();
    }
}