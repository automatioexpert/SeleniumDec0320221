/*
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note:
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Example 1:

Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1
Example 2:

Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3
*/



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> op;
    public int kthSmallest(TreeNode root, int k) {
        op = new ArrayList();
        inorderTranversal(root);
        return op.get(k - 1);
    }
    
    public void inorderTranversal(TreeNode root){
        if(root.left != null){
            inorderTranversal(root.left);
        }
        if(root != null){
            op.add(root.val);
        }
            
        if(root.right != null){
            inorderTranversal(root.right);
        }
    }
}
