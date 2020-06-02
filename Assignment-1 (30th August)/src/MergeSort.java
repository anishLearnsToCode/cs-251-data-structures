import java.util.Scanner;

public class MergeSort {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter the size of array : ");
        int size = in.nextInt();
        int arr[] = new int[size];
        input(arr);

        arr = mergeSort(arr);
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

    private static int[] mergeSort(int arr[]){
        if(arr.length <= 1){
            return arr;
        }

        int smallArray1[] = new int[arr.length/2];
        int smallArray2[] = new int[arr.length - smallArray1.length];
        int index=0;
        while (index < smallArray1.length){
            smallArray1[index] = arr[index++];
        }
        while (index < arr.length){
            smallArray2[index - smallArray1.length] = arr[index++];
        }

        smallArray1 = mergeSort(smallArray1);
        smallArray2 = mergeSort(smallArray2);

        return merge(smallArray1, smallArray2);
    }

    private static int[] merge(int arr1[], int arr2[]){
        int ans[] = new int[arr1.length + arr2.length], i=0, j=0, k=0;

        while ( i<arr1.length && j<arr2.length ){
            if(arr1[i] <= arr2[j]){
                ans[k++] = arr1[i++];
            }
            else ans[k++] = arr2[j++];
        }

        while (i < arr1.length){
            ans[k++] = arr1[i++];
        }
        while (j < arr2.length){
            ans[k++] = arr2[j++];
        }

        return ans;
    }
}
