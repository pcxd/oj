package lc.easy;

import java.util.ArrayDeque;
import java.util.Deque;


public class MyStack
{
    private Deque<Integer> pushStack;
    private Deque<Integer> popStack;

    public MyStack()
    {
        pushStack = new ArrayDeque<>();
        popStack = new ArrayDeque<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x)
    {
        pushStack.push(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop()
    {
        if(popStack.isEmpty())
        {
            while(!pushStack.isEmpty())
                popStack.push(pushStack.pop());
        }

        if(popStack.isEmpty())
            return -1;
        else
            return popStack.pop();
    }

    /**
     * Get the top element.
     */
    public int top()
    {
        if(popStack.isEmpty())
        {
            while(!pushStack.isEmpty())
                popStack.push(pushStack.pop());
        }

        if(popStack.isEmpty())
            return -1;
        else
            return popStack.peek();

    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty()
    {
        return pushStack.isEmpty() && popStack.isEmpty();
    }
}
