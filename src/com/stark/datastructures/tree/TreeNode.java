package com.stark.datastructures.tree;

public class TreeNode {
    private int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(){}
    TreeNode(int val){
        this.val = val;
    }

    public int getVal() {
        return val;
    }
}
