import java.util.*;

/*
 * public class TreeNode {
 *   int val = 0;
 *   TreeNode left = null;
 *   TreeNode right = null;
 * }
 */
//NC60 判断一棵二叉树是否为搜索二叉树和完全二叉树
public class Solution {
    public boolean[] judgeIt (TreeNode root) {
        boolean bst = isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        boolean isCT = isCompleteTree(root);
        return new boolean[]{bst, isCT};
    }
    public boolean isBST(TreeNode root, int l, int r){
        if(root == null)return true;
        if(root.val < l || root.val > r)return false;
        return isBST(root.left, l, root.val) && isBST(root.right, root.val, r);
    }
    public boolean isCompleteTree(TreeNode root){
        if(root == null)return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = false;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                TreeNode node = queue.poll();
                if(flag && node != null)return false;
                if(node == null){
                    flag = true;
                }else{
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
        }
        return true;
    }
}