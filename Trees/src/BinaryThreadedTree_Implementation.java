import java.util.Scanner;

public class BinaryThreadedTree_Implementation {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int inOrder[] = {4,2,5,1,6,3,7};
        int preOrder[] = {1,2,4,5,3,6,7};
        BinaryThreadedTree tree = BinaryThreadedTree.create(inOrder, preOrder);
        tree.print();

        System.out.println("\nPre Order Traversal : ");tree.preOrderTraversal();
        System.out.println("\nIn Order Traversal : "); tree.inOrderTraversal();

        System.out.print("\nIn-Order Predecessor : " + tree.inOrderPredecessor());
        System.out.print("\nIn-Order Successor : " + tree.inOrderSuccessor());
    }
}
