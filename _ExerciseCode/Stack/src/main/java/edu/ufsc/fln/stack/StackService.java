package edu.ufsc.fln.stack;

import edu.ufsc.fln.stack.domain.Stack;

public class StackService {

    public void executeStackOperations() {
        Stack stack = new Stack(2);
        try {
            stack.push(1);
            stack.push(2);
            System.out.println("Top element is: " + stack.peek());
            System.out.println("Popped element is: " + stack.pop());
            System.out.println("Popped element is: " + stack.pop());
            // Exception in this line, Stack is empty
            //stack.pop();
            // Exception in this line, Stack overflow
            stack.push(20);
            stack.push(40);
            System.out.println("Top element is: " + stack.peek());

            stack.push(60);
            stack.push(80);
            // This line dont execute, because the stack is overflow
            while (!stack.isEmpty()) {
                System.out.println("Popped element is: " + stack.pop()+"\n");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Stack bigStack = new Stack(4);
        try {

            bigStack.push(20);
            bigStack.push(40);
            bigStack.push(60);
            bigStack.push(80);
            while (!bigStack.isEmpty()) {
                System.out.println("Popped element is: " + bigStack.pop());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
