import java.util.*;

//NC5 二叉树根节点到叶子节点的所有路径和
public class Solution {
    
    // dfs
    public int sumNumbers (TreeNode root) {
        if(root == null) return 0;
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> valStack = new Stack<>();
        nodeStack.push(root);
        valStack.push(root.val);
        int res = 0;
        while(!nodeStack.isEmpty()){
            TreeNode node = nodeStack.pop();
            int val = valStack.pop();
            if(node.left == null && node.right == null){
                res += val;
            }else{
                if(node.right != null){
                    nodeStack.push(node.right);
                    valStack.push(val*10 + node.right.val);
                }
                if(node.left != null){
                    nodeStack.push(node.left);
                    valStack.push(val*10 + node.left.val);
                }
            }
        }
        return res;
    }
    
}