package com.bsj.ds.binarysearchtree;

public class BinarySearchNthGreatestDelete {
    int elementIndex = 0;
    Node currentElement = null;
    int dataToDelete=0;
    BinarySearchTreeDeletion binarySearchTreeDeletion = null;

    //Node root=null;
    public Node deletenthGreatest(Node root, int count) {
        postOrder(root, count);
        return deleteNode(root, dataToDelete);
    }

    int minValue(Node root) {
        int minv = root.data;
        while (root.leftNode != null) {
            minv = root.leftNode.data;
            root = root.leftNode;
        }
        return minv;
    }

    private Node deleteNode(Node root, int data) {
        if (root == null) return root;
        if (root.data > data)
            root.leftNode = deleteNode(root.leftNode, data);
        else if (root.data < data) root.rightNode = deleteNode(root.rightNode, data);
        else {
            //Case 1: No Child
            //Case 2: Single child
            if (root.leftNode == null) root = root.rightNode;
            else if (root.rightNode == null) root = root.leftNode;
                //Case 3: 2 children
            else {
                int minData = minValue(root.rightNode);
                root.data = minData;
                root.rightNode = deleteNode(root.rightNode, minData);
            }
        }
        return root;
    }

    public void postOrder(Node root, int count) {
        if (root != null) {
            postOrder(root.rightNode, count);
            if(elementIndex<count) {
                System.out.println(" x " + root.data);
                elementIndex++;
                dataToDelete = root.data;
            }
            if(elementIndex==count) {
                System.out.println("Data to be deleted : "+dataToDelete);
                return;
            }
            postOrder(root.leftNode, count);
        }
    }

    public static void main(String[] args) {
        int[] numbers = {3, 2, 6, 1, 25, 4, 5, 9, 7, 32, 10, 30};
        Node binarySearchTree = null;
        BinarySearchTreeInsertion binarySearchTreeInsertion = new BinarySearchTreeInsertion();
        for (int i = 0; i < numbers.length; i++) {
            binarySearchTree = binarySearchTreeInsertion.insert(binarySearchTree, numbers[i]);
        }
        binarySearchTree = new BinarySearchNthGreatestDelete().deletenthGreatest(binarySearchTree, 3);
        binarySearchTreeInsertion.preOrder(binarySearchTree);
//        System.out.println("isDeleted : "+isDeleted);
    }
}
