package com.bsj.ds.binarytree;

import java.util.Arrays;
import java.util.List;

class Node {
    int data;
    Node leftNode;
    Node rightNode;

    Node(int data) {
        this.data = data;
        leftNode = rightNode = null;
    }
}

public class SameBinaryTree {
    public static void main(String args[]){
        BinarySearchTree bst=new BinarySearchTree();
        List<Integer> numbers= Arrays.asList(10,-5,6,2,-7,13);
        numbers.forEach(x->bst.insert(x));
        bst.inorder();
    }
}

class BinarySearchTree {

    // Root of BST
    Node root;

    // Constructor
    BinarySearchTree() {
        root = null;
    }

    // This method mainly calls insertRec()
    void insert(int key) {
        root = insertRec(root, key);
        System.out.println("Root node data: "+root.data);
        System.out.println("Data to insert: "+key);
    }

    /* A recursive function to insert a new key in BST */
    Node insertRec(Node root, int key) {

        /* If the tree is empty, return a new node */
        if (root == null) {
            System.out.println("Data to insert as Root : "+key);
            root = new Node(key);
            return root;
        }

        /* Otherwise, recur down the tree */
        if (key < root.data) {
            root.leftNode = insertRec(root.leftNode, key);
            System.out.println("Left node "+root.leftNode.data);
        }
        else if (key > root.data) {
            root.rightNode = insertRec(root.rightNode, key);
            System.out.println("Right node "+root.rightNode.data);
        }

        /* return the (unchanged) node pointer */
        return root;
    }

    // This method mainly calls InorderRec()
    void inorder()  {
        inorderRec(root);
    }

    // A utility function to do inorder traversal of BST
    void inorderRec(Node root) {
        if (root != null) {
            System.out.println("Root node inorder : "+root.data);
            inorderRec(root.leftNode);
            System.out.println(root.data);
            inorderRec(root.rightNode);
        }
    }
}
