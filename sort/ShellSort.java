package sort;

import java.util.Arrays;

/**
 * 希尔排序
 * @author cyf
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 6, 5, 3};
        int tmp =0;
        for(int interval = arr.length/2;interval>0;interval = interval /2){
            for(int i=0;i<arr.length;i+=interval){
                int cur = i;
                while(cur>0){
                    if(arr[cur]<arr[cur-interval]){
                        tmp=arr[cur-interval];
                        arr[cur-interval] = arr[cur];
                        arr[cur] = tmp;
                    }
                    cur -=interval;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
