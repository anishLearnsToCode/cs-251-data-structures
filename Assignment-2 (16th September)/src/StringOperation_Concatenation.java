import java.util.Scanner;

public class StringOperation_Concatenation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String first, second;

        System.out.print("Enter first String : ");
        first = in.nextLine();
        System.out.print("Enter second string : ");
        second = in.nextLine();

        //Language Defined Operator
        String concatenatedString = first + second;
        System.out.println("Concatenated String : " + concatenatedString);

        //User-Defined Function
        char[] firstString = toChar(first);
        char[] secondString = toChar(second);
        char[] concatenated = concat(firstString, secondString);
        System.out.print("Concatenated String : " );
        print(concatenated);
    }

    private static String concat(String first, String second){
        String ans ="";
        for(int index=0 ; index<first.length() ; index++){
            ans = ans + first.charAt(index);
        }
        for(int index =0 ; index<second.length() ; index++){
            ans = ans + second.charAt(index);
        }
        return ans;
    }

    private static char[] concat(char[] first, char[] second){
        char[] ans = new char[first.length + second.length];
        for(int index=0 ; index<first.length ; index++){
            ans[index] = first[index];
        }
        for(int index=0 ; index<second.length ; index++){
            ans[index + first.length] = second[index];
        }
        return ans;
    }

    private static char[] toChar(String string){
        char[] value = new char[string.length()];
        for(int index=0 ; index<value.length ; index++){
            value[index] = string.charAt(index);
        }
        return value;
    }

    private static void print(char[] string){
        for(int index=0 ; index<string.length ; index++){
            System.out.print(string[index]);
        }
    }
}
