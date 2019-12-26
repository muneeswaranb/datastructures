package com.bsj.ds.binarysearchtree;

public class BinarySearchTreeHeight {

    int height =0;
    private Integer findHeight(Node root,int value){
        height= 0;
        if(root==null) height= 0;
        else if(value>root.data) findHeight(root.rightNode,value);
        else if(value<root.data) findHeight(root.leftNode,value);
        else if(value==root.data) height= maxDepth(root);
        return height;
    }
    private Integer maxDepth(Node root){
        if(root==null) return 0;
        else{
            Integer leftDepth=maxDepth(root.leftNode);
            Integer rightDepth=maxDepth(root.rightNode);
            if(leftDepth>rightDepth) return leftDepth+1;
            else return rightDepth+1;
        }
    }
    public static void main(String[] args) {
        int[] numbers = {3, 2, 6, 1, 25, 4, 5, 9, 7, 32, 10, 30};
        Node binarySearchTree = null;
        BinarySearchTreeInsertion binarySearchTreeInsertion = new BinarySearchTreeInsertion();
        for (int i = 0; i < numbers.length; i++) {
            binarySearchTree = binarySearchTreeInsertion.insert(binarySearchTree, numbers[i]);
        }
        System.out.println("Depth : "+new BinarySearchTreeHeight().maxDepth(binarySearchTree));
        System.out.println("Depth : "+new BinarySearchTreeHeight().findHeight(binarySearchTree,5));
    }
}
