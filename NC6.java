import java.util.*;

// NC6 二叉树中的最大路径和(从该树的任意节点出发，经过父=>子或者子=>父的连接，达到任意节点的序列。不能重复)
public class Solution {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum (TreeNode root) {
        maxVal(root);
        return maxSum;
    }
    public int maxVal(TreeNode root){
        if(root == null)return 0;
        int leftVal = Math.max(maxVal(root.left),0);
        int rightVal = Math.max(maxVal(root.right),0);
        int sumVal = root.val + leftVal + rightVal;
        maxSum = Math.max(maxSum, sumVal);
        return root.val + Math.max(leftVal, rightVal);
    }
}