package com.stark.datastructures.tree;

import java.util.Deque;
import java.util.Stack;

public class BinaryTree {
    private TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    public TreeNode add(TreeNode root, int val, String method){
        if(method.equals("rec")){
            return recursiveAdd(root,val);
        }else{
            return iterativeAdd(root,val);
        }

    }

    private TreeNode recursiveAdd(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }
        if(val > root.getVal()){
            root.right = recursiveAdd(root.right,val);
        } else{
           root.left = recursiveAdd(root.left,val);
        }
        return root;
    }

    private TreeNode iterativeAdd(TreeNode root, int val){
        TreeNode current = root;
        if(current == null){
            return new TreeNode(val);
        }
        while(true){
            if(current.getVal()>val){
                if(current.left != null){
                    current = current.left;
                }else{
                    current.left = new TreeNode(val);
                    return root;
                }
            }else if(current.getVal()<val){
                if(current.right != null){
                    current = current.right;
                }else{
                    current.right = new TreeNode(val);
                    return root;
                }
            }else{
                return root;
            }
        }
    }

    public void traversal(TreeNode root, String type, String method){
        if(type.equals("InOrder")){
            if(method.equals("rec")){
                recursiveInOrder(root);
            }else{
                iterativeInOrder(root);
            }
        } else if (type.equals("PreOrder")) {
            if (method.equals("rec")){
                recursivePreOrder(root);
            }else {
                iterativePreOrder(root);
            }
        } else if (type.equals("PostOrder")) {
            if (method.equals("rec")){
                recursivePostOrder(root);
            }else {
                iterativePostOrder(root);
            }

        }
    }

    private void iterativePostOrder(TreeNode root) {
        Stack<TreeNode> stack1 =new Stack<>();
        Stack<TreeNode> stack2 =new Stack<>();

        stack1.push(root);

        while(!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            stack2.push(node);
            if(node.left != null){
                stack1.push(node.left);
            }
            if (node.right != null){
                stack1.push(node.right);
            }
        }
        while(!stack2.isEmpty()){
            TreeNode node = stack2.pop();
            System.out.print(node.getVal()+ " ");
        }
    }

    private void recursivePostOrder(TreeNode root) {
        if(root != null){
            recursivePostOrder(root.left);
            recursivePostOrder(root.right);
            System.out.print(root.getVal()+" ");
        }
    }

    private void iterativePreOrder(TreeNode root) {
        Stack<TreeNode> stack =new Stack<>();
        while(true) {
            while (root != null) {
                System.out.print(root.getVal()+" ");
                stack.push(root);
                root = root.left;
            }
            if (stack.isEmpty()){
                break;
            }
            root = stack.pop();
            root = root.right;
        }
    }

    private void recursivePreOrder(TreeNode root) {
        if(root != null){
            System.out.print(root.getVal()+" ");
            recursivePreOrder(root.left);
            recursivePreOrder(root.right);
        }
    }

    private void iterativeInOrder(TreeNode root) {
        Stack<TreeNode> stack =new Stack<>();
        while(true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (stack.isEmpty()){
                break;
            }
            root = stack.pop();
            System.out.print(root.getVal()+" ");
            root = root.right;
        }
    }

    private void recursiveInOrder(TreeNode root) {
        if(root != null){
            recursiveInOrder(root.left);
            System.out.print(root.getVal()+" ");
            recursiveInOrder(root.right);
        }
    }


    public int maxBinaryTree(TreeNode root){
        int left,right,rootVal,max=Integer.MIN_VALUE;
        if(root != null){
            rootVal = root.getVal();
            left = maxBinaryTree(root.left);
            right = maxBinaryTree(root.right);
            if(left > right){
                max = left;
            }else{
                max = right;
            }
            if(rootVal > max){
                max = rootVal;
            }
        }
        return max;
    }

}
