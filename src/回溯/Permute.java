package 回溯;
import java.util.*;

public class Permute {

    /**
     * 生成给定数组 nums 的所有不重复的排列（即全排列）。
     * 使用回溯算法：DFS + 状态撤销。
     */
    public static List<List<Integer>> permute(int[] nums) {
        // 结果列表，用于存储所有合法的排列组合
        List<List<Integer>> res = new ArrayList<>();
        // 当前路径（排列构建中的中间结果）
        List<Integer> cur = new ArrayList<>();
        // 启动回溯
        backtracking(res, cur, nums);
        return res;
    }

    /**
     * 回溯函数（核心递归逻辑）：
     * 思想：在当前路径（cur）基础上，枚举每一个未使用的数字，尝试加入路径 → 深入递归 → 回溯撤销。
     *
     * @param res 最终结果列表，收集所有排列
     * @param cur 当前构造中的排列路径
     * @param nums 输入数组
     */
    private static void backtracking(List<List<Integer>> res, List<Integer> cur, int[] nums) {
        // ✅【终止条件】路径长度达到输入数组长度，说明形成了一个完整排列
        if (cur.size() == nums.length) {
            // 注意：必须 new 一个新的 list，否则引用会变（因为 cur 是复用的）
            res.add(new ArrayList<>(cur));
            return; // 回到上一层递归
        }

        // ✅【尝试每一个可用的数字】
        for (int i = 0; i < nums.length; i++) {
            // 🚫 如果当前数字已经在路径中，跳过（避免重复使用）
            if (cur.contains(nums[i])) {
                continue;
            }

            // ✅【选择当前数字】
            cur.add(nums[i]);

            // 🔁【递归进入下一层】继续填下一个位置
            backtracking(res, cur, nums);

            // ❌【撤销选择（回溯）】将最后加入的数字移除，为下一轮尝试其他数字做好准备
            cur.remove(cur.size() - 1);
        }
    }



    public static void main(String[] args) {
        // 测试用例1
        int[] nums1 = {1, 2, 3};
        System.out.println("测试用例1: [1, 2, 3]");
        List<List<Integer>> res1 = permute(nums1);
        System.out.println("最终结果：" + res1);
        System.out.println();

        // 测试用例2
        int[] nums2 = {1, 2};
        System.out.println("测试用例2: [1, 2]");
        List<List<Integer>> res2 = permute(nums2);
        System.out.println("最终结果：" + res2);
        System.out.println();

        // 测试用例3
        int[] nums3 = {1};
        System.out.println("测试用例3: [1]");
        List<List<Integer>> res3 = permute(nums3);
        System.out.println("最终结果：" + res3);
        System.out.println();
    }
}
