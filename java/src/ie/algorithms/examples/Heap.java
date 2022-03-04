package ie.algorithms.examples;

public class Heap {
    int heap[];
    int size;
    int maxSize;
    int root = 1;
    public Heap(int maxSize){
        this.maxSize = maxSize;
        size = 0;
        heap = new int[maxSize + 1];
    } 
    public int parent(int pos){
        return (pos)/2;
    }
    public int leftChild(int pos){
        return (2 * pos);
    }
    public int rightChild(int pos){
        return (2 * pos) + 1;
    }
    public void swap(int h1, int h2){
        int tmp = heap[h1];

        heap[h1] = heap[h2];
        heap[h2] = tmp;
    }
    public boolean checkLeaf(int pos){
        return(pos > (maxSize /2) && pos <= maxSize);
    }
    public void displayHeap()  {   
        System.out.println("PARENT NODE" + "\t" + "LEFT CHILD NODE" + "\t" + "RIGHT CHILD NODE");  
        for (int k = 1; k <= size / 2; k++) {   
            System.out.println(" " + heap[k] + "\t\t" + heap[leftChild(k)] + "\t\t" + heap[rightChild(k)]);   
        }   
    }   
}
