package com.stark.datastructures.tree;

import java.util.*;

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


    public int maxBinaryTreeIterative(TreeNode root){
        TreeNode temp;
        int max=Integer.MIN_VALUE;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            temp = queue.poll();
            if(max < temp.getVal()){
                max = temp.getVal();
            }
            if(temp.left != null){
                queue.offer(temp.left);
            }
            if(temp.right != null){
                queue.offer(temp.right);
            }
        }
        queue.poll();
        return max;
    }


    public int findInBinaryTreeRecursive(TreeNode root, int val){
        int temp;
        if(root == null){
            return 0;
        }else{
            if(val == root.getVal()){
                return 1;
            }
            else{
                temp = findInBinaryTreeRecursive(root.left,val);
                if(temp != 0)
                    return temp;
                else
                    return findInBinaryTreeRecursive(root.right,val);
            }
        }
    }

    public int findInBinaryTreeIterative(TreeNode root, int val){
        TreeNode treeNode;
        Queue<TreeNode> queue =new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            treeNode = queue.poll();
            if(val == treeNode.getVal())
                return 1;
            if(treeNode.left!=null){
                queue.offer(treeNode.left);
            }
            if(treeNode.right!=null){
                queue.offer(treeNode.right);
            }
        }
        return 0;
    }

    public void insertInBinary(TreeNode root, int val){
        TreeNode temp;
        TreeNode newNode;
        newNode =new TreeNode(val);
        newNode.right = newNode.left = null;
        if(root == null){
            root = newNode;
            return;
        }
        Queue<TreeNode> queue =new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            temp = queue.poll();
            if(temp.left != null){
                queue.offer(temp.left);
            }else{
                temp.left = newNode;
                return;
            }
            if(temp.right != null){
                queue.offer(temp.right);
            }else{
                temp.right = newNode;
                return;
            }
        }
    }

    public int sizeOfBinaryTree(TreeNode root){
        if(root == null)
            return 0;
        else
            return sizeOfBinaryTree(root.left) + 1 + sizeOfBinaryTree(root.right);
    }

    public int sizeOfBinaryTreeIterative(TreeNode root){
        int count = 0;
        if(root == null){
            return count;
        }
        TreeNode temp;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            temp = queue.poll();
            count++;
            if(temp.left != null){
                queue.offer(temp.left);
            }
            if(temp.right != null){
                queue.offer(temp.right);
            }
        }
        return count;
    }

    public void levelorderreversetraversal(TreeNode root){
        TreeNode temp;
        Queue<TreeNode> queue = new ArrayDeque<>();
        Stack<TreeNode> stack = new Stack<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            temp = queue.poll();
            if(temp.left != null){
                queue.offer(temp.left);
            }
            if(temp.right != null){
                queue.offer(temp.right);
            }
            stack.push(temp);
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop().getVal()+" ");
        }
    }


    public int heightOfBinafryTreeRecursive(TreeNode root){
        int leftHeight, rightHeight;
        if(root == null){
            return 0;
        }else{
            leftHeight = heightOfBinafryTreeRecursive(root.left);
            rightHeight = heightOfBinafryTreeRecursive(root.right);
            if(leftHeight > rightHeight)
                return leftHeight + 1;
            else
                return rightHeight + 1;
        }
    }

    public int heightOfBinaryTreeIterative(TreeNode root){
        if(root == null){
            return 0;
        }
        int level = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(true){
            int nodecount = queue.size();
            if(nodecount == 0){
                return level;
            }
            level++;
            while(nodecount > 0){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
                nodecount --;
            }
        }
    }

    public int numberOfleaves(TreeNode root){
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;
        int count = 0;
        TreeNode temp;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            temp = queue.poll();
            if(temp.left == null && temp.right == null){
                count++;
            }
            if(temp.left != null){
                queue.offer(temp.left);
            }
            if(temp.right != null){
                queue.offer(temp.right);
            }
        }
        return count;
    }

    public int findlevelwithmaxsum(TreeNode root){
        if(root == null)
            return 0;
        TreeNode temp;
        Queue<TreeNode> queue = new ArrayDeque<>();
        int level = 0, maxLevel = 0, currentSum = 0, maxSum = 0;
        queue.offer(root);
        TreeNode node =new TreeNode(0);
        node.right = node.left = null;
        queue.offer(node);
        while(!queue.isEmpty()){
            temp = queue.poll();
            if(temp == node){
                if(currentSum > maxSum){
                    maxSum = currentSum;
                    maxLevel = level;
                }
                currentSum = 0;
                if(!queue.isEmpty()){
                    queue.offer(node);
                }
                level++;
            }else{
                currentSum += temp.getVal();
                if(temp.left != null){
                    queue.offer(temp.left);
                }
                if(temp.right != null){
                    queue.offer(temp.right);
                }
            }
        }
        return maxLevel;
    }



}
