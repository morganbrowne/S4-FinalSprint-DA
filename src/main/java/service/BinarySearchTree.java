package service;

public class BinarySearchTree {
    private TreeNode root;

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private TreeNode insertRec(TreeNode node, int value) {
        if (node == null) return new TreeNode(value);
        if (value < node.value) node.left = insertRec(node.left, value);
        else node.right = insertRec(node.right, value);
        return node;
    }

    public TreeNode getRoot() {
        return root;
    }
}