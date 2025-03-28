package edu.ufsc.fln.stack.domain;


public class Stack {
    private int maxSize;
    private long[] stackArray;
    private int top;

    // Constructor
    public Stack(int size) {
        this.maxSize = size;
        this.stackArray = new long[maxSize];
        this.top = -1;
    }

    public void push(long value) throws Exception {
        if (isFull()) {
            throw new Exception("This stack is already full.");
        }
        stackArray[++top] = value;
    }

    public long pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("This stack is already empty.");
        }
        return stackArray[top--];
    }

    public long peek() throws Exception {
    if (isEmpty()) {
        throw new Exception("This stack is already empty.");
    }
    return stackArray[top];
    }

    private boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
