package algorithm.basic;

import java.util.Arrays;

public class Sorts {

    // 冒泡排序只会操作相邻的两个数据。每次冒泡操作都会对相邻的两个元素进行比较，看是否满足大小关系要求。如果不满足就让它俩互换。一次冒泡会让至少一个元素移动到它应该在的位置，重复 n 次，就完成了 n 个数据的排序工作。
    // 原地算法？ √ 只要是常量级别的空间复杂度即为原地算法
    // 稳定的算法？√相同的元素不会交换位置
    public static int[] bubbleSorting(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            boolean flag = false;
            for (int j = 0; j < nums.length - 1 - i; ++j) {
                if (nums[j + 1] < nums[j]) {
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }

        return nums;
    }

    // 插入排序和冒泡相比，差距是一个是元素的比较，一个是元素的插入
    // 原地算法
    // 稳定的算法
    // 4 5 3 6 2 5 1
    public static void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; ++i) {
            int inserter = nums[i];
            int j = i - 1;
            for (; j >= 0; --j) {
                if (nums[j] > inserter) {
                    nums[j + 1] = nums[j];
                } else {
                    break;
                }
            }
            nums[j + 1] = inserter;
        }
    }

    // 快排
    // 如果要排序数组中下标从 p 到 r 之间的一组数据，我们选择 p 到 r 之间的任意一个数据作为 pivot（分区点）。
    // 4 5 3 6 2 5 1
    public static void quickSort(int[] nums, int left, int right) {
        if (left > right) {
            return;
        }
        int pivot = nums[left];
        int left  = l;
        int right = r;
        while (left < right) {
            for (int i = left + 1; i <= right; i++) {
                if (nums[i] < pivot) {
                    lt++;
                    swap(nums, i, lt);
                }
            }
        }
        int temp = nums[left];
        nums[left] = nums[l];
        nums[l] = temp;
        quickSort(nums, ++l, r);
        quickSort(nums, l, --r);
    }

    public static void main(String[] args) {
        int[] ints = {1, 1, 3, 2};
        quickSort(ints,0,ints.length -1);
        for (int i : ints) {
            System.out.print(i + " ");
        }
        Arrays.sort(ints);
    }
}
