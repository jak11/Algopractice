package com.amazon.stacks;

import java.util.Stack;

public class ReverseStack
{
    public static void main(String[] args)
    {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Before revesre : "+ stack);
        ReverseStack rs = new ReverseStack();
        rs.reverse(stack);
        System.out.println("After revesre : "+ stack);
    }

    public void reverse(Stack<Integer> s){
        if(!s.isEmpty()){
            int temp = s.pop();
            reverse(s);
            insertAtBottom(s, temp);
        }
    }

    private void insertAtBottom(Stack<Integer> s, int data){
        if(s.isEmpty()){
            s.push(data);
        }else {
            int temp = s.pop();
            insertAtBottom(s, data);
            s.push(temp);
        }

    }
}
