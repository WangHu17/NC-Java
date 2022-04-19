import java.util.*;

//NC112 进制转换
public class Solution {
    public String solve (int M, int N) {
        StringBuilder res = new StringBuilder();
        int flag = 1;
        if(M < 0){
            flag = -1;
            M = -M;
        }
        while(M != 0){
            int n = M % N;
            if(n > 9){
                if(n == 10)
                    res.append("A");
                else if(n == 11)
                    res.append("B");
                else if(n == 12)
                    res.append("C");
                else if(n == 13)
                    res.append("D");
                else if(n == 14)
                    res.append("E");
                else if(n == 15)
                    res.append("F");
            }else
                res.append(n);
            M /= N;
        }
        if(flag == -1)res.append("-");
        return res.reverse().toString();
    }
}