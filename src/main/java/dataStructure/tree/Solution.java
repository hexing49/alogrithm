package dataStructure.tree;


import java.util.ArrayList;
import java.util.List;

class TreeNode {
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


public class Solution {
    // 二叉树前序遍历
    // https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root, res);
        return res;
    }

    private void preOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preOrder(root.left, res);
        preOrder(root.right, res);
    }

    // 二叉树中序遍历
    //https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inOrder(root, res);
        return res;
    }

    private void inOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inOrder(root.left, res);
        res.add(root.val);
        inOrder(root.right, res);
    }

    // 二叉树后序遍历
    // https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postOrder(root, res);
        return res;
    }

    private void postOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        postOrder(root.left, res);
        postOrder(root.right, res);
        res.add(root.val);
    }

    //https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
    // 二叉树的层序遍历
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dns(root, 0, res);
        return res;
    }

    private void dns(TreeNode node, int level, List<List<Integer>> res) {
        if (node == null) {
            return;
        }
        // 如果集合大小和层数相等，说明是第一次进入了下一层
        if (res.size() == level) {
            res.add(new ArrayList<Integer>());
        }
        res.get(level).add(node.val);
        dns(node.left, level + 1, res);
        dns(node.right, level + 1, res);
    }

    //https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
    // 二叉树的最大深度
    public int maxDepth(TreeNode root) {
        int res = 0;
        int search = search(root, res);
        return search;
    }

    private int search(TreeNode root, int res) {
        if (root == null) {
            return res;
        }
        int max = Math.max(search(root.left, res), search(root.right, res)) + 1;
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        treeNode1.left = treeNode2;
        int i = solution.maxDepth(treeNode1);
        System.out.println(i);

    }
}
