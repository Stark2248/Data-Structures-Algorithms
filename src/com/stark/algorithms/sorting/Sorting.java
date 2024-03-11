package com.stark.algorithms.sorting;

public class Sorting {
    public void bubbleSort(int[] nums, int size){
        int temp;
        for(int i=0; i<size; i++){
            for(int j=0; j<size-i; j++){
                if(nums[j]>nums[j-1]){
                    temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }

    public void bubbleSortImprv(int nums[], int size){
        int temp;
        boolean swapped=true;
        for(int p=size-1 ; p>=0 && swapped ; p-- ){
            swapped =false;
            for(int j=0; j<=p-1; j++){
                if(nums[j]>nums[j+1]){
                    temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    swapped = true;
                }
            }
        }
    }

    public void selectionSort(int[] nums, int size){
        int min,temp;
        for(int i=0; i<size ; i++){
            min = i;
             for(int j=i+1; j<size ;j++){
                 if(nums[j]<nums[min]) {
                     min = j;
                 }
             }
             temp=nums[min];
             nums[min]=nums[i];
             nums[i]=temp;
        }
    }

    public void insertionSort(int[] nums, int size){
        int key;
        for(int i=0; i<size-1; i++){
            key = nums[i];
            int j = i;
            while(nums[j-1]>key && j>-1){
                nums[j]=nums[j-1];
                j--;
            }
            nums[j]=key;
        }
    }

    public void shellSort(int[] nums, int size){
        int i, j, h, v;
        for(i=size/2; i>0 ; i/=2){
            for(j=i; j<size; j+=1){
                v=nums[j];
                for(h=j;h>=i && nums[h-i]>v;h-=i){
                    nums[h]=nums[h-i];
                }
                nums[h]=v;
            }
        }
    }

    private void merge(int[] n, int l, int m, int r){
        int i, lend, tpos, size;
        int[] t = new int[n.length];
        lend= m-1;
        tpos= l;
        size = r - l + 1;
        while (l <= lend && m <= r) {
            if(n[l]<=n[m]){
                t[tpos]=n[l];
                tpos++;
                l++;
            }else{
                t[tpos]=n[m];
                tpos++;
                m++;
            }
        }
        while(l<=lend){
            t[tpos]=n[l];
            tpos++;
            l++;
        }
        while(m<=r){
            t[tpos]=n[m];
            m++;
            tpos++;
        }

        for(i=0;i<size;i++){
            n[r]=t[r];
            r--;
        }

    }

    public void mergeSort(int[] nums, int left, int right){
        int m;
        if(right>left){
            m=(right+left)/2;
            mergeSort(nums,left,m);
            mergeSort(nums,m+1,right);
            merge(nums,left,m+1,right);
        }
    }

    private int partition(int[]  nums,int low,int high){
        int left,right,pivotItem = nums[low];
        left = low;
        right = high;
        int temp;
        while(left < right) {
            while (nums[left] <= pivotItem)
                left++;
            while (nums[right] > pivotItem)
                right--;
            if (left < right) {
                temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        nums[low] = nums[right];
        nums[right] = pivotItem;
        return right;
    }
    public void quickSort(int[] nums, int low, int high){
        int pivot;
        if(high>low){
            pivot = partition(nums,low,high);
            quickSort(nums,low,pivot-1);
            quickSort(nums,pivot+1,high);
        }
    }

}

