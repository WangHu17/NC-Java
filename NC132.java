import java.util.*;

// NC132 环形链表的约瑟夫问题
public class Solution {
    
    public int ysf (int n, int m) {
        int[] a = new int[n];
        int i=0, k=0, len=n;
        while(n>1){
            if(a[i] != -1){
                k++;
                if(k==m){
                    a[i]=-1;
                    n--;
                    k=0;
                }
            }
            i++;
            if(i==len)i=0;
        }
        for(int j=0; j<len; j++){
            if(a[j] != -1)return j+1;
        }
        return 0;
    }
    
}