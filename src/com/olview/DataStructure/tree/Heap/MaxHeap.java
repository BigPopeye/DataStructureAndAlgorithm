package com.olview.dayone.tree.Heap;

public class MaxHeap {
    public static void main(String[] args) {
        XHeap heap = new XHeap(10);
        MaxHeap testHeap = new MaxHeap();
        testHeap.Insert(5,heap);
        testHeap.Insert(10,heap);
        testHeap.Insert(3,heap);
        testHeap.Insert(15,heap);
        testHeap.Insert(8,heap);
        testHeap.PrintHeap(heap);
        System.out.println("Heap Size is:"+ heap.size+"\n");
        int MaxHeapValue = testHeap.Delete(heap);
        testHeap.PrintHeap(heap);
        System.out.println("the Max Value before delete is:"+ MaxHeapValue);
        System.out.println("Heap Size now is:"+ heap.size+"\n");

    }

    static int  MaxData = 10; //哨兵

    public static class XHeap {
        int[] hp;
        int capacity;
        int size;

        XHeap(int maxSize) { // 创建一个最大容量为maxSize的堆
            hp = new int[maxSize];
            hp[0] = MaxData;
            capacity = maxSize;
            size = 0;
        }
    }

    public XHeap Insert(int var, XHeap heap) {
        if (heap == null) {
            heap = new XHeap(10);
            heap.hp[heap.size + 1] = var;
            heap.size++;
            return heap;
        }
        if (heap.size >= heap.capacity) { //堆已满
            System.out.println("\nHeap is full!");
            return null;
        }
/*  将要插入的值赋值给数组尾部，作为child
    比较该child值与对应father的值大小，
    如果比father小，则结束，返回堆
    如果比father大，则将其father赋值给该尾部值，新的child = father
    由于是完全二叉树，father = child/2 */
        int child = heap.size + 1;
        for (; heap.hp[child / 2] < var; child /= 2) {
            heap.hp[child] = heap.hp[child / 2];
        }
        heap.hp[child] = var;
        heap.size++;
        return heap;
    }

    public int Delete(XHeap heap) { //删除堆顶元素并返回删除的值
        if (heap == null) {
            System.out.println("\nHeap is Empty!");
            return -1;
        }

        int parent;// 由于在向下交换的时候，parent总变成较大的儿子，因此需要记录上次parent的值
        int child;
        int maxValue = heap.hp[1];//保留堆顶元素的值
        int temp = heap.hp[heap.size]; //引入一个临时变量，用来将堆最后一个元素值保留
        for (parent = 1; 2 * parent <= heap.size ; parent = child) {
            child = 2 * parent;
            if (heap.hp[child] < heap.hp[child + 1]) {
                child++;
            }
            if(temp > heap.hp[child]){
                break;
            } else{
                heap.hp[parent] = heap.hp[child];
            }
        }
        heap.hp[parent] = temp;
        heap.size--;
        return maxValue;
    }

    public void PrintHeap(XHeap heap) {
        if (heap.hp != null) {
            for (int i = 1;i<=heap.size;i++) {
                System.out.println(heap.hp[i]);
            }
        } else {
            System.out.println("\nHeap is Empty!");
        }
    }

}
