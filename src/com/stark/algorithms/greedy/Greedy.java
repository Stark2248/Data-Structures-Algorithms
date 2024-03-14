package com.stark.algorithms.greedy;


import java.util.Comparator;
import java.util.PriorityQueue;

public class Greedy {

    class MyComparator implements Comparator<HuffmanNode> {
        public int compare(HuffmanNode x, HuffmanNode y) {
            return x.val - y.val;
        }
    }

    public static void printCode(HuffmanNode root, String s) {
        if (root.left == null && root.right == null && Character.isLetter(root.c)) {
            System.out.println(root.c + ":" + s);
            return;
        }
        printCode(root.left, s + "0");
        printCode(root.right, s + "1");
    }


    public void huffmanCodingAlogorithm(char charArray[],int[] charFreq,int n){
        PriorityQueue<HuffmanNode> queue = new PriorityQueue<>(n, new MyComparator());
        for (int i = 0; i < n; i++) {
            HuffmanNode hn = new HuffmanNode();
            hn.c = charArray[i];
            hn.val = charFreq[i];
            hn.left = null;
            hn.right = null;
            queue.add(hn);
        }
        HuffmanNode root = null;

        while (queue.size() > 1) {
            HuffmanNode x = queue.peek();
            queue.poll();
            HuffmanNode y = queue.peek();
            queue.poll();
            HuffmanNode f = new HuffmanNode();
            f.val = x.val + y.val;
            f.c = '-';
            f.left = x;
            f.right = y;
            root = f;
            queue.add(f);
        }
        System.out.println("Huffman Codes are : ");
        printCode(root, "");

    }

}
