import java.util.Scanner;

public class QuickSort_Array {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter array size : ");
        int size = in.nextInt();
        int arr[] = new int[size];
        input(arr);

        quickSort(arr);
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

    private static void quickSort(int arr[]){
        quickSort(arr, 0, arr.length-1);
    }
    private static void quickSort(int arr[], int startIndex, int endIndex){
        if(startIndex < endIndex){
            int pivot = partition(arr, startIndex, endIndex);
            quickSort(arr, startIndex, pivot-1);
            quickSort(arr, pivot+1, endIndex);
        }
    }

    private static int partition(int arr[], int start, int end){
        for(int index=end ; index > start ; ){
            if(arr[index] < arr[start]){
                swap(arr, start+1, index);
                swap(arr, start, start+1);
                start++;
            } else index--;
        }
        return start;
    }

    private static void swap(int arr[], int index1, int index2){
        int val = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = val;
    }
}
