import java.util.*;

/*
 * public class TreeNode {
 *   int val = 0;
 *   TreeNode left = null;
 *   TreeNode right = null;
 * }
 */
// NC98 判断t1树中是否有与t2树完全相同的子树
public class Solution {
    public boolean isContains (TreeNode root1, TreeNode root2) {
        if(root1 == null || root2 == null)return false;
        if(dfs(root1, root2))return true;
        return isContains(root1.left, root2) || isContains(root1.right, root2);
    }
    public boolean dfs(TreeNode node1, TreeNode node2){
        if(node1 == null && node2 == null)return true;
        if(node1 == null || node2 == null || node1.val != node2.val)return false;
        return dfs(node1.left, node2.left) && dfs(node1.right, node2.right);
    }
}