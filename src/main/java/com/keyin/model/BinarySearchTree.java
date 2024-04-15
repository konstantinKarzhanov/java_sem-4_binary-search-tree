package com.keyin.model;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class BinarySearchTree {
    private TreeNode treeNode;

    private TreeNode insertNumberRecursive(TreeNode treeNode, int number) {
        if (treeNode == null) {
            treeNode = new TreeNode(number);

            return treeNode;
        }

        if (number < treeNode.number) {
            treeNode.treeNodeLeft = this.insertNumberRecursive(treeNode.treeNodeLeft, number);
        } else if (number > treeNode.number) {
            treeNode.treeNodeRight = this.insertNumberRecursive(treeNode.treeNodeRight, number);
        }

        return treeNode;
    }

    public void insertNumbers(List<Integer> numberList) {
        for (Integer number : numberList) {
            this.treeNode = this.insertNumberRecursive(this.treeNode, number);
        }
    }

    public List<Integer> createListOfNumbersFromString(String numberStr) {
        return Arrays.stream(numberStr.split(","))
                .map(Integer::parseInt)
                .toList();
    }

    private boolean isNumberExistRecursive(TreeNode treeNode, int number) {
        if (treeNode == null) {
            return false;
        } else if (treeNode.number == number) {
            return true;
        } else if (number < treeNode.number) {
            return isNumberExistRecursive(treeNode.treeNodeLeft, number);
        } else {
            return isNumberExistRecursive(treeNode.treeNodeRight, number);
        }
    }

    public boolean isNumberExist(int number) {
        return this.isNumberExistRecursive(this.treeNode, number);
    }

    @Override
    public String toString() {
        return
                "{" +
                    "\"root\": " +
                        "{" +
                            "\"value\": " + "\"" +treeNode.number + "\"" + "," +
                            "\"left\": " + this.treeNode.treeNodeLeft + "," +
                            "\"right\": " + this.treeNode.treeNodeRight +
                        "}" +
                "}";
    }
}
