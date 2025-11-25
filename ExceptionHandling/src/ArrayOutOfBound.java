//Access an invalid index and handle the exception.

import java.util.Arrays;

public class ArrayOutOfBound {
    public static void main(String[] args){
        try {
            int[] arr = {1, 2, 3, 4, 5};
            System.out.println(arr[5]);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Error=" + e);
        }
    }
}
