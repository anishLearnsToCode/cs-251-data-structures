import java.util.LinkedList;
import java.util.Scanner;

public class SearchInSortedLinkedList {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Node head = new Node(0);
        Node temp = head;

        System.out.println("Enter No. Of entries : ");
        int numberOfEntries = in.nextInt();
        while (numberOfEntries-- > 0){
            int element = in.nextInt();
            temp.next = new Node(element);
            temp = temp.next;
        }

        System.out.println("Enter element to be inserted : ");
        int element = in.nextInt();
        temp = head;
        while (temp.next != null && element > temp.next.data){
            temp = temp.next;
        }
        Node ans = new Node(element);
        ans.next = temp.next;
        temp.next = ans;

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
