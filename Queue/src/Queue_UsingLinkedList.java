
public class Queue_UsingLinkedList {
    private class Node{
        int data;
        Node next;

        Node(){
            data = 0;
            next = null;
        }
        Node(int data){
            this.data = data;
            next = null;
        }
    }
    private int size = 0;
    private Node head = new Node(0), slider = head;

    public void enQueue(int data){
        slider.next = new Node(data);
        slider = slider.next;
        size++;
    }

    public int deQueue() throws QueueUnderFlowException{
        if(size <= 0){
            throw new QueueUnderFlowException();
        }
        int data = head.next.data;
        head.next = head.next.next;
        size--;
        return data;
    }

    public int top() throws QueueUnderFlowException{
        if(size <= 0){
            throw new QueueUnderFlowException();
        }
        return head.next.data;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    @Override
    public String toString() {
        String ans = "";
        Node temp = head.next;
        while (temp != null){
            ans = ans + temp.data + " ";
            temp = temp.next;
        }

        return ans;
    }
}

class QueueUnderFlowException extends Exception{
    QueueUnderFlowException(){
        System.out.println("QueueUnderFlowException");
    }
}