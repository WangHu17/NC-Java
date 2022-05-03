import java.util.*;

// NC10 大数乘法
public class Solution {
    
    public String solve (String s, String t) {
        if(s.equals("0") || t.equals("0"))return "0";
        int len1 = s.length(), len2 = t.length();
        char[] res = new char[len1 + len2];
        Arrays.fill(res, '0');
        for(int i=len1-1; i>=0; i--){
            for(int j=len2-1; j>=0; j--){
                int temp = (s.charAt(i) - '0')*(t.charAt(j) - '0') + (res[i+j+1] - '0');
                res[i+j+1] = (char)(temp%10 + 48);
                res[i+j] = (char)(temp/10 + 48 + (res[i+j] - '0'));
            }
        }
        String res1 = String.valueOf(res);
        for(int i=0; i<res1.length(); i++){
            if(res1.charAt(i) != '0'){
                res1 = res1.substring(i);
                break;
            }
        }
        return res1;
    }
    
}