package algorithms.examples;
// Sorted linked list with a sentinel node
// Skeleton code

import java.util.Currency;

public class SortedLL
{
    // this function does not need a constructor
    // we only need to define head when inserting 
    // first value
    public SortedLL(){
    }
    Node head;
    class Node{
        // nodes variables
        int data;
        // set this by default to null
        Node next = null;
        public Node(int x){
            data = x;
        }
    }
    // important method
    public void insertSort(int x)
    {

        // creates the new node to be inserted - new allocates
        // a space in memory for the Node to exist in
        Node t = new Node(x);
        // if head hasn't been created yet - or its smaller than
        // the head value
        if(head == null || head.data >= x ){
            // makes sure the list is traversible
            // by maintaining the "linked" aspect
            // of the linked list
            // this moves the object head refers to
            // into t.next
            t.next = head;
            
            // update the head to this new node
            // with the old head being stored now
            // in head.next
            head = t;
            // exits the function as its now finished
            return;
        }
        // this is the object we store to move through
        // the linked list starting at the head
        Node curr = head;
        // check that the data is greater than the
        // the next item and that we are not at the end
        // of the list - curr.next is null  
        while(curr.data < x && curr.next != null){
            // walk through the list
            // set curr to the next node
            curr = curr.next;
        }
            // set ts next node to the node after current
            t.next = curr.next;
            // insert the new node into the list
            curr.next = t;
        

    }

    public boolean remove(int x) {
        // our temporary list pointer
        Node curr = head;
        Node prev = curr;
        // checks that the data doesnt match the value
        // and the list isnt at an end
        while(curr.data != x && curr.next != null){
            prev = curr;
            // walks through list
            curr = curr.next;
        }
        if(curr.data == x){
            prev.next = curr.next;
            return true;
        }
        return false;
    }
    
    public boolean isEmpty() {
        return head == null;
    }
    
    public void display()
    {
        Node t = head;
        System.out.print("\nHead -> ");
        while( t != null) {
            System.out.print(t.data + " -> ");
            t = t.next;
        }
        System.out.println("null\n");
    }
    public static void main(String[] args)   
    {
        SortedLL list = new SortedLL();

        double x;
        int i, r;
        list.insertSort(10);
        list.insertSort(15);
        list.insertSort(20);
        list.remove(15);
        list.display();

        /*
           for(i = 1; i <= 5; ++i)  {
           x =  (Math.random()*100.0);
           r = (int) x; 
           System.out.println("Inserting " + r);
           list.insert(r);
           list.display();            
        }
        */
        
        /*
        while(!list.isEmpty())  {
            System.out.println("\nInput a value to remove: ");
            Scanner in = new Scanner(System.in);
            r = in.nextInt();
            if(list.remove(r)) {
                System.out.println("\nSuccessfully removed: " + r);
            list.display(); }
            else System.out.println("\nValue not in list");                        
        }
        */
    }
}