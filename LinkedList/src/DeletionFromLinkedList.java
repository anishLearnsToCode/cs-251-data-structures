import java.util.Scanner;

public class DeletionFromLinkedList {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Node head = new Node(0), temp = head;
        System.out.print("Number Of Entries : ");
        int numberOfEntries = in.nextInt();

        while (numberOfEntries-- > 0){
            int element = in.nextInt();
            temp.next = new Node(element);
            temp = temp.next;
        }

        System.out.print("Enter element to delete : ");
        int element = in.nextInt();

        temp = head;
        while (temp.next != null){
            if(temp.next.data == element){
                temp.next = temp.next.next;
            }temp = temp.next;
        }

        print(head);
    }

    private static void print(Node head){
        Node temp = head.next;
        while (temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
