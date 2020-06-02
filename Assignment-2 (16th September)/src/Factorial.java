import java.util.Scanner;

public class Factorial {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number : ");
        int number = in.nextInt();

        long ans = factorial(number);
        System.out.println(number + "! = " + ans);
    }

    private static long factorial(int number){
        if(number == 0)
            return 1;

        return number * factorial(number-1);
    }
}
