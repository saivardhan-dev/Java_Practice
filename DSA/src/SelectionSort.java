
// Selection sort (n-1)n/2+(n-1) time complexity is O(n^2).
// But to reduce the number of swaps, we use Selection sort algorithm
//Comparisons - 28
//Swaps - 3


public class SelectionSort {
    public static void selectionSort1(int[] arr, int n){          //n=8
        for(int i=0;i<n-1;i++){            //i=0
            int minIndex=i;                //minIndex=0
            for(int j=i+1;j<n;j++){        //j=1 to 8
                if(arr[j]<arr[minIndex]){  //arr[1]<arr[0] (23<4), arr[4]<arr[0] (2<4)
                    minIndex=j;            //minIndex=4
                }
            }
            int temp=arr[minIndex];        // temp=arr[4]-->(2)
            arr[minIndex]=arr[i];          //arr[4]=arr[0]-->(23)
            arr[i]=temp;                   //arr[0]=2
        }
    }

    public static void selectionSort2(int[] arr, int n){
        int i=0;
        while(i<n-1){
            int minIndex=i;
            int j=i+1;
            while(j<n){
                if(arr[j]<arr[minIndex]){
                    minIndex=j;
                }
                j++;
            }
            int temp=arr[minIndex];
            arr[minIndex]=arr[i];
            arr[i]=temp;
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

        selectionSort1(numbers, n);
        System.out.println("After Sorting using for: ");
        for(int nums:numbers){
            System.out.print(" " + nums);
        }

        System.out.println();
        selectionSort2(numbers, n);
        System.out.println("After Sorting using while: ");
        for(int nums:numbers){
            System.out.print(" " + nums);
        }
    }
}
