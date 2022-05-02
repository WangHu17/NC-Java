import java.util.*;

//NC230 Nim游戏
/*你和你的朋友，两个人玩一个游戏。
1.桌子上有 n 个石头
2.你和你的朋友轮流取石头，你先手。
3.每一回合可以取 1~3 个石头。
4.轮到你的朋友时桌上没有石头则你获胜，否则你的朋友获胜。
你和你的朋友都尽力让自己获胜，如果你有方法必胜，则返回 true ，如果你的朋友有方法必胜，则返回 false
*/
public class Solution {
    
    // 方法：数学
    public boolean NimGame (int n) {
        return n%4!=0;
    }
    
    // 方法二：动态规划(堆溢出)
    public boolean NimGame2 (int n) {
        if(n<=3)return true;
        boolean[] dp = new boolean[n+1];
        dp[1] = dp[2] = dp[3] = true;
        for(int i=4; i<=n; i++){
            for(int j=1; j<=3; j++){
                if(!dp[i-j])dp[i]=true;
            }
        }
        return dp[n];
    }
    
    // 方法一：递归(超时)
    public boolean NimGame1 (int n) {
        if(n <= 3)return true;
        for(int i=1; i<=3; i++){
            if(!NimGame(n-i))return true;
        }
        return false;
    }
    
}