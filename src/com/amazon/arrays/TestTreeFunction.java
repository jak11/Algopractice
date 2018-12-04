package com.amazon.arrays;

import java.util.LinkedList;
import java.util.Queue;

public class TestTreeFunction
{
    static class Node{
        int data;
        Node left;
        Node right;

        Node(){

        }

        Node(int data){
            this.data = data;
        }

        public int getData()
        {
            return data;
        }

        public void setData(int data)
        {
            this.data = data;
        }

        public Node getLeft()
        {
            return left;
        }

        public void setLeft(Node left)
        {
            this.left = left;
        }

        public Node getRight()
        {
            return right;
        }

        public void setRight(Node right)
        {
            this.right = right;
        }
    }
    public static int getNodesinBetween(Node root, int n1, int n2) {
        if(root == null) return -1;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);



        int count = 0;
        Node temp = null;
        int foundNumber = 0;
        while (!q.isEmpty()){
            temp = q.poll();

            if(temp == null){
                if(!q.isEmpty()){
                    q.add(null);
                }
            } else {

                if (temp.getData() == n1) {
                    boolean found = false;
                    Node temp2 = q.poll();
                    int path=0;
                    while (!q.isEmpty() && temp2 != null){
                        path++;
                        if(temp2.getData() == n2){
                            found = true;
                            break;
                        }
                    }
                    if(found){
                        return path;
                    }else {
                        return -1;
                    }
                }

                if (temp.getLeft() != null) {
                    q.add(temp.getLeft());
                } else {
                    q.add(new Node(-1));
                }

                if (temp.getRight() != null) {
                    q.add(temp.getRight());
                } else {
                    q.add(new Node(-1));
                }
            }

        }
        return 0;

    }

}
