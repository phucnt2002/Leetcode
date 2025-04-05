package leetcode.tree;

public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));

    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int[] res = new int[1];
        dfs(root, res);
        return res[0];
    }

    private int dfs(TreeNode root, int[] res) {
        if (root == null) return 0;
        int left = dfs(root.left, res);
        int right = dfs(root.right, res);

        res[0] = Math.max(res[0] + 1, left + right);
        return Math.max(left, right);
    }

//    public boolean isBalanced(TreeNode root) {
//        if(root==null)
//            return true;
//        check(root);
//    }
//
//    public boolean check(TreeNode root){
//
//    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

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
}
