package sort;

import java.util.Arrays;

/**
 *  插入排序
 * @author  cyf
 */
public class Insert {
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 6, 1};
        int insertValue = 0;
        int insertIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            insertValue = arr[i];
            insertIndex = i;
            while (insertIndex >0 && insertValue < arr[insertIndex-1]) {
                arr[insertIndex] = arr[insertIndex-1];
                arr[insertIndex-1] = insertValue;
                insertIndex--;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
