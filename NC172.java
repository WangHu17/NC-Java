import java.util.*;

// NC172 二进制取反
/*有一个二进制字符串num，可以选择该串中的任意一段区间进行取反(可以进行一次或不进行)，
取反指将0变为1，将1变为0。那么取反之后的num可能的最大的字典序是多少呢。
如有num=1000，将区间[num2,...,num4]取反变为1111是字典序最大的
 */
public class Solution {
    
    public String maxLexicographical (String num) {
        StringBuilder res = new StringBuilder();
        int flag0 = 1, flag1 = 0;
        for(Character c:num.toCharArray()){
            if(flag0 == 1 && c == '0'){
                res.append('1');
                flag1 = 1;
            }else{
                if(flag1 == 1)flag0 = 0;
                res.append(c);
            }
        }
        return res.toString();
    }
    
}