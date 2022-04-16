import java.util.*;

//NC32 求平方根
public class Solution {

    // 方法：二分
    public int sqrt (int x) {
        if(x == 1)return 1;
        int left = 1, right = x;
        while(left <= right){
            int mid = (left + right)/2;
            if(mid <= x/mid && (mid + 1) > x/(mid+1))
                return mid;
            else if(mid > x/mid)
                right = mid - 1;
            else 
                left = mid + 1;
        }
        return 0;
    }
    
}