package com.longluo.top100;

import com.longluo.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem101_symmetricTree {

    // BFS time: O(n) space: O(n)
    public static boolean isSymmetric_bfs(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null && node.right != null) {
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
            if (!checkSymmetric(list)) {
                return false;
            }
        }

        return true;
    }

    public static boolean checkSymmetric(List<Integer> list) {
        if (list == null || list.size() <= 1) {
            return true;
        }

        int len = list.size();
        for (int i = 0; i < len / 2; i++) {
            if (list.get(i) != list.get(len - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    // Recursion time: O(n) space: O(n)
    public static boolean isSymmetric_rec(TreeNode root) {
        if (root == null) {
            return true;
        }

        return checkSymmetric(root.left, root.right);
    }

    public static boolean checkSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if ((left != null && right == null) || (left == null && right != null)) {
            return false;
        }

        if (left.val != right.val) {
            return false;
        }

        return checkSymmetric(left.left, right.right) && checkSymmetric(left.right, right.left);
    }

    public static void main(String[] args) {

    }
}
