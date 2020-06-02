import java.util.Scanner;

public class StringOperations_Index {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter Text : ");
        String text = in.nextLine();
        System.out.print("Enter String to be searched : ");
        String string = in.next();

        int index = stringSearch(text, string);
        if(index != -1) System.out.println(string + " exist at index : " + index + " in \"" + text + "\"");
        else System.out.println(string + " doesn't exist in " + text);
    }

    private static int stringSearch(String text, String string){
        for(int index1=0 ; index1<text.length()-string.length() ; index1++){
            if(text.charAt(index1) == string.charAt(0)){
                if(string.substring(1).equals(text.substring(index1+1, index1 + string.length())))
                    return index1;
            }
        }
        return -1;
    }
}
