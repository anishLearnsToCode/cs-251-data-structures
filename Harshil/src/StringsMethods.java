import java.util.Scanner;

public class StringsMethods {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        String string = in.next();
        char[] charString = convertTo(string);
        String string2 = in.next();
        char[] charString2 = convertTo(string2);

        char[] ans = concatenate(charString, charString2);
        System.out.println(ans);
    }

    private static char[] subString(char[] string ,int startIndex, int endIndex){
        char[] ans = new char[endIndex - startIndex];
        for(int index=startIndex; index<endIndex ; index++){
            ans[index - startIndex] = string[index];
        }
        return ans;
    }

    private static char[] convertTo(String string){
        char[] ans = new char[string.length()];
        for(int index=0 ; index<string.length() ; index++){
            ans[index] = string.charAt(index);
        }
        return ans;
    }

    private static char[] concatenate(char[] string1, char[] string2){
        char[] ans = new char[string1.length + string2.length];
        //Copy First
        for(int index=0 ; index<string1.length ; index++){
            ans[index] = string1[index];
        }
        //Copy Second
        for(int index=0 ; index<string2.length ; index++){
            ans[index + string1.length] = string2[index];
        }
        return ans;
    }

    private static int indexOf(String mainString, String subString){
        for(int index=0 ; index<mainString.length() ; index++){
            if(subString.charAt(0) == mainString.charAt(index)){
                boolean flag = true;
                for(int subIndex=1 ; subIndex<subString.length() ; subIndex++){
                    if(subString.charAt(subIndex) != mainString.charAt(index + subIndex)){
                        flag = false;
                        break;
                    }
                }

                if(flag)
                    return index;
            }
        }

        return -1;
    }
}
