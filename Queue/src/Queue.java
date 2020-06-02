public class Queue {
    private int[] arr;
    private int size=0;
    private int head=0, tail=0;
    private int currentSize;
    private final int MAX_SIZE;

    Queue(){
        arr = new int[10];
        currentSize = 10;
        MAX_SIZE = 1000;
    }
    Queue(int size){
        arr = new int[size];
        this.currentSize = size;
        MAX_SIZE = 10000;
    }

    public void enQueue(int data) throws QueueOverflowException{
        if(size == MAX_SIZE){
            throw new QueueOverflowException(size);
        }

        if((long)size / currentSize > 0.7 ){
            grow();
        }

        arr[tail % arr.length] = data;
        tail++;
    }
    private void grow(){
        int newArray[] = new int[currentSize * 2];
        for(int startIndex=head%currentSize, index=0 ; index<size ; index++, startIndex++){
            newArray[index] = arr[startIndex % currentSize];
        }
        arr = newArray;
        currentSize *= 2;
        head = 0; tail = size-1;
    }
}

class QueueOverflowException extends Exception{
    QueueOverflowException(){}
    QueueOverflowException(int size){
        System.out.println("QueueOverFlowException : " + size);
    }
}
