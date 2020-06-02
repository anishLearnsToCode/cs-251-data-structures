import java.util.Scanner;

public class ArraySum {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int size;

        System.out.print("Enter Size of Array : ");
        size = s.nextInt();

        int arr[] = new int[size];
        System.out.println("Enter Array elements : ");
        input(arr);

        int ans = arrSum(arr);
        System.out.println(ans);
    }

    private static void input(int arr[]){
        Scanner s = new Scanner(System.in);
        for(int index = 0 ; index<arr.length ; index++){
            arr[index] = s.nextInt();
        }
    }

    private static int arrSum(int arr[]){
        int index, sum;
        for(index=0, sum=0 ; index<arr.length ; index++){
            sum += arr[index];
        }
        return sum;
    }
}
