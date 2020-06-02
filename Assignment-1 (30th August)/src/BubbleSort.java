import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter array size : ");
        int size = in.nextInt();

        int array[] = new int[size];
        System.out.println("Enter Array elements : ");
        for(int index = 0 ; index<size ; index++){
            array[index] = in.nextInt();
        }

        bubbleSort(array);
        System.out.println("The sorted array is : ");
        print(array);
    }

    private static void bubbleSort(int array[]){
        for(int i=0 ; i<array.length-1 ; i++){
            for(int index=0 ; index< array.length-1-i ; index++){
                if(array[index] > array[index+1])
                    swap(index, index+1, array);
            }
        }
    }

    private static void swap(int index1, int index2, int array[]){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    private static void print(int array[]){
        for(int index = 0 ; index<array.length ; index++){
            System.out.print(array[index] + " ");
        }
    }
}
