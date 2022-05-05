import java.util.*;

// NC245 杨辉三角(一)
public class Solution {
    /*
        1
        1 1
        1 2 1
        1 3 3 1
    */
    public int[][] generate (int num) {
        int[][] res = new int[num][];
        for(int i=0; i<num; i++){
            res[i] = new int[i+1];
            res[i][0] = 1;
            res[i][i] = 1;
        }
        for(int i=2; i<num; i++){
            for(int j=1; j<i; j++){
                res[i][j] = res[i-1][j-1] + res[i-1][j];
            }
        }
        return res;
    }
    
}