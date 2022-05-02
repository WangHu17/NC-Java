import java.util.*;

// NC195 二叉树的直径(树上任意两个节点路径长度的最大值)
public class Solution {
    
    public int diameterOfBinaryTree (TreeNode root) {
        if(root==null)return 0;
        int rootDiameter = getHeight(root.left) + getHeight(root.right);
        int leftDiameter = getHeight(root.left);
        int rightDiameter = getHeight(root.right);
        int res = Math.max(rootDiameter,leftDiameter);
        return Math.max(res, rightDiameter);
    }
    // 获取以当前节点为根的树的高度
    public int getHeight(TreeNode root){
        if(root==null)return 0;
        int l = getHeight(root.left);
        int r = getHeight(root.right);
        return Math.max(l,r) + 1;
    }
    
}