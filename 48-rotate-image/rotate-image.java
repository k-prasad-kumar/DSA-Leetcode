class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // Transpose the matrix
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i < j){
                    int t = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = t;
                }
            }
        }

        // reverse the each row
        for(int i=0; i<n; i++){
            int s = 0;
            int e = matrix[i].length-1;

            while(s<=e){
                int t = matrix[i][s];
                matrix[i][s] = matrix[i][e];
                matrix[i][e] = t;
                s++;
                e--;
            }
        }
    }
}