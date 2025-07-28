package 二叉树;
import java.util.*;

public class InorderTravelsal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {

            // 左子树一路入栈
            while (curr != null) {
                System.out.println("入栈节点: " + curr.val);
                stack.push(curr);
                curr = curr.left;
            }

            // 处理栈顶节点
            curr = stack.pop();

            System.out.println("出栈节点: " + curr.val);

            res.add(curr.val);

            // 准备遍历右子树
            curr = curr.right;

            if (curr != null) {
                System.out.println("切换到右子树节点: " + curr.val);
            }
        }

        return res;
    }
        public static void main(String[] args) {
            // 示例测试用例
            TreeNode root1 = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
            TreeNode root2 = null;
            TreeNode root3 = new TreeNode(1);

            InorderTravelsal sol = new InorderTravelsal();
            System.out.println("中序遍历示例1:");
            System.out.println("输出: " + sol.inorderTraversal(root1));
            System.out.println("-----------------------------");

            System.out.println("中序遍历示例2:");
            System.out.println("输出: " + sol.inorderTraversal(root2));
            System.out.println("-----------------------------");

            System.out.println("中序遍历示例3:");
            System.out.println("输出: " + sol.inorderTraversal(root3));
        }
    }

