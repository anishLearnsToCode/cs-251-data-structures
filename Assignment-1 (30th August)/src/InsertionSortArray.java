import java.util.Scanner;

public class InsertionSortArray {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter size of array : ");
        int size = in.nextInt();
        int arr[] = new int[size];
        input(arr);

        insertionSort(arr);
        print(arr);
    }

    private static void input(int arr[]){
        for(int index=0 ; index<arr.length ; index++){
            arr[index] = in.nextInt();
        }
    }
    private static void print(int arr[]){
        for(int val : arr){
            System.out.print(val + " ");
        }
    }

    private static void insertionSort(int arr[]){
        for(int index=1 ; index<arr.length ; index++){
            insertAt(arr, index);
        }
    }
    private static void insertAt(int arr[], int index){
        for(int startIndex=0 ; startIndex <index ; startIndex++){
            if(arr[index] < arr[startIndex]){
                int val = arr[index];
                cycle(arr, startIndex, index);
                arr[startIndex] = val;
                break;
            }
        }
    }
    private static void cycle(int arr[], int startIndex, int endIndex){
        for(int index=endIndex ; index > startIndex ; index--){
            arr[index] = arr[index-1];
        }
    }
}
