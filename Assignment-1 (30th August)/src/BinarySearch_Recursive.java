import java.util.Scanner;

public class BinarySearch_Recursive {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Size : ");
        int size = in.nextInt();
        int array[] = new int[size];

        System.out.println("Enter array Elements : ");
        for(int index = 0 ; index<size ; index++){
            array[index] = in.nextInt();
        }

        System.out.print("Enter Element to search : ");
        int element = in.nextInt();

        int index = binarySearch(array, element, 0, array.length);
        if(index != -1) System.out.println(element + " exists at : " + index);
        else System.out.println(element + " doesn't exist");
    }

    private static int binarySearch(int array[], int element, int startIndex, int endIndex){
        if(array.length == 0) return -1;
        if(array.length == 1) return array[0] == element ? 0 : -1;
        if(startIndex >= endIndex-1) return -1;

        if(array[(startIndex+endIndex)/2] == element)
            return (startIndex+endIndex)/2;
        else if(array[(startIndex + endIndex)/2] < element)
            return binarySearch(array, element, (startIndex+endIndex)/2, endIndex);
        else
            return binarySearch(array, element, startIndex, (startIndex+endIndex)/2);
    }
}
