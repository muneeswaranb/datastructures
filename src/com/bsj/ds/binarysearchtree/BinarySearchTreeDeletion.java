package com.bsj.ds.binarysearchtree;

public class BinarySearchTreeDeletion {
    Boolean isDeleted = false;
    private static Node parent = null;
    private static Node current = null;
    private static Node root;

    private Node deleteNode(Node root, int data){
        if(root==null) return root;
        if(root.data>data)
            root.leftNode= deleteNode(root.leftNode,data);
        else if(root.data<data) root.rightNode= deleteNode(root.rightNode,data);
        else{
            //Case 1: No Child
            //Case 2: Single child
            if(root.leftNode==null) root=root.rightNode;
            else if(root.rightNode==null) root=root.leftNode;
            //Case 3: 2 children
            else{
            int minData=minValue(root);
            root.data=minData;
            root.rightNode = deleteNode(root.rightNode,minData);
        }
        }
        return root;
    }

    int minValue(Node root)
    {
        int minv = root.data;
        while (root.leftNode != null)
        {
            minv = root.leftNode.data;
            root = root.leftNode;
        }
        return minv;
    }

    public static void main(String[] args) {

        int[] numbers={3,2,6,1,25,4,5,9};
        BinarySearchTreeInsertion binarySearchTreeInsertion=new BinarySearchTreeInsertion();
        for (int i = 0; i < numbers.length; i++) {
            root=binarySearchTreeInsertion.insert(root,numbers[i]);
        }
        root=new BinarySearchTreeDeletion().deleteNode(root,25);
        binarySearchTreeInsertion.preOrder(root);
//        System.out.println("isDeleted : "+isDeleted);
    }
}
