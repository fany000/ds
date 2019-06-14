package sort;

import java.util.Arrays;

/**
 * 快速排序
 * 选择数组第一个元素作为比较值
 * @author cyf
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 6, 1, 4};
        sort(arr, 0, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int baseIndex, int l, int r) {
        int left = l;
        int right = r;
        int oBaseIndex = baseIndex;

        int base = arr[baseIndex];
        boolean change = false;

        //右指针不等于左指针的时候一直做比较
        while (right != left) {
            //右指针向左扫描小于base值的元素下标
            while (right > left) {
                //左右指针碰撞或者发现小于中间值退出循环
                if (arr[right] <= base || right == left) {
                    change = true;
                    break;
                }
                if (right > 0)
                    right--;
                else//防止死循环
                    break;
            }

            while (left < right) {
                //左指针向右扫描大于base值的元素下标
                if (arr[left] > base || right == left) {
                    change = true;
                    break;
                }
                if (left < right)
                    left++;
                else
                    break;
            }

            if (change) {
                //小于base值的元素换位
                arr[baseIndex] = arr[right];
                arr[right] = base;
                //大于base值的元素换位
                arr[right] = arr[left];
                arr[left] = base;

                //重新标记base值
                baseIndex = left;

                change = false;
            }
        }
        //此时base值左边的元素小于base值，base值右边的元素大于base值
        //如果baseIndex指针大于0且左边是从下标0开始的，就是像左边进行排序
        //第一趟排序 为  1,2,3,6,5,4
        //3 的 左边 1,2 进入这里
        if (baseIndex > 0  && l == 0)
            sort(arr, oBaseIndex, l, baseIndex - 1);
        //3 的 右边 6,5,4进入这里
        if (baseIndex > 0 && baseIndex + 1 < arr.length  && baseIndex < r)
            sort(arr, baseIndex + 1, baseIndex + 1, r);

    }
}
