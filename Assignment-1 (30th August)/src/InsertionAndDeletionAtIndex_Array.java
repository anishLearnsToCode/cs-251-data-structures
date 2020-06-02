import java.util.Scanner;

public class InsertionAndDeletionAtIndex_Array {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws ArrayFullException {
        int arr[] = new int[20];
        int choice, size=0;
        final int MAX_SIZE = 20;

        do {
            System.out.println("Select any of the following options :");
            System.out.println("1) Insert At");
            System.out.println("2) Delete At  ");
            System.out.println("3) Print Array");
            System.out.print("4) Exit : ");
                choice = in.nextInt();

            switch (choice){
                case 1 :
                    if(size == MAX_SIZE){                           //Checking To See If Array Is Full
                        throw new ArrayFullException(size);
                    }

                    System.out.print("Enter index : ");
                    int index=in.nextInt();
                    if(index > size){                               //Checking to see if Index is Valid
                        throw new ArrayIndexOutOfBoundsException(index);
                    }

                    System.out.print("Enter Element : ");
                    int element = in.nextInt();

                    //Shifting elements forward
                    for(int tempIndex=size ; tempIndex>index ; tempIndex--){
                           arr[tempIndex] = arr[tempIndex-1];
                    }
                    arr[index] = element;
                    size ++;
                    break;

                case 2 :
                    System.out.print("Enter Index : ");
                    index = in.nextInt();
                    if(index < 0){
                        throw new ArrayIndexOutOfBoundsException(index);
                    }

                    //Shifting Elements Back and decreasing size by one
                    for(int tempIndex = index ; tempIndex<size ; tempIndex++){
                        arr[tempIndex] = arr[tempIndex + 1];
                    }
                    arr[size--] = 0;
                    break;

                case 3 :
                    print(arr, size);
                    break;

                default:
                    if(choice != 4) System.out.println("Incorrect Choice");
            }

        }while (choice < 4);
    }

    private static void print(int arr[], int size){
        for(int index=0 ; index<size ; index++){
            System.out.print(arr[index] + " ");
        }
        System.out.println();
    }
}

class ArrayFullException extends Exception{
    ArrayFullException(){}
    ArrayFullException(int size){
        System.out.println("Array Full Exception : " + size);
    }
}