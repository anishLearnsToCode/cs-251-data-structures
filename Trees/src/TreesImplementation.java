import java.util.ArrayList;
import java.util.Scanner;

public class TreesImplementation {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        Tree root = new Tree();

        do {
            System.out.println("Select any of the following :-");
            System.out.println("1) Create Tree");
            System.out.println("2) Children Of Root");
            System.out.println("3) Print Tree");
            System.out.println("\n4) Height Of Tree");
            System.out.println("\n5) Level Order Traversal");
            choice = in.nextInt();

            switch (choice){
                case 1 :
                    root = createTree();
                    break;
                case 2 :
                    int children = root.childrenNumber();
                    System.out.println(children);
                    break;
                case 3 :
                    root.print();
                    break;
                case 4 :
                    System.out.println(root.height());
                    break;
                case 5 :
                    ArrayList<ArrayList<Tree>> ans = root.levelOrderTraversal();
                    print(ans);
                    break;
            }
        } while (choice <= 5 );
    }

    public static Tree createTree () {
        System.out.print("Enter node : ");
        int node = in.nextInt();

        Tree root = new Tree(node);

        System.out.print("Enter no. of children : ");
        int child = in.nextInt();

        for(int i=0 ; i<child ; i++){
            root.addChild(createTree());
        }

        return root;
    }

    private static void print(ArrayList<ArrayList<Tree>> list2D){
        for(ArrayList<Tree> level : list2D){
            printList(level);
        }
    }
    private static void printList(ArrayList<Tree> level){
        for(Tree tree : level){
            System.out.print(tree.getData() + " ");
        }
        System.out.println();
    }
}
