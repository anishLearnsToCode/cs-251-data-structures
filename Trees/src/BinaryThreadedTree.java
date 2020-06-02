import java.util.ArrayList;
import java.util.Scanner;
/*
    A Binary Threaded Tree extends the functionality of a Binary Tree by
    utilizing the null left and right pointers in a Binary Tree Node
 */

public class BinaryThreadedTree {
    private static Scanner in = new Scanner(System.in);

    //Internal Data
    private Integer data;
    private BinaryThreadedTree left, right;
    private int size=0;
    //Boolean variables to see if the left branches are threads or not
    private boolean hasLeftThread, hasRightThread;

    //Constructors
    BinaryThreadedTree(){
        hasLeftThread = false;
        hasRightThread = false;
    }

    BinaryThreadedTree(int data){
        this.data = data;
        hasRightThread = false;
        hasLeftThread = false;
    }

    //Methods
    //To create tree
    public void create(){
        create(this);
        addThreads();
    }
    private BinaryThreadedTree create(BinaryThreadedTree root){
        int data = in.nextInt();
        if(data == -1){
            return null;
        }
        root.data = data;
        size++;

        root.left = create(new BinaryThreadedTree());
        root.right = create(new BinaryThreadedTree());

        return root;
    }
    private void addThreads(){
        ArrayList<BinaryThreadedTree> inOrder = inOrderSequence(this);
        for(int index=0 ; index<inOrder.size() ; index++){
            BinaryThreadedTree tree = inOrder.get(index);
            //Adding Left Thread
            if(tree.left == null){
                if(index > 0){
                    tree.left = inOrder.get(index-1);
                    tree.hasLeftThread = true;
                }
            }

            //Adding Right Thread
            if(tree.right == null){
                if(index < inOrder.size()-1){
                    tree.right = inOrder.get(index+1);
                    tree.hasRightThread = true;
                }
            }
        }
    }

    //Tree Creation from PreOrder and Inorder Traversal
    private static int index=0;
    public static BinaryThreadedTree create(int inOrder[], int preOrder[]){
        index =0;
        BinaryThreadedTree ans = createTree(inOrder, preOrder);
        ans.addThreads();
        index=0;
        return ans;
    }
    private static BinaryThreadedTree createTree(int inOrder[], int preOrder[]){
        if(inOrder.length == 1){
            return new BinaryThreadedTree(inOrder[0]);
        }

        BinaryThreadedTree root = new BinaryThreadedTree(preOrder[index]);
        int nodeIndex = linearSearch(preOrder[index], inOrder);
        int inOrder1[] = new int[nodeIndex];
        int inOrder2[] = new int[inOrder.length - inOrder1.length - 1];
        copy(inOrder, inOrder1, 0, nodeIndex-1);
        copy(inOrder, inOrder2, nodeIndex+1);

        index++;
        root.left = createTree(inOrder1, preOrder);
        index++;
        root.right = createTree(inOrder2, preOrder);

        return root;
    }
    private static int linearSearch(int element, int arr[]){
        for(int index=0 ; index<arr.length ; index++){
            if(arr[index] == element)
                return index;
        }
        return -1;
    }
    private static void copy(int original[], int newArray[], int startIndex, int endIndex){
        int k=0;
        while (startIndex <= endIndex){
            newArray[k++] = original[startIndex++];
        }
    }
    private static void copy(int original[], int newArray[], int startIndex){
        copy(original, newArray, startIndex, original.length-1);
    }

    //To Find InOrder Successor
    public BinaryThreadedTree inOrderSuccessor(){
        return inOrderSuccessor(this);
    }
    public BinaryThreadedTree inOrderSuccessor(BinaryThreadedTree root){
        if(root.hasRightThread)
            return root.right;
        if(root.right == null)
            return null;

        root = root.right;
        while (!root.hasLeftThread){
            root = root.left;
        }

        return root;
    }

    //To Find InOrder Predecessor
    public BinaryThreadedTree inOrderPredecessor(){
        return inOrderPredecessor(this);
    }
    public BinaryThreadedTree inOrderPredecessor(BinaryThreadedTree root){
        if(root == null || root.left == null){
            return null;
        }
        if(root.hasLeftThread){
            return root.left;
        }

        root = root.left;
        while (!root.hasRightThread){
            root = root.right;
        }

        return root;
    }

    //Traversals
    public ArrayList<BinaryThreadedTree> inOrderSequence(BinaryThreadedTree root){
        if(root == null){
            return new ArrayList<>();
        }

        ArrayList<BinaryThreadedTree> leftList = inOrderSequence(root.left);
        leftList.add(root);
        leftList.addAll(inOrderSequence(root.right));
        return leftList;
    }

    public void inOrderTraversal(){
        inOrderTraversal(this);
    }
    private void inOrderTraversal(BinaryThreadedTree root){
        if(root == null){
            return;
        }

        inOrderTraversal(root.hasLeftThread ? null : root.left);
        System.out.print(root + " ");
        inOrderTraversal(root.hasRightThread ? null : root.right);
    }

    public void preOrderTraversal(){
        preOrderTraversal(this);
    }
    private void preOrderTraversal(BinaryThreadedTree root){
        if(root == null){
            return;
        }

        System.out.print(root + " ");
        preOrderTraversal(root.hasLeftThread ? null : root.left);
        preOrderTraversal(root.hasRightThread ? null : root.right);
    }

    public void postOrderTraversal(){
        postOrderTraversal(this);
    }
    private void postOrderTraversal(BinaryThreadedTree root){
        if(root == null){
            return;
        }

        postOrderTraversal(root.hasLeftThread ? null : root.left);
        postOrderTraversal(root.hasRightThread ? null : root.right);
        System.out.print(root + " ");
    }

    //Printing Methods
    @Override
    public String toString() {
        if(this == null)
            return "null";
        return ("{ " + data + " }");
    }

    public void print(){
        print(this);
    }
    private void print(BinaryThreadedTree root){
        if(root == null){
            return;
        }

        System.out.print(root.data + " : ");
        System.out.print(root.hasLeftThread ? "null " : root.left + " ");
        System.out.println(root.hasRightThread ? "null " : root.right + " ");
        print(root.hasLeftThread ? null : root.left);
        print(root.hasRightThread ? null : root.right);
    }

    //Getter Methods
    public int size(){
        return size;
    }
}
