package sort;

import java.util.Arrays;

/**
 * 选择排序
 *
 * @author  cyf
 */
public class Selection {
    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 6, 1};
        //记录最小值
        int min = 0;
        //记录最小值下标
        int minIndex = 0;
        //是否选择到最小值
        boolean change= false;

        for (int i = 0; i < arr.length; i++) {
            //假设第一趟排序第一个最小
            min = arr[i];
            change= false;
            //不断与后面一个元素比较，找出最小值
            for (int j = i+1; j < arr.length; j++) {
                if (j < arr.length && min > arr[j]) {
                    minIndex = j;
                    min = arr[j];
                    change = true;
                }
            }
            if(change) {
                int tmp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = tmp;
                System.out.println("change:"+Arrays.toString(arr));
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
