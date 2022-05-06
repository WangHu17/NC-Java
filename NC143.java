import java.util.*;

// NC143 矩阵乘法
public class Solution {
    
    //方法： 行 x 列
    public int[][] solve (int[][] a, int[][] b) {
        int row = a.length, col = a[0].length;
        int[][] res = new int[row][col];
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                for(int k=0; k<col; k++){
                    res[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return res;
    }
    
}