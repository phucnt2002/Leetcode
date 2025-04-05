package leetcode.heap;

import java.util.ArrayList;
import java.util.List;


public class MinHeap {
    private List<Integer> heap;

    public MinHeap() {
        heap = new ArrayList<>();
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return 2 * i + 1;
    }

    private int rightChild(int i) {
        return 2 * i + 2;
    }

    private void swap(int i, int j) {
        Integer temp = this.heap.get(j);
        heap.set(j, heap.get(i));
        heap.set(i, temp);
    }

    public void insert(int value) {
        this.heap.add(value);
        int currentIndex = heap.size() - 1;
        while (currentIndex > 0 && heap.get(currentIndex) < heap.get(parent(currentIndex))) {
            swap(currentIndex, parent(currentIndex));
            currentIndex = parent(currentIndex);
        }
    }
 
    public int extractMin() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        int min = heap.get(0);
        int max = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, max);
            heapify(0);
        }
        return min;
    }

    private void heapify(int index) {
        int smallest = index;
        int left = leftChild(index);
        int right = rightChild(index);
        if (left < heap.size() && heap.get(left) < heap.get(smallest)) {
            smallest = left;
        }
        if (right < heap.size() && heap.get(right) < heap.get(smallest)) {
            smallest = right;
        }
        if (smallest != index) {
            swap(smallest, index);
            heapify(smallest);
        }

    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();
        minHeap.insert(2);
        minHeap.insert(3);
        minHeap.insert(1);
        minHeap.insert(7);
        System.out.println(minHeap.extractMin());
        System.out.println(minHeap.extractMin());
        System.out.println(minHeap.extractMin());
        System.out.println(minHeap.heap);
    }
}
