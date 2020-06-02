import java.util.ArrayList;
import java.util.Scanner;

public class StringOperations_Replacement {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String mainString, replaceString, newString;

        System.out.print("Enter String : ");
        mainString = in.nextLine();
        System.out.print("Enter String to replace : ");
        replaceString = in.next();
        System.out.print("Enter String to replace it with : ");
        newString = in.next();

        mainString = replace(mainString, replaceString, newString);
        System.out.println("New String : " + mainString);
    }

    private static String replace(String main, String replace, String newString){
        String ans = "";
        ArrayList<Integer> indexList = instancesOf(main, replace);
        for(int i=0 ; i<indexList.size() ; i++){
            ans = ans + newString + main.substring(indexList.get(i) + replace.length(),
                    i == indexList.size()-1 ? main.length() : indexList.get(i+1));
        }
        return ans;
    }

    private static ArrayList<Integer> instancesOf(String main, String replace){
        ArrayList<Integer> indexList = new ArrayList<>();
        for(int index =0 ; index<main.length() ; index++){
            if(main.charAt(index) == replace.charAt(0)){
                int factor = (index + replace.length() > main.length() ? (index + replace.length() - main.length()) : 0);
                if(main.substring(index, index + replace.length() - factor).equals(replace))
                    indexList.add(index);
            }
        }
        return indexList;
    }
}
