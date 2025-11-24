public class MergeSort {
    static void merge(int arr[], int left, int mid, int right) {
        int n1=mid-left+1;
        int n2=right-mid;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for(int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }
        for(int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }
        int i=0, j=0, k=left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    static void mergeSort(int arr[], int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }
    public static void main(String[] args){
        int[] numbers={10,23,4,99,43,9,2,84};
        int n = numbers.length;
        System.out.println("Before Sorting: ");
        for(int nums : numbers){
            System.out.print(" " + nums);
        }
        System.out.println();
        MergeSort.mergeSort(numbers, 0, n-1);
        System.out.println("After Sorting: ");
        for(int nums : numbers){
            System.out.print(" " + nums);
        }
    }
}