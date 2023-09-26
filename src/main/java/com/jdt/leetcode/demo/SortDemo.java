package com.jdt.leetcode.demo;

/**
 * @author jdt
 * @date 2023/8/30
 */
public class SortDemo {


    /**
     * 合并排序
     * 先分再合
     *
     * @param arr
     * @param left
     * @param right
     */

    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, temp);//将左边部分继续分
            mergeSort(arr, mid + 1, right, temp);//将右边继续分离
            //合
            merge(arr, left, mid, right, temp);
        }


    }

    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;//临时数组的下标索引
        //先将2个部分合并
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                i++;
                t++;
            } else {
                temp[t] = arr[j];
                j++;
                t++;
            }
        }
        //如果左边的这边没有合并，则接着i继续合并
        while (i <= mid) {
            temp[t] = arr[i];
            i++;
            t++;
        }

        //如果是右边剩余没合并，接着j合并
        while (j <= right) {
            temp[t] = arr[j];
            j++;
            t++;
        }
        //接着将temp里面的数组填充到指定位置
        int tempLeft = left;
        t = 0;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }
    }


    /**
     * 快排
     * 使用两个指针
     * <p>
     * 当left=right的时候结束
     * 需要先走右指针再走左指针
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            //递归退出条件
            return;
        }
        //左指针
        int l = left;
        //右指针
        int r = right;
        while (l < r) {
            //需要先走右指针再走左指针
            //如果右边指针的数比固定左边的值要大，那么继续右指针往左走
            while (l < r && arr[r] >= arr[left]) {
                r--;
            }
            //如果左边的指针比左边固定值小，左指针继续往右走
            while (l < r && arr[l] <= arr[left]) {
                l++;
            }
            //左右指针相遇了 将左边固定值和右指针进行交换
            if (l == r) {
                int temp = arr[r];
                arr[r] = arr[left];
                arr[left] = temp;
            } else {
                //如果两个指针没有相遇 那么把两个指针的数据进行交换
                int temp = arr[r];
                arr[r] = arr[l];
                arr[l] = temp;
            }
        }
        //然后对两边分别再进行块拍
        quickSort(arr, left, l - 1);
        quickSort(arr, r + 1, right);

    }


    /**
     * 希尔排序
     * 插入排序就是步长为1的希尔排序
     * 希尔排序是一种改进的插入排序算法，它的基本思想是将待排序的数组按照一定的间隔进行分组，
     * 对每组使用插入排序算法进行排序，然后缩小间隔，再对分组进行排序，直到间隔为1为止。
     * 逐渐减小间隔大小的方法有助于提高排序过程的效率，可以减少比较和交换的次数。这是希尔排序算法的一个关键特点
     *
     * @param arr
     */
    public static void shellSort(int[] arr) {
        //步长 gap --可以自己定义 但一般来说是长度一半开始
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {//开始插入排序，只不过步长为gap
                int insertValue = arr[i];
                int insertIndex = i;
                while ((insertIndex - gap) >= 0 && arr[insertIndex - gap] > insertValue) {
                    arr[insertIndex] = arr[insertIndex - gap];
                    insertIndex -= gap;
                }
                arr[insertIndex] = insertValue;
            }

        }

    }


    /**
     * 插入排序
     * 从第二个数开始查找,视第一个为一排序，之后的后河前面的值进行比较
     *
     * @param arr
     */
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            //要插入的位置
            int insertIndex = i;
            //要插入的值
            int insertValue = arr[i];
            //往前进行比较 如果比前面的小，再和前面进行比较一下 直到放在比前一个值大的就不需要往前了
            while ((insertIndex - 1) >= 0 && insertValue < arr[insertIndex - 1]) {
                arr[insertIndex] = arr[insertIndex - 1];
                insertIndex--;
            }
            arr[insertIndex] = insertValue;

        }

    }

    /**
     * 选择排序
     * 使用一个min      存储最小值
     * 使用一个minindex 存储最小值下标
     * 假设数组长度位n 进行n-1次循环
     * 默认从下标第一个开始假设他是最小值开始往后比较，如果有比min小的值，两个交换位置
     * 下一次从第二个开始继续比较
     *
     * @param arr
     */
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            int minIndex = i;
            //用当前这个i后面的元素开始比较
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minIndex = j;
                }
            }

            if (i != minIndex) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }

        }

    }

    /**
     * 冒泡排序
     * 重复遍历要排序的数组，一次比较两个，大的往后放，冒泡到最后
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        //arr.length-1 大的数从最开头冒泡到最后，所以最后的话后面几个都确定了，第一个就不需要遍历了
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {//arr.length - i - 1,冒泡到最后的已经确定了的，所以下一次冒泡就不用管之前的了
                if (arr[j] > arr[j + 1]) {
                    flag = false;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (flag) {
                break;
            }
            System.out.println(flag);

        }

    }

    public static void main(String[] args) {
        int[] array = new int[]{2,1, 5, 3, 4, 9, 8};
//        shellSort(array);
//        quickSort(array, 0, array.length);

        int[] temp = new int[array.length];
        mergeSort(array, 0, (array.length - 1), temp);
        for (int i : array) {
            System.out.println(i);
        }
    }

}
