package A2ZSheet;

class minHeap {

    int[] heap;
    int size;

    // Constructor
    public minHeap() {
        heap = new int[1000];
        size = 0;
    }

    // Insert into heap
    public void push(int x) {

        heap[size] = x;

        int i = size;

        // Heapify Up
        while (i > 0 && heap[(i - 1) / 2] > heap[i]) {

            int temp = heap[(i - 1) / 2];
            heap[(i - 1) / 2] = heap[i];
            heap[i] = temp;

            i = (i - 1) / 2;
        }

        size++;
    }

    // Remove minimum element
    public void pop() {

        if (size == 0) {
            return;
        }

        // Move last element to root
        heap[0] = heap[size - 1];

        size--;

        int i = 0;

        // Heapify Down
        while (2 * i + 1 < size) {

            int left = 2 * i + 1;
            int right = 2 * i + 2;

            int smallest = left;

            if (right < size && heap[right] < heap[left]) {
                smallest = right;
            }

            if (heap[i] <= heap[smallest]) {
                break;
            }

            int temp = heap[i];
            heap[i] = heap[smallest];
            heap[smallest] = temp;

            i = smallest;
        }
    }

    // Return minimum element
    public int peek() {

        if (size == 0) {
            return -1;
        }

        return heap[0];
    }

    // Return heap size
    public int size() {
        return size;
    }

    public static void main(String[] args){

    }
}
