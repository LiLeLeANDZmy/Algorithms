import java.util.Arrays;

class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n -1;
        while(p1 >= 0 && p2 >= 0){
            if(nums1[p1] > nums2[p2]){
                nums1[p] = nums1[p1];
                p1--;
            }else{
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }
        while (p2 >= 0) {
            nums1[p] = nums2[p2];
            p2--;
            p--;
        }
    }

    // 工具函数：打印数组
    public void printArray(int[] nums) {
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        Merge mergeTool = new Merge();

        // ✅ 测试用例 1：常规合并
        int[] nums1 = {1, 3, 5, 0, 0, 0};
        int[] nums2 = {2, 4, 6};
        mergeTool.merge(nums1, 3, nums2, 3);
        System.out.print("用例1：");
        mergeTool.printArray(nums1); // [1, 2, 3, 4, 5, 6]

        // ✅ 测试用例 2：nums1 全部比 nums2 小
        int[] nums3 = {1, 2, 3, 0, 0, 0};
        int[] nums4 = {4, 5, 6};
        mergeTool.merge(nums3, 3, nums4, 3);
        System.out.print("用例2：");
        mergeTool.printArray(nums3); // [1, 2, 3, 4, 5, 6]

        // ✅ 测试用例 3：nums2 全部比 nums1 小
        int[] nums5 = {4, 5, 6, 0, 0, 0};
        int[] nums6 = {1, 2, 3};
        mergeTool.merge(nums5, 3, nums6, 3);
        System.out.print("用例3：");
        mergeTool.printArray(nums5); // [1, 2, 3, 4, 5, 6]

        // ✅ 测试用例 4：nums2 是空的
        int[] nums7 = {1, 2, 3};
        int[] nums8 = {};
        mergeTool.merge(nums7, 3, nums8, 0);
        System.out.print("用例4：");
        mergeTool.printArray(nums7); // [1, 2, 3]

        // ✅ 测试用例 5：nums1 是空的（前 m 个为 0）
        int[] nums9 = {0, 0, 0};
        int[] nums10 = {1, 2, 3};
        mergeTool.merge(nums9, 0, nums10, 3);
        System.out.print("用例5：");
        mergeTool.printArray(nums9); // [1, 2, 3]
    }
}