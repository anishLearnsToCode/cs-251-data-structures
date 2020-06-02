import java.util.Scanner;

public class Queue_UsingLinkedList_Implementation {
    private static Scanner in = new Scanner(System.in);

    //Driver Functions
    public static void main(String[] args) throws QueueUnderFlowException {
        Queue_UsingLinkedList queue = new Queue_UsingLinkedList();

        queue.enQueue(12);
        queue.enQueue(89);
        queue.enQueue(7);
        queue.enQueue(45);
        queue.enQueue(900);
        System.out.println(queue);

        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue);

        System.out.println(queue.top());
    }
}
