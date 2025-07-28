import java.util.Arrays;

class QuickSort {
    // 主函数：快速排序入口
    public int[] sortArray(int[] nums) {
        helper(nums, 0, nums.length - 1);
        return nums;
    }

    // 快排核心逻辑
    void helper(int[] nums, int l, int r) {
        if (l >= r) return;

        int i = l - 1, j = r + 1;
        int x = nums[(l + r) >> 1]; // 取中间值作为 pivot

        while (i < j) {
            do i++; while (nums[i] < x);
            do j--; while (nums[j] > x);
            if (i < j) swap(nums, i, j);
        }

        helper(nums, l, j);
        helper(nums, j + 1, r);
    }

    // 交换函数
    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // 打印数组工具
    void printArray(int[] nums) {
        System.out.println(Arrays.toString(nums));
    }

    // 测试入口
    public static void main(String[] args) {
        QuickSort sorter = new QuickSort();

        // 测试用例 1：正常数组
        int[] arr1 = {5, 2, 3, 1};
        System.out.print("原数组1：");
        sorter.printArray(arr1);
        sorter.sortArray(arr1);
        System.out.print("排序后1：");
        sorter.printArray(arr1);

        // 测试用例 2：数组中有重复元素
        int[] arr2 = {2, 2, 2, 1, 3};
        System.out.print("\n原数组2：");
        sorter.printArray(arr2);
        sorter.sortArray(arr2);
        System.out.print("排序后2：");
        sorter.printArray(arr2);

        // 测试用例 3：数组有负数
        int[] arr3 = {0, -1, 4, -3, 2};
        System.out.print("\n原数组3：");
        sorter.printArray(arr3);
        sorter.sortArray(arr3);
        System.out.print("排序后3：");
        sorter.printArray(arr3);

        // 测试用例 4：只有一个元素
        int[] arr4 = {42};
        System.out.print("\n原数组4：");
        sorter.printArray(arr4);
        sorter.sortArray(arr4);
        System.out.print("排序后4：");
        sorter.printArray(arr4);

        // 测试用例 5：空数组
        int[] arr5 = {};
        System.out.print("\n原数组5：");
        sorter.printArray(arr5);
        sorter.sortArray(arr5);
        System.out.print("排序后5：");
        sorter.printArray(arr5);
    }
}
