package leetcode.tree;

import java.util.*;

public class AverageLevelsBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> listAverage = new ArrayList<>();

        if (root == null)
            return listAverage;
        queue.add(root);
        while (!queue.isEmpty()) {
            long size = queue.size();
            long levelSize = queue.size();
            long sum = 0;
            while (size > 0) {
                TreeNode currentNode = queue.poll();
                sum += currentNode.val;
                size--;
                if (currentNode.left != null) queue.add(currentNode.left);
                if (currentNode.right != null) queue.add(currentNode.right);
            }

//            int sum = listNodeCurrent.stream().mapToInt(Integer::intValue).sum();

            Double average = (double) sum / levelSize;
            listAverage.add(average);


        }
        return listAverage;


    }

    public static void main(String[] args) {

    }


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
