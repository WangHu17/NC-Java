import java.util.*;

//NC114 旋转字符串(给定两字符串A和B，如果能将A从中间某个位置分割为左右两部分字符串（可以为空串），并将左边的字符串移动到右边字符串后面组成新的字符串可以变为字符串B时返回true。

public class Solution {
    
    // A+A包含B则true
    public boolean solve (String A, String B) {
        if(A.length()!=B.length())return false;
        return (A+A).contains(B);
    }
    
    //我的方法
    public boolean solve1 (String A, String B) {
        int len1 = A.length()-1, len2 = B.length()-1, len3;
        if(len1 != len2)return false;
        if(A.equals(B))return true;
        for(int i=0; i<=len1; i++){
            len3 = len1-i;
            if(A.charAt(i) == B.charAt(0) && A.charAt(len1) == B.charAt(len3)){
                String s1 = A.substring(i);
                String s2 = B.substring(0,len3+1);
                String s3 = A.substring(0,i);
                String s4 = B.substring(len3+1,len1+1);
                if(s1.equals(s2) && s3.equals(s4))return true;
            }
        }
        return false;
    }
}