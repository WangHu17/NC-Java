import java.util.*;

/*
 * public class TreeNode {
 *   int val = 0;
 *   TreeNode left = null;
 *   TreeNode right = null;
 * }
 */
//NC45 实现二叉树先序，中序和后序遍历
public class Solution {
    
    private ArrayList<Integer> list1 = new ArrayList<>();
    private ArrayList<Integer> list2 = new ArrayList<>();
    private ArrayList<Integer> list3 = new ArrayList<>();
    
    public int[][] threeOrders (TreeNode root) {
        preOrder(root);
        inOrder(root);
        postOrder(root);
        int[][] res = new int[3][list1.size()];
        res[0] = list1.stream().mapToInt(Integer::valueOf).toArray();
        res[1] = list2.stream().mapToInt(Integer::valueOf).toArray();
        res[2] = list3.stream().mapToInt(Integer::valueOf).toArray();
        return res;
    }
    
    public void preOrder(TreeNode root){
        if(root==null)return;
        list1.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
    public void inOrder(TreeNode root){
        if(root==null)return;
        inOrder(root.left);
        list2.add(root.val);
        inOrder(root.right);
    }
    public void postOrder(TreeNode root){
        if(root==null)return;
        postOrder(root.left);
        postOrder(root.right);
        list3.add(root.val);
    }
}