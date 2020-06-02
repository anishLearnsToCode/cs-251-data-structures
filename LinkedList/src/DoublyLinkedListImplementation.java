import java.util.Scanner;

public class DoublyLinkedListImplementation {
    private static Scanner in = new Scanner(System.in);

    //Driver Function
    public static void main(String[] args) throws EmptyLinkedList {
        DoublyLinkedList linkedList = new DoublyLinkedList();

        linkedList.insert(12);
        linkedList.insert(34);
        linkedList.insert(100);
        linkedList.print();
        linkedList.printReverse();

        System.out.println(linkedList.remove());
        System.out.println(linkedList.remove());

        linkedList.insert(67);
        linkedList.insert(90);
        linkedList.insert(11);
        linkedList.print();

        System.out.println(linkedList.size());

        if(linkedList.remove(11)) System.out.println("11 removed successfully");
        else System.out.println("11 not found");
    }
}
