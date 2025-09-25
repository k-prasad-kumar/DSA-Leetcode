class Solution {
    public boolean isSafe(int row, int col, char[][] board, char val, int n){
		for(int i=0; i<n; i++){
			// check row and col
            if(i != row){
                if(board[i][col] == val) return false;
            }

            if(i != col){
			    if(board[row][i] == val) return false;
            }
            
			// check 3*3 matrix
			// if(board[3 * (row/3) + i/3][3 *(col/3) + i%3] == val) return false;
		}

		// grid (3x3)
		int srow = (row/3) * 3;
		int scol = (col/3) * 3;
		for(int i = srow; i<srow+3; i++) {
			for(int j = scol; j<scol+3; j++) {
				if(i != row && j != col){
                    if(board[i][j] == val){
					    return false;
				    }
                }
			}
		}

		return true;
	}

    public boolean solve(char[][] board){
		int n = board[0].length;

		for(int row=0; row<n; row++){
			for(int col=0; col<n; col++){
                char val = board[row][col];
				if(val != '.'){
                    if(!isSafe(row, col, board, val, n)) return false;
				}
			}
		}

		return true; // if every thing goes right return true
	}

    public boolean isValidSudoku(char[][] board) {
        return solve(board);
    }
}