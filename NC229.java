import java.util.*;

// NC229 判断字符是否唯一
public class Solution {
    
    public boolean isUnique (String str) {
        Set<Character> set = new HashSet<>();
        for(char c:str.toCharArray()){
            if(!set.add(c))return false;
        }
        return true;
    }
    
}