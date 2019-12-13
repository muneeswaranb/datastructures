package com.bsj.ds.binarysearchtree;

import java.util.Objects;

public class BinarySearchTreeSearch {
    static Node binarySearchTree=null;
    boolean isPresent=false;
    private Boolean search(Node root,int value){
        if(Objects.isNull(root)) isPresent= false;
        else if(value==root.data){
            isPresent=  true;
        }
        else if(value<root.data){
            search(root.leftNode,value);
        }
        else if(value>root.data){
            search(root.rightNode,value);
        }
        return isPresent;
    }

    public static void main(String[] args) {

        int[] numbers={3,2,6,1,25,4,5,9};
        BinarySearchTreeInsertion binarySearchTreeInsertion=new BinarySearchTreeInsertion();
        for (int i = 0; i < numbers.length; i++) {
            binarySearchTree=binarySearchTreeInsertion.insert(binarySearchTree,numbers[i]);
        }
        boolean isPresent =new BinarySearchTreeSearch().search(binarySearchTree,13);
        System.out.println("Is Present : "+isPresent);
    }
}
