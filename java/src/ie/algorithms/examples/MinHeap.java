package ie.algorithms.examples;

public class MinHeap extends Heap{
    public MinHeap(int maxSize){
        super(maxSize);
        heap[0] = Integer.MIN_VALUE;
    } 

    public int getMin(){
        return heap[0];
    }
    public void heapify(int pos){
        if(!(pos >= (size/2)) && pos <= size){
            if(heap[pos] > heap[leftChild(pos)] || heap[pos] > heap[rightChild(pos)]){
                if(heap[leftChild(pos)]<heap[rightChild(pos)]){
                    swap(pos, leftChild(pos));
                    heapify(leftChild(pos));
                }
                else {
                    swap(pos, rightChild(pos));
                    heapify(rightChild(pos));
                }
            }
        }    
    }
    public void insert(int data){
        if (size >= maxSize){
            return;
        }
        heap[++size] = data;

        int current = size;
        while(heap[current] < heap[parent(current)]){
            System.out.println(heap[current] + " < " + heap[parent(current)] );

            swap(current, parent(current));
            current = parent(current);
        }
    }
    public int remove(){
        int popElement = heap[root];
        heap[root] = heap[size--];
        heapify(root);
        return popElement;
    }
    public int peek(){
        return heap[root];

    }
    public static boolean checkMinHeap(int[] A, int i)
    {
        // if `i` is a leaf node, return true as every leaf node is a heap
        if (2*i + 2 > A.length) {
            return true;
        }
 
        // if `i` is an internal node
 
        // recursively check if the left child is a heap
        boolean left = (A[i] <= A[2*i + 1]) && checkMinHeap(A, 2*i + 1);
 
        // recursively check if the right child is a heap (to avoid the array index out
        // of bounds, first check if the right child exists or not)
        boolean right = (2*i + 2 == A.length) ||
                        (A[i] <= A[2*i + 2] && checkMinHeap(A, 2*i + 2));
 
        // return true if both left and right child are heaps
        return left && right;
    }
 
    public static void main(String[] args){
        MinHeap heap = new MinHeap(20);
        heap.insert(10);
        heap.insert(15);
        heap.insert(5);
        heap.insert(5);
        heap.insert(14932);
        heap.insert(4);
        heap.insert(2);
        heap.displayHeap();
        System.out.println(MinHeap.checkMinHeap(heap.heap, 0));
        heap.remove();
        heap.remove();
        heap.remove();
        heap.remove();
        heap.remove();
        heap.remove();

        heap.displayHeap();



    }
}
