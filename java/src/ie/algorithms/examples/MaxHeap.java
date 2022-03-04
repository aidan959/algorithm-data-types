package ie.algorithms.examples;

public class MaxHeap extends Heap{
    public MaxHeap(int maxSize){
        super(maxSize);
    } 

    public int getMax(){
        return heap[0];
    }
    public void heapify(int pos){
        int largest = pos;
        if(leftChild(pos ) <= size && heap[leftChild(pos)] > heap[pos])
            largest = leftChild(pos);
        if(rightChild(pos ) <= size && heap[rightChild(pos)] > heap[largest])
            largest = rightChild(pos);
        if(largest != pos){
            swap(pos, largest);
            heapify(largest);
        }
        
    }
    public void insert(int data){
        heap[size] = data;

        int current = size;
        while(heap[current] > heap[parent(current)]){
            System.out.println(heap[current] + " > " + heap[parent(current)] );

            swap(current, parent(current));
            current = parent(current);
        }
        size++;
    }
    public int remove(){
        int popElement = heap[root];
        heap[root] = heap[size--];
        heapify(root);
        return popElement;
    }
    public int peek(){
        return heap[0];

    }
    public static void main(String[] args){
        MaxHeap heap = new MaxHeap(20);
        heap.insert(10);
        heap.insert(15);
        heap.insert(5);
        heap.insert(5);
        heap.insert(14932);
        heap.insert(4);
        heap.insert(2);
        heap.remove();
        heap.remove();
        heap.remove();
        heap.displayHeap();



    }
}
