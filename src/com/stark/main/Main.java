package com.stark.main;

import com.stark.algorithms.greedy.Greedy;
import com.stark.algorithms.sorting.Sorting;
import com.stark.datastructures.tree.BinaryTree;
import com.stark.datastructures.tree.TreeNode;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {



    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
//        int[] nums = new int[]{10, 5, 15, 3, 2, 4, 7, 8, 6, 12, 11, 13, 18, 19, 17};
////        Sorting sort = new Sorting();
//
//
////        sort.quickSort(nums,0,nums.length-1);
////        for(int i: nums){
////            System.out.print(i+ " ");
////        }
//        TreeNode root=null;
//        BinaryTree myTree =new BinaryTree();
//        for(int val: nums){
//            root = myTree.add(root,val,"rec");
//        }
//
//        System.out.println("*********InOrderRecursive********");
//        myTree.traversal(root,"InOrder","rec");
//        System.out.println();
//        System.out.println("*********InOrderIterative********");
//        myTree.traversal(root,"InOrder","iter");
//        System.out.println();
//        System.out.println("*********PreOrderRecursive********");
//        myTree.traversal(root,"PreOrder","rec");
//        System.out.println();
//        System.out.println("*********PreOrderIterative********");
//        myTree.traversal(root,"PreOrder","iter");
//        System.out.println();
//        System.out.println("*********PostOrderRecursive********");
//        myTree.traversal(root,"PostOrder","rec");
//        System.out.println();
//        System.out.println("*********PostOrderIterative********");
//        myTree.traversal(root,"PostOrder","iter");
//        System.out.println();
//
//        System.out.println();
//
//        System.out.println(myTree.maxBinaryTreeIterative(root));
//
//        System.out.println();
//
//        System.out.println(myTree.findInBinaryTreeIterative(root,20));
//
//        System.out.println();
//
//        System.out.println(myTree.sizeOfBinaryTree(root));
//
//        System.out.println();
//
//        System.out.println(myTree.sizeOfBinaryTreeIterative(root));
//
//        System.out.println("******** level order reverse traversal ");
//
//        myTree.levelorderreversetraversal(root);
//
//        System.out.println();
//
//        System.out.println(myTree.heightOfBinafryTreeRecursive(root));
//
//        System.out.println();
//
//        System.out.println(myTree.heightOfBinaryTreeIterative(root));
//
//
//        System.out.println();
//
//        System.out.println(myTree.findlevelwithmaxsum(root));

        int n = 6;
        char[] charArray = {'a', 'b', 'c', 'd', 'e', 'f'};
        int[] charFreq = {5, 9, 12, 13, 16, 45};

        Greedy greedy = new Greedy();
        greedy.huffmanCodingAlogorithm(charArray,charFreq,n);




    }
}