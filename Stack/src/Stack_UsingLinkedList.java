
public class Stack_UsingLinkedList {
    private class Node{
        int data;
        Node next;

        Node(){
            next = null;
            data = 0;
        }
        Node(int data){
            this.data = data;
            next = null;
        }
    }
    private int size=0;
    private Node head = new Node(0);

    public void push(int data){
        Node ans = new Node(data);
        ans.next = head.next;
        head.next = ans;
        size++;
    }

    public int peek() throws StackUnderFlowException{
        if(size == 0){
            throw new StackUnderFlowException();
        }
        return head.next.data;
    }

    public int pop() throws StackUnderFlowException{
        if(size <= 0){
            throw new StackUnderFlowException();
        }

        int element = head.next.data;
        head.next = head.next.next;
        size--;
        return element;
    }

    public void print(){
        Node temp = head.next;
        while (temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }
}


class StackUnderFlowException extends Exception{
    StackUnderFlowException(){
        System.out.println("StackUnderFlowException");
    }
}