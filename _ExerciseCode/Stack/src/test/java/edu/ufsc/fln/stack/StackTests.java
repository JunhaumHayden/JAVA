package edu.ufsc.fln.stack;

import edu.ufsc.fln.stack.domain.Stack;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StackTests {


        @Test
        void testPush() throws Exception {
            Stack stack = new Stack(2);
            stack.push(1);
            stack.push(2);
            Exception exception = assertThrows(Exception.class, () -> {
                stack.push(3);
            });
            assertEquals("This stack is already full.", exception.getMessage());
        }

        @Test
        void testPop() throws Exception {
            Stack stack = new Stack(2);
            stack.push(1);
            stack.push(2);
            assertEquals(2, stack.pop());
            assertEquals(1, stack.pop());
            Exception exception = assertThrows(Exception.class, () -> {
                stack.pop();
            });
            assertEquals("This stack is already empty.", exception.getMessage());
        }

        @Test
        void testPeek() throws Exception {
            Stack stack = new Stack(2);
            stack.push(1);
            stack.push(2);
            assertEquals(2, stack.peek());
            stack.pop();
            assertEquals(1, stack.peek());
            stack.pop();
            Exception exception = assertThrows(Exception.class, () -> {
                stack.peek();
            });
            assertEquals("This stack is already empty.", exception.getMessage());
        }
    }
