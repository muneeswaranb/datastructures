package com.bsj.ds.binarysearchtree;

public class BinarySearchTreeInsertion {
    Node root=null;

    private Node insert(int value){
        return null;
    }
    public Node insert(Node root,int value){
        if (root==null){
            root=new Node(value);
            //return root;
        }
        else if(value<root.data){
            root.leftNode=insert(root.leftNode,value);
        }
        else if(value>root.data){
            root.rightNode=insert(root.rightNode,value);
        }
        return root;
    }
    public void preOrder(Node root) {
        if (root != null) {
            preOrder(root.leftNode);
            System.out.println("" + root.data);
            preOrder(root.rightNode);
        }
    }

        public static void main(String args[]){
            int[] numbers={3,2,6,1,25,4,5,9};
            Node binarySearchTree=null;
            BinarySearchTreeInsertion binarySearchTreeInsertion=new BinarySearchTreeInsertion();
            for (int i = 0; i < numbers.length; i++) {
                 binarySearchTree=binarySearchTreeInsertion.insert(binarySearchTree,numbers[i]);
            }
            binarySearchTreeInsertion.preOrder(binarySearchTree);
        }
}
