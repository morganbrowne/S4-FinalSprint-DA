package com.keyin.service;

import com.keyin.model.TreeNode;

public class BinarySearchTree {
    private TreeNode root;

    public void insert(int value) {
        root = insert(root, value);

    }

    private TreeNode insert(TreeNode node, int value) {
        if (node == null) return new TreeNode(value);
        if (value < node.getValue()) {
            node.setLeft(insert(node.getLeft(), value));
        } else {
            node.setRight(insert(node.getRight(), value));
        }
        return node;
    }


    public TreeNode getRoot() {
        return root;
    }
}