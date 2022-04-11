import java.util.*;

//NC151 最大公约数
public class Solution {

    public int gcd (int a, int b) {
        return b==0?a:gcd(b,a%b);
    }
}