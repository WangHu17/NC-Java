import java.util.*;

/*
 * public class TreeNode {
 *   int val = 0;
 *   TreeNode left = null;
 *   TreeNode right = null;
 * }
 */
//NC11 将升序数组转化为平衡二叉搜索树
public class Solution {

    public TreeNode sortedArrayToBST (int[] num) {
        if(num.length == 0)return null;
        return build(num, 0, num.length-1);
    }
    
    public TreeNode build(int[] num, int left, int right){
        if(left > right)return null;
        int mid = (left + right)/2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = build(num, left, mid-1);
        node.right = build(num, mid+1, right);
        return node;
    }
}