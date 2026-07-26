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
    int idx = 0;

    public void recoverTree(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        buildInorder(root, inorder);
        sortInorder(inorder);
        correctTree(root, inorder);
    }

    private void correctTree(TreeNode root, List<Integer> inorder) {
        if (root == null) return;
        correctTree(root.left, inorder);
        root.val = inorder.get(idx++);
        correctTree(root.right, inorder);
    }

    private void sortInorder(List<Integer> inorder) {
        if (inorder.size() <= 1) return;

        int fast = 1, slow = 0;

        while (fast < inorder.size()) {
            if (slow >= 0 && inorder.get(slow) > inorder.get(fast)) {
                swap(inorder, slow, fast);
                fast--;
                slow--;
            } else {
                slow++;
                fast++;
            }
        }
    }

    private void swap(List<Integer> inorder, int i, int j) {
        int temp = inorder.get(i);
        inorder.set(i, inorder.get(j));
        inorder.set(j, temp);
    }

    private void buildInorder(TreeNode root, List<Integer> inorder) {
        if (root == null) return;
        buildInorder(root.left, inorder);
        inorder.add(root.val);
        buildInorder(root.right, inorder);
    }
}