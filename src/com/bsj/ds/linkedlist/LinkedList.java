package com.bsj.ds.linkedlist;

public class LinkedList {

}

class SinglyLinkedListNode{
    int data;
    SinglyLinkedListNode nextNode;

    public SinglyLinkedListNode(int data){
        this.data=data;
        nextNode=null;
    }
}

class DoublyLinkedListNode{
    int data;
    DoublyLinkedListNode previousNode;
    DoublyLinkedListNode nextNode;

    public DoublyLinkedListNode(int data){
        this.data=data;
        previousNode=nextNode=null;
    }
}


class CircularLinkedListNode{
    int data;
    CircularLinkedListNode previousNode;
    CircularLinkedListNode nextNode;

    public CircularLinkedListNode(int data){
        this.data=data;
        previousNode=nextNode=null;
    }
}
