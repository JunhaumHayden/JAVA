package edu.ufsc.fln.datastructures.domain.queue;

import java.util.NoSuchElementException;

public class Queue {
    private int maxSize;
    private Object[] queueArray;
    private int front;
    private int rear;
    private int nItems;

    // Constructor
    public Queue(int size) {
        this.maxSize = size;
        this.queueArray = new Object[maxSize];
        this.front = 0;
        this.rear = -1;
        this.nItems = 0;
    }
    // class methods
    public boolean isEmpty() {
        return this.nItems == 0;
    }
    public boolean isFull() {
        return this.nItems == this.maxSize;
    }
    public void enqueue(Object item) throws IllegalArgumentException {
        if (isFull()) {
            throw new IllegalArgumentException("This queue is already full.");
        }
        if (rear == maxSize - 1) { // rear index is at the end of the array
            rear = -1; // wrap around
        }
        queueArray[++rear] = item; // increment rear and add item
        nItems++;
    }
    public Object dequeue() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("This queue is already empty.");
        }
        Object temp = queueArray[front++]; // get the front item and increment front
        if (front == maxSize) { // wrap around
            front = 0;
        }
        nItems--; // decrement the number of items
        return temp;
    }
    public Object peekFront() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("This queue is already empty.");
        }
        return queueArray[front]; // return the front item without removing it
    }
    public int size (){
        return nItems;
    }
}
