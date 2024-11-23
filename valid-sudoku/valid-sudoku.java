class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                char num = board[i][j];
                if(num != '.'){
                    if(!seen.add(num + " in row " + i) ||
                       !seen.add(num + " in col " + j) ||
                       !seen.add(num + " in block " + i/3 + "-" + j/3)
                    ) return false;
                }
            }
        }
        return true;
    }
}