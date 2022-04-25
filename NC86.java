import java.util.*;
//NC86 矩阵元素查找
public class Solution {
    
    public int[] findElement(int[][] mat, int n, int m, int x) {
        int row = 0, col = m - 1;
        while(row < n && col >= 0){
            if(mat[row][col] == x){
                return new int[]{row, col};
            }else if(x < mat[row][col]){
                col--;
            }else
                row++;
        }
        return new int[]{};
    }
    
}