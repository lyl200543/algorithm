package necessary.class035;

import java.util.PriorityQueue;

/**
 *ClassName: class035_5_leetcode_295
 *Package: necessary.class035
 *Description:创建于 2025/10/6 20:23
 *  https://leetcode.cn/problems/find-median-from-data-stream/
 *@Author lyl
 *@Version 1.0
 */
public class class035_5_leetcode_295 {
}

class MedianFinder {
    private PriorityQueue<Integer> maxHeap;  //存放较小部分的数
    private PriorityQueue<Integer> minHeap;  //存放较大部分的数

    public MedianFinder () {
        maxHeap = new PriorityQueue<>((a , b) -> b - a);
        minHeap = new PriorityQueue<>((a , b) -> a - b);
    }

    public void addNum (int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }
        balance();
    }

    private void balance () {
        if (maxHeap.size() - minHeap.size() >= 2) {
            minHeap.add(maxHeap.poll());
        } else if (minHeap.size() - maxHeap.size() >= 2) {
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian () {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else {
            return minHeap.peek();
        }
    }
}
