import java.util.*;

// NC108 最大正方形
// 给定一个由'0'和'1'组成的2维矩阵，返回该矩阵中最大的由'1'组成的正方形的面积，输入的矩阵是字符形式而非数字形式。
public class Solution {
    
    public int solve (char[][] matrix) {
        int row = matrix.length;
        if(row == 0 || matrix[0].length == 0)return 0;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        for(int i=0; i<col; i++){
            dp[0][i] = matrix[0][i] - '0';
        }
        for(int i=0; i<row; i++){
            dp[i][0] = matrix[i][0] - '0';
        }
        int max = 0;
        for(int i=1; i<row; i++){
            for(int j=1; j<col; j++){
                if(matrix[i][j] == '1'){
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                    max = Math.max(max,dp[i][j]);
                }
            }
        }
        return max*max;
    }
    
}