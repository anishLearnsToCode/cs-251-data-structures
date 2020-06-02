import java.util.Scanner;

class Array{

    private static int arr[] = new int[100];
    private static int size = 0;
    private static final int MAX_SIZE = 100;
    private static final int MIN_SIZE = 0;

    public static boolean insert(int data, int position) {
        if(position == size)
            return insert(data);
        else if(position > size){
            System.out.println("Wrong Position");
            return false;
        }
        else if(size != MAX_SIZE){
            for(int i=size-1 ; i>=position ; i--){
                arr[i+1] = arr[i];
            }
            arr[position] = data;
            size++;
            return true;
        } else {
            System.out.println("Array Space not enough");
        }
        return false;
    }

    public static boolean insert(int data){
        if(size != MAX_SIZE) {
            arr[size] = data;
            size++;
            return true;
        }else {
            System.out.println("Array Full");
        }
        return false;
    }

    public static boolean delete(){
        if(size != MIN_SIZE){
            size--;
            return true;
        }
        return false;
    }

    public static void print(){
        for(int i=0 ; i<size ; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static int getSize(){
        return size;
    }

    public static void bubbleSort(){
        int i, j;

        for(i=0 ; i<size-1 ; i++){
            for(j=0 ; j<size-1-i ; j++){
                if(arr[j+1] < arr[j]){
                    swap(j, j+1, arr);
                }
            }
        }
    }

    private static void swap(int index1, int index2, int arr[]) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void sort(){
        arr = mergeSort(arr);
    }

    private static int[] mergeSort(int arr[]){
        if(arr.length == 1 || arr.length == 0){
            return  arr;
        }

        int smallArr1[] = new int[arr.length/2];
        int smallArr2[] = new int[arr.length - smallArr1.length];
        int i;

        for(i=0 ; i<smallArr1.length ; smallArr1[i] = arr[i], i++);
        for( ; i<arr.length ; smallArr2[i - smallArr1.length] = arr[i], i++);

        int ans1[] = mergeSort(smallArr1);
        int ans2[] = mergeSort(smallArr2);

        return merge(ans1, ans2);
    }

    private static int[] merge(int arr1[], int arr2[]){
        int i, j, k, t;
        int ans[] = new int[arr1.length + arr2.length];

        for(i=0, j=0, k=0 ; i<=arr1.length & j<=arr2.length ; ) {
            if(i == arr1.length){
                for(t=0;  t<arr2.length - j ; ans[k++] = arr2[j+t], t++);
                break;
            } else if(j == arr2.length) {
                for(t=0 ; t<arr1.length - i ; ans[k++] = arr1[i+t], t++);
                break;
            }

            if(arr1[i] <= arr2[j]){
                ans[k++] = arr1[i];
                i++;
            } else {
                ans[k++] = arr2[j];
                j++;
            }
        }
        return ans;
    }
}

public class ArrayProgram {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;

        System.out.print("Enter size : ");
        int size = in.nextInt();
        for(int index =0 ; index<size ; index++){
            int data = in.nextInt();
            Array.insert(data);
        }

        do {
            System.out.println("\n\nSelect An Option :- ");
            System.out.println("1) Add Element");
            System.out.println("2) Remove Element ");
            System.out.println("3) Print Array");
            System.out.println("4) Size Of Array");
            System.out.println("5) Bubble Sort");
            System.out.println("6) Merge Sort ");
            System.out.println("7) Exit");
            n = in.nextInt();

            if(n == 1){
                System.out.print("Enter Data : ");
                int data = in.nextInt();
                System.out.print("Enter Position : ");
                int position = in.nextInt();
                Array.insert(data, position);
            } else if(n == 2){
                Array.delete();
            } else if(n == 3){
                Array.print();
            } else if(n == 4){
                System.out.println(Array.getSize());
            } else if(n == 5){
                Array.bubbleSort();
            } else if(n == 7){
                Array.sort();
            }

        }while (n != 6);
    }
}
