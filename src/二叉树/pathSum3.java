package 二叉树;


import java.util.*;

public class pathSum3 {

    // 主函数：计算路径总和为 targetSum 的路径数
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1); // 初始化前缀和为 0 出现一次
        return dfs(root, 0L, targetSum, map);
    }

    // DFS + 前缀和
    private int dfs(TreeNode node, long currSum, int target, Map<Long, Integer> map) {
        if (node == null) return 0;

        currSum += node.val; // 更新当前路径和

        System.out.println("访问节点值: " + node.val + "，当前前缀和: " + currSum);

        // 检查有没有前缀和为 currSum - target 的路径（即满足条件）
        int count = map.getOrDefault(currSum - target, 0);

        if (count > 0) {
            System.out.println("  -> 找到符合条件的路径数: " + count);
        }

        // 更新当前前缀和的计数（用于子树递归）
        map.put(currSum, map.getOrDefault(currSum, 0) + 1);

        // 递归左右子树
        int left = dfs(node.left, currSum, target, map);
        int right = dfs(node.right, currSum, target, map);

        // 回溯：撤销当前节点对 map 的影响，防止影响兄弟节点
        map.put(currSum, map.get(currSum) - 1);
        return count + left + right;
    }

    // ========================== 测试用例 ==========================
    public static void main(String[] args) {
        pathSum3 solution = new pathSum3();

        // 构建测试用例1: [10,5,-3,3,2,null,11,3,-2,null,1]
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);

        int targetSum = 8;
        int result = solution.pathSum(root, targetSum);
        System.out.println("总路径数为: " + result); // 期望输出: 3

        // 测试用例2: [1,null,2,null,3,null,4,null,5]
        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(2);
        root2.right.right = new TreeNode(3);
        root2.right.right.right = new TreeNode(4);
        root2.right.right.right.right = new TreeNode(5);
        int result2 = solution.pathSum(root2, 3);
        System.out.println("总路径数为: " + result2); // 期望输出: 2
    }
}