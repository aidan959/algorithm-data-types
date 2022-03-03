package ie.algorithms.examples;

public class Heap {
    private int[] heap;
    private int N = 0;
    static int maxHeight = 100;
    private int priority;
    private boolean minHeap;
    public Heap(int size, boolean minHeap, int  priority){
        this.minHeap = minHeap;
        heap = new int[size + 1];
        this.priority = priority;
    }
    private int parent(int pos){
        return(pos - 1)/2;
    }
    private int leftChild(int pos){
        return (2 * pos);
    }
    private int rightChild(int pos){
        return (2 * pos) + 1;
    }
    private boolean isLeaf(int pos){
        return pos > (N / 2) && pos <= N;
        
    }
    public void swap(int h1, int h2){
        int tmp;
        tmp = heap[h1];

        heap[h1] = heap[h2];
        heap[h2] = tmp;
    }
    private void minHeapify(int pos){
        if(!isLeaf(pos)){
            if(heap[pos] > heap[leftChild(pos)] || heap[pos] > heap[rightChild(pos)]){
                if(heap[leftChild(pos)] < heap[rightChild(pos)]){
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos));
                }
                else {
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos));
                }
            }
        }
    }
    public void insert(int element){
        if(N > maxHeight){
            return;
        }
        heap[++N] = element;
        int current = N;
        while(heap[current] > heap[parent(current)]){
            swap(current, parent(current));
            current = parent(current);
            
        }

    }
    public void siftDown(int amount){

    }
    public int remove(){
        heap[0] = heap[1];
        heap[1] = heap[N--];
        siftDown(1);
        return heap[0];
    }
}
