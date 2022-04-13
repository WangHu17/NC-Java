import java.util.*;

//NC149 kmp算法
public class Solution {

    public int kmp (String S, String T) {
        int[] next = next(S);
        int res = 0;
        for(int i=0, j=0; i<T.length(); i++){
            while(j>0 && T.charAt(i) != S.charAt(j))
                j = next[j-1];
            if(T.charAt(i) == S.charAt(j))
                j++;
            if(j == S.length()){
                res++;
                j = next[j-1];
            }
        }
        return res;
    }
    public int[] next(String s){
        int[] next = new int[s.length()];
        next[0] = 0;
        for(int i=1, j=0; i<s.length(); i++){
            while(j>0 && s.charAt(i) != s.charAt(j))
                j = next[j-1];
            if(s.charAt(i) == s.charAt(j))
                j++;
            next[i] = j;
        }
        return next;
    }
    
}