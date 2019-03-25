package com.olview.dayone.lineartable.list;


public class OliveArrayList implements OliveList {
    private int maxSize = 100;
    private int[] arr = new int[maxSize];
    private int head = -1; //
    private int rear = -1;

    public void addFirst(int var) {
        int size = (rear + 1) % maxSize;
        if (head > 0) {
            arr[head - 1] = var;
            head--;
        } else if (head == 0) {
            if (size >= 0) System.arraycopy(arr, 0, arr, 1, size);
            arr[0] = var;
            rear++;
        } else {
            arr[0] = var;
            head++;
            rear++;
        }

    }

    public int getFirst() {
        if (head >= 0) {
            return arr[head];
        } else {
            return -1;
        }
    }

    public void addLast(int var) {
        if(head>=0){
            if ((rear + 1) % maxSize != head) {
                arr[rear + 1] = var;
                rear++;
            } else {
                System.out.println("\nStack Overflow");
            }
        }else {
            arr[0] = var;
            head++;
            rear++;
        }

    }

    public int getLast() {
        if (rear >= 0) {
            return arr[rear];
        } else {
            return -1;
        }
    }


    public int getSize() {
        if (rear < head) {
            return maxSize - head + rear +1;
        } else if (rear > head) {
            return rear - head + 1;
        } else{
            if(head == -1){
                return -1;
            }else {
                return 1;
            }
        }

    }

    public boolean isFind(int var) {
        int size = this.getSize();
        if (head >= 0 && rear >= 0) {
            for (int i = head; i < size; i++) {
                if (arr[i%maxSize] == var) {
                    return true;
                }
            }

        }else {System.out.println("\nStack error");}
        return false;
    }


    public void delete(int var) {
        int size = this.getSize();
        if (head == -1){
            System.out.println("\nStack underflow");
        }

        for(int i = head;i < head+size;i++){
            if(arr[i] != var){
                continue;
            }else {
                arr[i] = arr[i+1];
            }
            rear--;
        }
    }

}
