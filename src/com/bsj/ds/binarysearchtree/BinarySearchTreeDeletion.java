package com.bsj.ds.binarysearchtree;

public class BinarySearchTreeDeletion {
    Boolean isDeleted = false;
    private static Node parent = null;
    private static Node current = null;
    private static Node root;

    private Node deleteNode(Node root, int data){
        if(root==null) return root;
        if(data<root.data) root.leftNode= deleteNode(root.leftNode,data);
        else if(data>root.data) root.rightNode= deleteNode(root.rightNode,data);
        else{
            //Case 1: No Child
            //Case 2: Single child
            if(root.leftNode==null) root=root.rightNode;
            else if(root.rightNode==null) root=root.leftNode;
            //Case 3: 2 children
            else{
            int minData=minValue(root.rightNode);
            root.data=minData;
            root.rightNode = deleteNode(root.rightNode,minData);
        }
        }
        return root;
    }

    int minValue(Node root)
    {
        int minv = root.data;
        while (root.leftNode != null){
            minv = root.leftNode.data;
            root = root.leftNode;
        }
        return minv;
    }

    public static void main(String[] args) {

        int[] numbers={3,2,6,1,25,4,5,9};
//                int[] numbers={15,12,13,10,17,23,20,};
        BinarySearchTreeInsertion binarySearchTreeInsertion=new BinarySearchTreeInsertion();
        for (int i = 0; i < numbers.length; i++) {
            root=binarySearchTreeInsertion.insert(root,numbers[i]);
        }
        System.out.println("Before delete :");
        binarySearchTreeInsertion.preOrder(root);
        root=new BinarySearchTreeDeletion().deleteNode(root,3);
        System.out.println("Afer delete :");
        binarySearchTreeInsertion.preOrder(root);
//        System.out.println("isDeleted : "+isDeleted);
    }
}
