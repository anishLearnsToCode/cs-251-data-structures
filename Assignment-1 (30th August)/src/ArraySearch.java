import java.util.Scanner;

public class ArraySearch {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int size;

        System.out.print("Enter Size : ");
        size = s.nextInt();

        System.out.println("Enter Array Elements : ");
        int arr[] = new int[size];
        input(arr);

        int element;
        System.out.print("Enter element for searching : ");
        element = s.nextInt();

        int ans = linearSearch(arr, element);
        System.out.println(ans);
    }

    private static int linearSearch(int arr[], int element){
        for(int index =0 ; index<arr.length ; index++){
            if(arr[index] == element)
                return index;
        }
        return -1;
    }

    private static void input(int arr[]){
        Scanner s = new Scanner(System.in);
        for(int index = 0 ; index<arr.length ; index++){
            arr[index] = s.nextInt();
        }
    }
}