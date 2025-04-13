package model;

public class TreeNode {
    private int value;
    private model.TreeNode left;
    private model.TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }

    // Getters and setters
    public int getValue() {
        return value;
    }

    public model.TreeNode getLeft() {
        return left;
    }

    public model.TreeNode getRight() {
        return right;
    }

    public void setLeft(model.TreeNode left) {
        this.left = left;
    }

    public void setRight(model.TreeNode right) {
        this.right = right;
    }
}