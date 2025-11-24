
//In bubble sort, we have n(n-1)/2 operations. and the time complexity is O(n^2).
//Comparisons - 28
//Swaps - 14


class BubbleSort {
    public static void bubbleSort1(int[] arr, int n){           //n=8
        for(int i =0 ; i<n-1 ; i++){         //i=0,
            for(int j=0 ; j<n-i-1 ; j++){    //j=0
                if(arr[j]>arr[j+1]) {        //23>4(true)
                    int temp=arr[j];         //temp=23
                    arr[j]=arr[j+1];         //arr[0]=4
                    arr[j+1]=temp;           //arr[1]=23
                }
            }
        }
    }
    public static void bubbleSort2(int[] arr, int n){
        int i=0;
        while(i<n-1){
            int j=0;
            while(j<n-i-1){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                } j++;
            }
            i++;;
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

        bubbleSort1(numbers, n);
        System.out.println("After Sorting using for: ");
        for(int nums:numbers){
            System.out.print(" " + nums);
        }

        System.out.println();
        bubbleSort2(numbers, n);
        System.out.println("After Sorting using while: ");
        for(int nums:numbers){
            System.out.print(" " + nums);
        }
    }
}
