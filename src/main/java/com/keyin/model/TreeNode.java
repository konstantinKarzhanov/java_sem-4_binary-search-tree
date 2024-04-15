package com.keyin.model;

public class TreeNode {
    int number;

    TreeNode treeNodeLeft;
    TreeNode treeNodeRight;

    public TreeNode(int number) {
        this.number = number;
        this.treeNodeLeft = null;
        this.treeNodeRight = null;
    }

    @Override
    public String toString() {
        return
                "{" +
                        "\"value\": " + "\"" + this.number + "\"" + "," +
                        "\"left\": " + this.treeNodeLeft + "," +
                        "\"right\": " + this.treeNodeRight +
                "}";
    }
}