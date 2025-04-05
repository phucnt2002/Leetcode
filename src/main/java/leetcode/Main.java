package leetcode;

import java.util.*;

public class Main {
    public static class TreeNode {
        int val; // Value of the node
        TreeNode left; // Pointer to the left child
        TreeNode right; // Pointer to the right child

        // Constructor
        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> nodes = new ArrayList<>();

            // Collect nodes at the current level
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                nodes.add(node);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            // Reverse values at odd levels
            if (level % 2 == 1) {
                int left = 0, right = nodes.size() - 1;
                while (left < right) {
                    int temp = nodes.get(left).val;
                    nodes.get(left).val = nodes.get(right).val;
                    nodes.get(right).val = temp;
                    left++;
                    right--;
                }
            }

            level++;
        }

        return root;
    }


    public static void main(String[] arg) {
        int[] array = new int[]{10, 1, 1, 6};
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(13);
        root.right.left = new TreeNode(21);
        root.right.right = new TreeNode(34);

        TreeNode newRoot = reverseOddLevels(root);
    }
}
