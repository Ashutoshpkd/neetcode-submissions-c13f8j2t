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

public class Codec {

    int idx = 0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder enc = new StringBuilder();
        encode(root, enc);
        return enc.toString();
    }

    private void encode(TreeNode root, StringBuilder enc) {
        if (root == null) {
            enc.append("N").append(",");
            return;
        }
        enc.append(root.val).append(",");
        encode(root.left, enc);
        encode(root.right, enc);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataArr = data.split(",");
        return decode(dataArr);
    }

    private TreeNode decode(String[] data) {
        if (data[idx].equals("N")) {
            idx++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(data[idx++]));
        root.left = decode(data);
        root.right = decode(data);

        return root;
    }
}
