package ie.algorithms.examples;

import java.util.EmptyStackException;


public class Stack {
    public class Node{
        int value;
        Node next;
        public Node(int v){
            // place the value into the node 
            value = v;
            // sets the next item to the stack
            next = top;
        }
    }
    int index;
    Node top;
    public Stack(){
    }
    // Pushed value onto the stack
    public void push(int x){
        // sets the top of the stack to the new Node
        // this constructor handles updating the stack
        top = new Node(x);
    }
    public int pop(){
        // if the top item is null - raise this error
        if(top == null){
            throw new EmptyStackException();
        }
        // saves the temporary value from the stack
        int temp = top.value;
        // moves the top pointer to the next object
        top = top.next;
        // returns this value
        return temp;
    }
    public int peek(){
        // checks if top is null
        if(top == null){
            throw new EmptyStackException();
        }
        //  returns the value
        return top.value;
    }
    // allows you to peek into the stack 
    public int peek(int val){
        if(val < 0){
            throw new NegativeArraySizeException();
        }
        Node temp = top;
        // checks if top is null
        for(int i = 0; i < val; i++){
            if(top == null){
                throw new EmptyStackException();
            }
            temp = temp.next;
        }
        //  returns the value
        return temp.value;
    }
    public void display(){
        Node t = top;
        while(t != null){
            System.out.print(t.value + ", ");
            t= t.next;
        }

        System.out.println("");
    }
}
