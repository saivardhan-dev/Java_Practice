public class QuickSort {
    static int partition(int arr[], int low, int high) {
        int pivot = arr[high];                           //pivot=84
        int i = low-1;                                   //low =0, i=-1
        for (int j = low; j < high; j++) {               //j=0 to 7,
            if (arr[j] <= pivot) {                       //arr[0](10)<=84
                i++;                                     //i=0
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return (i + 1);
    }

    static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static void main(String[] args){
        int[] numbers={10,23,4,99,43,9,2,84};
        int n=numbers.length;
        System.out.println("Before Sorting: ");
        for(int nums:numbers){
            System.out.print(" " + nums);
        }
        System.out.println();
        QuickSort.quickSort(numbers, 0, n-1);
        System.out.println("After Sorting: ");
        for(int nums:numbers){
            System.out.print(" " + nums);
        }
    }
}
