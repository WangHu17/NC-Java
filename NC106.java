import java.util.*;

// NC106 三个数的最大乘积
public class Solution {
    public long solve (int[] A) {
        int max1 = -10001, max2 = -10001, max3 = -10001, min1 = 10001, min2 = 10001, t;
        for(int n:A){
            if(n > max1){
                max3 = max2;
                max2 = max1;
                max1 = n;
            }else if(n > max2){
                max3 = max2;
                max2 = n;
            }else if(n > max3){
                max3 = n;
            }
            if(n < min1){
                min2 = min1;
                min1 = n;
            }else if(n < min2){
                min2 = n;
            }
        }
        return Math.max((long)min1*min2*max1,(long)max1*max2*max3);
    }
}