import java.util.Scanner;

public class StackLinkedListImplementation {
    private static Scanner in = new Scanner(System.in);

    //Driver Function
    public static void main(String[] args) throws StackUnderFlowException {
        Stack_UsingLinkedList stack = new Stack_UsingLinkedList();

        stack.push(10);
        stack.push(23);
        stack.push(55);
        stack.print();

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.print();

        System.out.println(stack.isEmpty());
        System.out.println(stack.size());
    }
}
