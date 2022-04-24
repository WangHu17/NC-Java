import java.util.*;

// NC231 只出现一次的数字 (数组中有一个数出现了一次，其他数出现了两次，请找出只出现了一次的数。)
public class Solution {
    
    // 方法一：异或
    public int singleNumber (int[] nums) {
        int res = 0;        
        for(int n:nums){
            res ^= n;
        }
        return res;
    }
    
    // 方法二：set
    public int singleNumber1 (int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int n:nums){
            if(!set.add(n))set.remove(n);
        }
        for(int n:set)
            return n;
        return 0;
    }
}