class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        
        int startRow = 0;
        int endRow = n-1;
        int startCol = 0;
        int endCol = m-1;
        while(startRow <= endRow && startCol <= endCol){

            // first row 
            for(int i=startCol ; i<=endCol; i++){
                result.add(matrix[startRow][i]);
            }
            startRow += 1;
            
            // last col
            for(int i=startRow ; i<=endRow; i++){
                result.add(matrix[i][endCol]);
            }
            endCol -= 1;

            if(startRow <= endRow){
                // last row
                for(int i=endCol; i>=startCol; i--){
                    result.add(matrix[endRow][i]);
                }
                endRow -= 1;
            }

            if(startCol <= endCol){
                // first col
                for(int i=endRow; i>=startRow; i--){
                    result.add(matrix[i][startCol]);
                }
                startCol += 1;
            }
        }

        return result;
    }
}