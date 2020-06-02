import java.util.ArrayList;
import java.util.LinkedList;

public class Tree {
    //Tree Node Properties
    private ArrayList<Tree> children;
    private int data;

    //Tree Properties
    private int height;                      private boolean isHeightUpdated = false;
    private int diameter;                    private boolean isDiameterUpdated = false;
    private boolean isBST;                   private boolean isBSTUpdated = false;

    //Constructors
    Tree(){
        children = new ArrayList<>();
        data = 0;
    }
    Tree(int data){
        children = new ArrayList<>();
        this.data = data;
    }

    //Data and Children Assignment and Getting
    public boolean assign(int data){
        this.data = data;
        return true;
    }
    public int getData(){ return data; }
    public Tree getChild(int index){
        return children.get(index);
    }
    public void addChild(Tree child){
        children.add(child);
        isHeightUpdated = false;
    }
    public int childrenNumber(){
        return children.size();
    }


    //Printing Methods
    public void print(){
        printTree(this);
    }
    private static void printTree (Tree root) {
        System.out.print(root.data + " : ");
        for(int i=0 ; i<root.children.size() ; System.out.print(root.children.get(i).data + " "), i++);
        System.out.print(root.children.size() == 0 ? "Null" : "");

        System.out.println("");
        for(int i=0 ; i<root.children.size() ; printTree(root.children.get(i)), i++);
    }


    //Tree Properties Methods
    public int height(){                                            //Tree Height
        if(isHeightUpdated) return height;
        this.height = height(this);
        isHeightUpdated = true;
        return height;
    }
    private int height(Tree root){
        int height = 0;
        for(int index=0 ; index<root.children.size() ; index++){
            height = Math.max(height(children.get(index)), height);
        }
        return 1 + height;
    }


    private class TreeProperties{
        public int diameter = 0;
        public int height = 0;
        TreeProperties(){}
        TreeProperties(int diameter, int height){
            this.diameter = diameter;
            this.height = height;
        }
    }
    public int diameter(){                                          //Tree Diameter
        if(isDiameterUpdated) return diameter;
        diameter = diameter(this).diameter;
        isDiameterUpdated = true;
        return diameter;
    }
    private TreeProperties diameter(Tree root){
        if(root == null){
            return new TreeProperties(0, 0);
        }

        int height=0, diameter=0, index=0;
        for(Tree child : root.children){
            TreeProperties properties = diameter(child);
            diameter = Math.max(diameter, properties.diameter);
            if(index++ > 0){
                diameter = (height + properties.height + 1 > diameter ? height + properties.height + 1 : diameter);
                height = 1 + Math.max(height, properties.height);
            } else {
                diameter = Math.max(diameter, height + 1);
            }
        }

        return new TreeProperties(diameter, height);
    }


    public ArrayList<ArrayList<Tree>> levelOrderTraversal(){        //Level Order Traversal
        return levelOrderTraversal(this);
    }
    private ArrayList<ArrayList<Tree>> levelOrderTraversal(Tree root){
        LinkedList<Tree> levelOrder = levelOrder(root);
        ArrayList<ArrayList<Tree>> ans = new ArrayList<>();
        ArrayList<Tree> level = new ArrayList<>();

        while (!levelOrder.isEmpty()){
            Tree tree = levelOrder.pop();
            if(tree != null){
                level.add(tree);
            }
            else {
                ans.add(level);
                level = new ArrayList<>();
            }
        }

        return ans;
    }
    private LinkedList<Tree> levelOrder(Tree root){
        LinkedList<Tree> linkedList = new LinkedList<>();
        LinkedList<Tree> ans = new LinkedList<>();
        linkedList.add(root);
        linkedList.add(null);

        while (!linkedList.isEmpty()){
            Tree tree = linkedList.pop();
            ans.add(tree);

            if(tree != null)
                linkedList.addAll(tree.children);
            else if(linkedList.size() > 0) linkedList.add(null);
        }
        return ans;
    }


    public static Tree createTreeInorderAndPreOrder(int inOrder[], int preOrder[]){
        return createTreeInorderAndPreOrder(inOrder, preOrder, 0, 0, inOrder.length-1);
    }
    private static Tree createTreeInorderAndPreOrder(int inOrder[], int preOrder[], int index, int startIndex, int endIndex){
        if(index == preOrder.length){
            return null;
        }

        int searchIndex = linearSearch(inOrder, preOrder[index], startIndex, endIndex);
        Tree node = new Tree(inOrder[searchIndex]);
        node.addChild(createTreeInorderAndPreOrder(inOrder, preOrder, index+1, startIndex, searchIndex-1));
        node.addChild(createTreeInorderAndPreOrder(inOrder, preOrder, index+2, searchIndex+1, endIndex));

        return node;
    }
    private static int linearSearch(int array[], int element, int startIndex, int endIndex){
        while (startIndex <= endIndex){
            if(array[startIndex++] == element)
                return startIndex-1;
        }
        return -1;
    }
}
