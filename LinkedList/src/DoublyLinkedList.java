import java.util.Scanner;

public class DoublyLinkedList {
    private Scanner in = new Scanner(System.in);
    private class Node{
        int data;
        Node prev, next;

        Node(){
            data = 0;
            prev = next = null;
        }
        Node(int data){
            this.data = data;
            prev = next = null;
        }
    }
    private int size = 0;
    private Node head = new Node(0);
    private Node slider = head;

    DoublyLinkedList(){}

    public void insert(int data){
        slider.next = new Node(data);
        slider.next.prev = slider;
        slider = slider.next;
        size++;
    }

    public int remove() throws EmptyLinkedList{
        if(size <= 0){
            throw new EmptyLinkedList();
        }

        int data = slider.data;
        slider = slider.prev;
        slider.next = null;
        size--;
        return data;
    }
    public boolean remove(int data) throws EmptyLinkedList{
        if(size <= 0){
            throw new EmptyLinkedList();
        }

        Node temp = head.next;
        while (temp.next != null){
            if(temp.next.data == data){
                temp.next = temp.next.next;
                if(temp.next != null) temp.next.prev = temp;
                size--;
                return true;
            }temp = temp.next;
        }

        return false;
    }

    public void print(){
        Node temp = head.next;
        while (temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public void printReverse(){
        Node temp = slider;
        while (temp != head){
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }
}

class EmptyLinkedList extends Exception{
    EmptyLinkedList(){
        System.out.println("Linked List Empty Exception");
    }
}