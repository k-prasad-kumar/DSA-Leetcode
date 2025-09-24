class Solution {
    public boolean isSafe(int row, int col, char[][] board, char val, int n){
		for(int i=0; i<n; i++){
			// check row and col
			if(board[row][i] == val || board[i][col] == val) return false;

			// check 3*3 matrix
			// if(board[3 * (row/3) + i/3][3 *(col/3) + i%3] == val) return false;
		}

		// grid (3x3)
		int srow = (row/3) * 3;
		int scol = (col/3) * 3;
		for(int i = srow; i<srow+3; i++) {
			for(int j = scol; j<scol+3; j++) {
				if(board[i][j] == val){
					return false;
				}
			}
		}

		return true;
	}

    public boolean solve(char[][] board){
		int n = board[0].length;

		for(int row=0; row<n; row++){
			for(int col=0; col<n; col++){
				if(board[row][col] == '.'){
					for(char val='1'; val<='9'; val++){
						if(isSafe(row, col, board, val, n)){
							board[row][col] = val;
							
							boolean isSolved = solve(board); // Recursion

							if(isSolved) return true;
							else board[row][col] = '.'; // backtracking
						}
					}
					return false; // if we can't place 1-9 digit in empty space then return false
				}
			}
		}

		return true; // if every thing goes right return true
	}

    public void solveSudoku(char[][] board) {
        solve(board);
    }
}