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
    TreeNode first, midd, last, prev;

    public void recoverTree(TreeNode root) {
        prev = new TreeNode(Integer.MIN_VALUE);
        inorder(root);

        if (first != null && last != null) {
            swap(first, last);
        } else {
            swap(first, midd);
        }
    }

    private void swap(TreeNode n1, TreeNode n2) {
        if (n1 == null || n2 == null) return;

        int t = n1.val;
        n1.val = n2.val;
        n2.val = t;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);

        if (prev != null && root.val < prev.val) {

            if (first == null) {
                first = prev;
                midd = root;
            } else {
                last = root;
            }
        }

        prev = root;
        inorder(root.right);
    }
}