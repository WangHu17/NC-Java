import java.util.*;

//NC57 反转数字
public class Solution {
    public int reverse (int x) {
        int flag = 1;
        if(x < 0){
            flag = -1;
            x*=-1;
        }
        StringBuilder s = new StringBuilder(x+"");
        String res = s.reverse().toString();
        try{
            x = Integer.parseInt(res);
        }catch(Exception e){
            x = 0;
        }
        return flag * x;
    }
}