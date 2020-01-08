package com.bsj.problems;

public class CircularArraySearch {

    private int search(int nums[],int target){


        if(nums!=null&&nums.length>0) {
            int start=0;
            int end=nums.length-1;
            while(start<=end){
               int mid=(start+end)/2;
                /**
                 * case 1: find the sorted part of array
                 *      1.a: Find the mid
                 *      2.Check a[mid]==target-->retrun mid index
                 *      1.b: Compare a[low]<a[mid]--> left half sorted
                 *          1.b.1. check target is between a[low] and a[mid]
                 *          1.b.2 if yes, shrink the search area between low and mid-1
                 *      1.c: Compare a[mid]<a[high]--> right half sorted
                 *          1.c.1 check if target is between a[mid] and a[high]
                 *          1.c.2 if yes, shrink the search by mid+1 and high
                 *          int[] num={4,5,6,7,0,1,2};
                 */
       /* if(start==end){
            return input[start]==target?start:-1;
        }*/

                if(nums[mid]==target) return mid;
                if(nums[mid]<=nums[end]){ // Right array is sorted
                    if(target>nums[mid]&&target<=nums[end]){
                        start=mid+1;
                    }
                    else{
                        end=mid-1;
                    }
                }
                if(nums[start]<=nums[mid]){ //left array is sorted
                    if(target>=nums[start]&&target<nums[mid]) {
                        end=mid-1;
                    }
                    else{
                        start=mid+1;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] num={4,5,6,7,0,1,2};

        CircularArraySearch circularArraySearch =new CircularArraySearch();
        System.out.println("Index of 3 "+ circularArraySearch.search(num,3));
        System.out.println("Index of 18 "+ circularArraySearch.search(num,5));
        System.out.println("Index of 15 "+ circularArraySearch.search(num,15));
    }
}
