import java.util.Scanner;

class StackIndexOutOfBoundsException extends Exception {
    StackIndexOutOfBoundsException(){}
    StackIndexOutOfBoundsException(int index){
        System.out.println("StackIndexOutOfBoundsException : " + index);
    }
}

class StackUnderFlowException extends Exception{
    StackUnderFlowException(){
        System.out.println("StackUnderFlowException");
    }
}

class StackOverflowException extends Exception{
    StackOverflowException(){}
    StackOverflowException(int size){
        System.out.println("StackOverflowError : " + size);
    }
}

class Stack{
    private int array[];
    private int size;
    private int MAX_SIZE;
    private final double LOAD_FACTOR = 0.8;
    private final int MAX_STACKFRAME_SIZE = 200;

    //Constructors
    Stack(){
        array = new int[10];
        MAX_SIZE = 10;
    }
    Stack(int stackSize){
        array = new int[stackSize];
        MAX_SIZE = stackSize;
    }
    Stack(int arr[]) throws StackOverflowException{
        array = new int[arr.length + 10];
        MAX_SIZE = array.length;
        for(int index=0 ; index<arr.length ; index++){
            push(arr[index]);
        }
    }


    //Methods
    public void push(int data) throws StackOverflowException{
        array[size] = data;
        size++;

        if((double)size/MAX_SIZE > LOAD_FACTOR)
            grow();
        if(size > MAX_STACKFRAME_SIZE)
            throw new StackOverflowException(size);
    }

    private void grow(){
        //Increases Stack Size - Doubles the array
        //Keeps load factor constant

        int temp[] = new int[2*array.length];
        for(int index=0 ; index<array.length ; index++){
            temp[index] = array[index];
        }
        MAX_SIZE = 2 * MAX_SIZE;
        array = temp;
    }

    public int pop() throws StackUnderFlowException{
        if(size == 0)
            throw new StackUnderFlowException();
        size--;
        return array[size];
    }

    public int peek() throws StackUnderFlowException{
        if(size == 0)
            throw new StackUnderFlowException();
        return array[size-1];
    }

    public int elementAt(int index) throws StackIndexOutOfBoundsException{
        if(index >= size)
            throw new StackIndexOutOfBoundsException(index);

        return array[index];
    }

    public void stackFrame() throws StackUnderFlowException{
        for(int index=0 ; index<size ; index++){
            System.out.print(array[index] + " ");
        }
        if(size == 0)
            throw new StackUnderFlowException();
    }
}

class StackImplementation{
    public static void main(String[] args) throws StackOverflowException, StackUnderFlowException, StackIndexOutOfBoundsException {
        Scanner in = new Scanner(System.in);
        Stack stack = new Stack();
        int n;

        do {
            System.out.println("\nSelect any of he following options : ");
            System.out.println("1) Push");
            System.out.println("2) Peek");
            System.out.println("3) Pop");
            System.out.println("4) Print complete Stack");
            System.out.println("5) Element At ");
            System.out.println("6) Exit");
            n = in.nextInt();

            if(n == 1){
                System.out.print("Enter Data : ");
                int data = in.nextInt();
                stack.push(data);
            }else if(n == 2){
                System.out.println(stack.peek());
            } else if(n ==3){
                System.out.println(stack.pop());
            } else if(n == 4){
                stack.stackFrame();
            } else if(n == 5){
                System.out.print("Enter index : ");
                int index = in.nextInt();
                int data = stack.elementAt(index);
                System.out.println(data);
            }
        }while (n != 6);
    }
}