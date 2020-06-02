import java.util.Scanner;

public class FibonacciSeries {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter n : ");
        int n = in.nextInt();

        long ans = fibonacci(n);
        System.out.println("The "+n+"th fibonacci term is : " + ans);
    }

    private static long fibonacci(int n){
        if(n == 0 || n == 1){
            return 1;
        }

        return fibonacci(n-1) + fibonacci(n-2);
    }
}
