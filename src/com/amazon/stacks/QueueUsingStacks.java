package com.amazon.stacks;

import java.util.Stack;

public class QueueUsingStacks
{
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    QueueUsingStacks(){
        s1= new Stack<>();
        s2 = new Stack<>();
    }

    public void enque(int data){
        s1.push(data);
    }
    public int dequeue(){
        if(!s2.isEmpty()){
            return s2.pop();
        }else {
            if(!s1.isEmpty()){
                while (!s1.isEmpty()){
                    s2.push(s1.pop());
                }
                return s2.pop();
            }else {
                return -1;
            }
        }
    }

    @Override
    public String toString()
    {
        return s1.toString() + s2.toString();
    }

    public static void main(String[] args)
    {
        QueueUsingStacks queueUsingStacks = new QueueUsingStacks();
        queueUsingStacks.enque(1);
        queueUsingStacks.enque(2);
        queueUsingStacks.enque(3);
        System.out.println("Dequqe " + queueUsingStacks.dequeue());
        System.out.println("Dequqe " + queueUsingStacks.dequeue());
        queueUsingStacks.enque(4);
        queueUsingStacks.enque(5);
        System.out.println("Dequqe " + queueUsingStacks.dequeue());
        System.out.println("Dequqe " + queueUsingStacks.dequeue());
        queueUsingStacks.enque(6);
        System.out.println("Dequqe " + queueUsingStacks.dequeue());
        System.out.println(queueUsingStacks);
    }
}
