import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int left = i + 1; int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while(left < right && nums[left] == nums [left +1] )left ++;
                    while(left < right && nums[right] == nums [right ] )right --;

                    left++;
                    right--;
                }else if(sum < 0) {
                    left++;
                }else
                    right--;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        ThreeSum solution = new ThreeSum();

        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.println("用例1结果：" + solution.threeSum(nums1));

        int[] nums2 = {1, 2, 3, 4};
        System.out.println("用例2结果：" + solution.threeSum(nums2));

        int[] nums3 = {0, 0, 0, 0};
        System.out.println("用例3结果：" + solution.threeSum(nums3));

        int[] nums4 = {-2, 0, 0, 2, 2};
        System.out.println("用例4结果：" + solution.threeSum(nums4));

        int[] nums5 = {};
        System.out.println("用例5结果：" + solution.threeSum(nums5));
    }
}

    // ✅ main 方法要写在类的里面
