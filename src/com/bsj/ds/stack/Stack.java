package com.bsj.ds.stack;

public class Stack {
    int currentLocation;
    int capacity;
    int[] elements;

    public Stack() {
        currentLocation = -1;
    }

    public Stack(int capacity) {
        this.capacity = capacity;
        elements = new int[capacity];
        currentLocation = -1;
    }

    public void push(int x) {
        currentLocation++;
        if (currentLocation == capacity) elements = extend(elements);
        elements[currentLocation] = x;
    }

    public int[] extend(int[] source) {
        this.capacity = source.length * 2;
        int[] destination = new int[capacity];
        for (int i = 0; i < source.length; i++) {
            destination[i] = source[i];
        }
        source = null;
        return destination;
    }

    public void pop() {
        if (currentLocation == -1) currentLocation = Integer.MIN_VALUE;
        currentLocation--;
    }

    public int top() {
        if (currentLocation == -1) return Integer.MAX_VALUE;
        return elements[currentLocation];
    }
	
    public boolean isEmpty(){
	return currentLocation==-1;
    }

    public static void main(String[] args) {
        try {
            Stack stack = new Stack(5);
            stack.push(5);
            stack.push(10);
            stack.push(15);
            stack.push(20);
            stack.push(25);
            stack.push(30);
            stack.push(35);
            System.out.println("Top element : " + stack.top());
            stack.pop();
            System.out.println("Top element post pop : " + stack.top());
            System.out.println("is Empty : " + stack.isEmpty());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
