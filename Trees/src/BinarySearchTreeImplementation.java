import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

//Binary Search Tree Class
class BinarySearchTree{
    private Integer data;
    private BinarySearchTree left, right;
    private int size=0;
    private int height=0;

    //Constructors
    public BinarySearchTree(){
        left = right = null;
        data = null;
    }
    private BinarySearchTree(int data){
        this.data = data;
        left = right = null;
        size = 1;
        height = 1;
    }

    //Adding Data and children Methods
    private void assign(int data){
        if(this.data == null) size++;
        this.data = data;
    }

    public void add(int data){
        add(this, data);
    }
    private void add(BinarySearchTree root, int data){
        if(root.data == null){
            root.assign(data);
            return;
        }

        root.size++;

        if(data > root.data){
            if(root.right == null){
                root.right = new BinarySearchTree(data);
                root.height = 1 + Math.max(root.left == null ? 0 : root.left.height, root.right.height);
                return;
            }
            add(root.right, data);
            return;
        }

        if(root.left == null) {
            root.left = new BinarySearchTree(data);
            root.height = 1 + Math.max(root.left.height , root.right == null ? 0 : root.right.height);
            return;
        }
        add(root.left, data);
        root.height = 1 + Math.max(root.left == null ? 0 : root.left.height, root.right == null ? 0 : root.right.height);
    }

    //Accessing Data and Children
    public Integer data() {
        return data;
    }

    public BinarySearchTree left() {
        return left;
    }

    public BinarySearchTree right() {
        return right;
    }

    //Binary Search Tree Properties
    public int size(){
        return size;
    }
    public int height(){
        return height;
    }

    //Printing Methods
    public void preOrderTraversal(){
        preOrderTraversal(this);
        System.out.println();
    }
    private void preOrderTraversal(BinarySearchTree root){
        if(root == null){
            return;
        }

        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public void inOrderTraversal(){
        inOrderTraversal(this);
        System.out.println();
    }
    private void inOrderTraversal(BinarySearchTree root){
        if(root == null){
            return;
        }

        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }

    public void postOrderTraversal(){
        postOrderTraversal(this);
        System.out.println();
    }
    private void postOrderTraversal(BinarySearchTree root){
        if(root == null){
            return;
        }

        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + " ");
    }

    public void print(){
        print(this);
        System.out.println();
    }
    private void print(BinarySearchTree root){
        if(root == null){
            return;
        }

        System.out.println(root.data + " : " + (root.left == null ? "null" : root.left.data) + " , "
                + (root.right == null ? "null" : root.right.data) );
        print(root.left);
        print(root.right);
    }

    public ArrayList<ArrayList<BinarySearchTree>> levelOrder(){
        return levelOrder(this);
    }
    private ArrayList<ArrayList<BinarySearchTree>> levelOrder(BinarySearchTree root){
        LinkedList<BinarySearchTree> levelList = levelOrderTraversal(root);
        ArrayList<ArrayList<BinarySearchTree>> levels = new ArrayList<>();
        ArrayList<BinarySearchTree> level = new ArrayList<>();

        while (!levelList.isEmpty()){
            BinarySearchTree node = levelList.pop();

            if(node == null){
                levels.add(level);
                level = new ArrayList<>();
            }
            else {
                level.add(node);
            }
        }

        return levels;
    }
    private LinkedList<BinarySearchTree> levelOrderTraversal(BinarySearchTree root){
        LinkedList<BinarySearchTree> levelOrder = new LinkedList<>();
        LinkedList<BinarySearchTree> ans = new LinkedList<>();
        levelOrder.add(root);
        levelOrder.add(null);

        while (!levelOrder.isEmpty()){
            BinarySearchTree node = levelOrder.pop();
            ans.add(node);

            if(node == null){
                if(levelOrder.size() != 0) levelOrder.add(null);
            } else {
                if(node.left != null) levelOrder.add(node.left);
                if(node.right != null) levelOrder.add(node.right);
            }
        }
        return ans;
    }
}


//Driver Class
public class BinarySearchTreeImplementation {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(5);
        tree.add(4);
        tree.add(9);
        tree.add(3);
        tree.add(10);
        tree.add(11);
        tree.add(8);
        tree.print();

        System.out.print("Inorder Traversal : "); tree.inOrderTraversal();
        System.out.print("PreOrder Traversal : "); tree.preOrderTraversal();
        System.out.print("PostOrder Traversal : "); tree.postOrderTraversal();
    }
}
