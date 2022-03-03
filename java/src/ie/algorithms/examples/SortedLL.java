package ie.algorithms.examples;
// Sorted linked list with a sentinel node
// Skeleton code


public class SortedLL
{
    // this function does not need a constructor
    // we only need to define head when inserting
    // first value
    public SortedLL(){
    }
    // this is used to identify the type of error presented by this class
    public class EmptyLinkedListException extends RuntimeException{
        // allows you to use runtimeexceptions constructor 
        public EmptyLinkedListException(String errorMessage){
            super(errorMessage);
        }
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
        while(curr.next != null && x > curr.next.data  ){
            // walk through the list
            // set curr to the next node
            curr = curr.next;
        }
        // insert the new node into the list
        t.next = curr.next;
        // set ts next node to the node after current
        curr.next = t;



    }

    public boolean remove(int x) {
        // if the head doesn't exist then return false
        if(head == null){
            return false;
        }
        // our temporary list pointer
        Node curr = head;
        // checks that the list isnt at the end AND 
        // checks that the data doesnt match the value <- doesnt execute 
        //                                                first block
        while(curr.next != null && curr.next.data != x ){
            // walks through list
            curr = curr.next;
        }
        if(curr.data == x){
            // this checks if we are dealing with the first item in the linked list
            if(curr.next == null){
                head = null;
            } else{
                head = curr.next;
            }
            return true;
        }
        return false;
    }
    public int popHead(){
        // // you'd want this to throw some handlable
        // // error - as if head is null it cannot be
        // // popped - if I do that, every reference
        // // to popHead will require a try catch block:(

        // NEVER MIND THIS I LEARNED ABOUT RUNTIME EXCEPTIONS
        // these just raise errors that will happen at run time
        if(head == null){
            throw new EmptyLinkedListException("Empty linked list :(");
        }
        // we save this temporary variable to return the value before pulling it
        // from the list - the head = head.next cannot execute AFTER return
        int data = head.data;
        head = head.next;
        return data;

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
        list.remove(10);

        list.display();
        list.insertSort(10);
        list.insertSort(15);
        list.insertSort(20);
        list.remove(15);
        list.remove(10);
        // inserts random data
        list.insertSort((int)(100*Math.random()));
        list.insertSort((int)(100*Math.random()));
        list.insertSort((int)(100*Math.random()));
        list.insertSort((int)(100*Math.random()));
        list.insertSort((int)(100*Math.random()));
        list.insertSort((int)(100*Math.random()));
        list.insertSort((int)(100*Math.random()));
        list.insertSort((int)(100*Math.random()));
        list.insertSort((int)(100*Math.random()));
        System.out.println(list.popHead());

        list.display();
    }
}