package leetcode.heap;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.ArrayList;
import java.util.List;

public class MaxHeap {
    private List<Integer> heap;

    public MaxHeap() {
        this.heap = new ArrayList<>();
    }

    public int parent(int index) {
        return (index - 1) / 2;
    }

    public int lefChild(int index) {
        return index * 2 + 1;
    }

    public int rightChild(int index) {
        return index * 2 + 2;
    }

    public void swap(int i, int j) {
        int temp = heap.get(j);
        heap.set(j, heap.get(i));
        heap.set(i, temp);
    }

    public void insert(int value) {
        this.heap.add(value);
        int currentIndex = heap.size() - 1;
        while (currentIndex > 0 && heap.get(currentIndex) > heap.get(parent(currentIndex))) {
            swap(currentIndex, parent(currentIndex));
            currentIndex = parent(currentIndex);
        }
    }

    public int extractMax() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        int max = heap.get(0);
        int min = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, min);
            heapify(0);
        }
        return max;
    }

    private void heapify(int index) {
        int max = index;
        int left = lefChild(index);
        int right = rightChild(index);
        if (left < heap.size() && heap.get(left) > heap.get(max)) {
            max = left;
        }
        if (right < heap.size() && heap.get(right) > heap.get(max)) {
            max = right;
        }
        if (max != index) {
            swap(max, index);
            heapify(max);
        }
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.insert(2);
        maxHeap.insert(6);
        maxHeap.insert(3);
        maxHeap.insert(7);
        maxHeap.insert(1);
        maxHeap.insert(3);
        System.out.println(maxHeap.extractMax());
        System.out.println(maxHeap.extractMax());
        System.out.println(maxHeap.heap);
    }
}