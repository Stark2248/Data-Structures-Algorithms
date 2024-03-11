package com.stark.main;

import com.stark.algorithms.sorting.Sorting;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        int[] nums = new int[]{3,4,1,9,5,4,1,2};
        int[] temp = new int[10];
        Sorting sort = new Sorting();
        sort.quickSort(nums,0,nums.length-1);
        for(int i: nums){
            System.out.print(i+ " ");
        }
    }
}