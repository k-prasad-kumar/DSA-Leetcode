class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> ans = new ArrayList<>();

        int row = matrix.length;
        int col = matrix[0].length;

        int startRow = 0;
        int startCol = 0;
        int endRow = row-1;
        int endCol = col-1;

        int count = 0;
        int total = row * col;

        while(count < total){
            // adding start row
            for(int i=startCol; i<=endCol && count < total; i++){
                ans.add(matrix[startRow][i]);
                count++;
            }
            startRow++;

            // adding end col
            for(int i=startRow; i<=endRow && count < total; i++){
                ans.add(matrix[i][endCol]);
                count++;
            }
            endCol--;

             // adding end row reverse
            for(int i=endCol; i>=startCol && count < total; i--){
                ans.add(matrix[endRow][i]);
                count++;
            }
            endRow--;

             // adding start col
            for(int i=endRow; i>=startRow && count < total; i--){
                ans.add(matrix[i][startCol]);
                count++;
            }
            startCol++;
        }

        return ans;
    }
}