import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter size of Array : ");
        int size = in.nextInt();
        int array[] = new int[size];
        for(int index =0 ; index<size ; index++){
            array[index] = in.nextInt();
        }
        System.out.print("Enter element to be searched : ");
        int element = in.nextInt();

        int index = linearSearch(array, element);
        if(index != -1) System.out.println("The element exists at index : " + index);
        else System.out.println("Element not present");
    }

    private static int linearSearch(int array[], int element){
        for(int index =0 ; index<array.length ; index++){
            if(array[index] == element)
                return index;
        }
        return -1;
    }
}
