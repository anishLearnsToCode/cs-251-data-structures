import java.util.Scanner;

class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
    }
}

class CircularLinkedList{
    private Scanner in = new Scanner(System.in);
    private Node head, current;
    private int size;

    CircularLinkedList(){
        head = new Node(0);
        size=0;
    }

    public void insertMultipleData(){
        System.out.print("Enter how many entries you wish to make : ");
        int n = in.nextInt();
        while (n-- > 0){
            insertData();
        }
    }
    public void insertData(){
        System.out.print("Enter Data : ");
        int data = in.nextInt();
        if(size == 0){
            head.next = new Node(data);
            current = head.next;
            current.next = head;
        } else {
            current.next = new Node(data);
            current = current.next;
            current.next = head;
        }
        size++;
    }

    public void print(){
        Node temp = head.next;
        while (temp != head){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public int getSize(){
        return size;
    }
}

public class CircularLinkedListImplementation {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        CircularLinkedList linkedList = new CircularLinkedList();
        do {
            System.out.println("\n\nSelect any of thr following choices :-");
            System.out.println("1) Add multiple elements");
            System.out.println("2) Add Single Element");
            System.out.println("3) Print Linked List");
            System.out.println("4) Size Of LinkedList");
            System.out.println("5) Exit");
            choice = in.nextInt();

            switch (choice){
                case 1 :
                    linkedList.insertMultipleData();
                    break;
                case 2 :
                    linkedList.insertData();
                    break;
                case 3 :
                    linkedList.print();
                    break;
                case 4 :
                    System.out.println(linkedList.getSize());
                    break;
            }
        }while (choice != 5);
    }
}
