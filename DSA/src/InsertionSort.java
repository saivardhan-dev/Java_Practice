
//Comparisons - 18
//Swaps - 14

public class InsertionSort {
    public static void insertionSort1(int[] arr, int n){        //n=8
        for(int i = 1; i < n; i++) {       //i=1 t 8
            for(int j = i; j > 0; j--) {   //j=1
                if(arr[j] < arr[j-1]) {    //arr[1] < arr[0] (4<23)
                    int temp=arr[j];       //temp=arr[1], temp=4
                    arr[j]=arr[j-1];       //arr[1]=arr[0], arr[1]=4
                    arr[j-1]=temp;         //arr[0]=4
                }
            }
        }
    }
    public static void insertionSort2(int[] arr, int n){
        int i=0;
        while(i<n){
            int j=i;
            while(j > 0){
                if(arr[j] < arr[j-1]) {
                    int temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                }
                j--;
            }
            i++;
        }
    }

    public static void main(String[] args) {
        int[] numbers={23,4,65,33,2,68,90,10};
        int n=numbers.length;
        System.out.println("Before Sorting: ");
        for(int nums : numbers){
            System.out.print(" " + nums);
        }
        System.out.println();

        insertionSort1(numbers, n);
        System.out.println("After Sorting using for: ");
        for(int nums:numbers){
            System.out.print(" " + nums);
        }

        System.out.println();
        insertionSort2(numbers, n);
        System.out.println("After Sorting using while: ");
        for(int nums:numbers){
            System.out.print(" " + nums);
        }
    }
}