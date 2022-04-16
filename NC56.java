import java.util.*;

//NC56 回文数字
public class Solution {
    public boolean isPalindrome (int x) {
        String s = x + "";
        int left = 0, right = s.length() - 1;
        while(left <= right){
            if(s.charAt(left++) != s.charAt(right--))
                return false;
        }
        return true;
    }
}