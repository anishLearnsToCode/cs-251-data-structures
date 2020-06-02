import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter size of array : ");
        int size = in.nextInt();
        int array[] = new int[size];

        System.out.println("Enter sorted Array : ");
        for(int index =0 ; index<size ; index++){
            array[index] = in.nextInt();
        }

        System.out.print("Enter element to be searched : ");
        int element = in.nextInt();

        int index = binarySearch(array, element);
        if(index != -1) System.out.println(element + " exists at : " + index);
        else System.out.println(element + " doesn't exist");
    }

    private static int binarySearch(int array[], int element){
        if(array.length == 0)
            return -1;

        if(array.length == 1)
            return array[0] == element ? 0 : -1;

        int tail=0, head=array.length;
        while (tail<head-1){
            if(array[(tail+head)/2] == element)
                return (tail+head)/2;
            else if(array[(tail+head)/2] < element)
                tail = (tail+head)/2;
            else
                head = (tail+head)/2;
        }
        return -1;
    }
}
