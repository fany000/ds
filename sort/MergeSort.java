package sort;

import java.util.Arrays;

/**
 * 归并排序
 * @author  cyf
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {4,2,5,6,1,3,13,11,7};
        mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr,int left,int right){
        int[] copy = new int[arr.length];
        split(arr,left,right,copy);
    }

    //拆分
    public static void split(int[] arr,int left,int right,int[] copy){
        //左边小于右边，可以继续拆分
        if(left < right){
            //取中间值
            int mid =(left + right)/2;
            //拆左边
            split(arr,left,mid,copy);
            //拆右边
            split(arr,mid+1,right,copy);
            merge(arr,mid,left,right,copy);
        }
    }

    public static void merge(int[] arr,int mid,int left,int right,int[] copy){
        int leftIndex = left; //左指针
        int midIndex = mid +1; //中间值加1，方便两个元素作比较
        int rightIndex =midIndex;
        int copyIndex = leftIndex;//复制的数组指针

        //左指针到中间之前，右指针没到右边之前，一直比较大小
        //把数据拷贝到copy数组中
        while(leftIndex < midIndex && rightIndex <= right){
            if(arr[leftIndex] <= arr[rightIndex]){
                copy[copyIndex] = arr[leftIndex];
                leftIndex ++;
            }else{
                copy[copyIndex] = arr[rightIndex];
                rightIndex++;
            }
            copyIndex ++;
        }
        //左边指针未到达中间指针，把剩余的数据放到copy数组
        while(leftIndex < midIndex){
            copy[copyIndex] = arr[leftIndex];
            leftIndex++;
            copyIndex++;
        }
        //同上
        while(rightIndex <= right){
            copy[copyIndex] = arr[rightIndex];
            rightIndex++;
            copyIndex++;
        }
        //拷贝到原始数组中
        for(int j = left; j<copyIndex ;j++){
            arr[j] = copy[j];
        }
    }
}
