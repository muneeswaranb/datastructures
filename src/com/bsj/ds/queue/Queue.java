package com.bsj.ds.queue;

import com.bsj.ds.stack.Stack;

/**
 * Below one is my try
 */
/*public class Queue {
    int entryPoint;
    int exitPoint;
    int MAX_SIZE=1000;
    Queue(){
        entryPoint=exitPoint=-1;
    }
}*/

public class Queue {
    Stack stack1=new Stack();
    Stack stack2=new Stack();

    public void enque(int x){
        /**
         * 1. check the size of stack1
         * Enqueue:
         * ---------
         * 2.If stack 1 is empty--> enque the data straight away
         * 3.If stack is not empty, move all the element from stack 1 to stack to using s12.push(s1.pop) until the stack 1 is empty
         * Dequeue:
         * -------
         * If stack 1 is empty-->throw empty exception
         * else return the top element using peek() and remove the same by Pop()         *
         */
    }
}


