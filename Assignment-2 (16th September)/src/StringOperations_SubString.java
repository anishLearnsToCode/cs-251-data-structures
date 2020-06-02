import java.util.Scanner;

public class StringOperations_SubString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter String Size : ");
        int size = in.nextInt();
        char string[] = new char[size];

        System.out.print("Enter String : ");
        String temp = in.next();
        for(int index=0 ; index<string.length ; index++){
            string[index] = temp.charAt(index);
        }

        //Substring Function, First Kind
        System.out.print("Enter start Index : ");
        int startIndex = in.nextInt();
        System.out.print("Enter End Index : ");
        int endIndex = in.nextInt();

        char ans[] = subString(string, startIndex, endIndex);
        System.out.print("SubString (" + startIndex + "," + endIndex + ") : ");
        print(ans);


        //Substring Function, Second Kind
        System.out.print("\n\nEnter start Index : ");
        startIndex = in.nextInt();

        ans = subString(string, startIndex);
        System.out.print("SubString (" + startIndex + ") : ") ;
        print(ans);
    }

    private static char[] subString(char[] string, int startIndex, int endIndex){
        char ans[] = new char[endIndex - startIndex];
        for(int index=startIndex ; index<endIndex ; index++){
            ans[index-startIndex] = string[index];
        }
        return ans;
    }

    private static char[] subString(char[] string, int startIndex){
        return subString(string, startIndex, string.length);
    }

    private static void print(char[] string){
        for(int index=0 ; index<string.length ; index++){
            System.out.print(string[index]);
        }
    }
}
