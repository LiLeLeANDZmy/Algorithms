package 二叉树;
import java.util.*;

public class LowestCommonAncestor
{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            System.out.println("访问 null 节点，返回 null");
            return null;
        }
        System.out.println("访问节点：" + root.val);

        if (root == p) {
            System.out.println("找到节点 p：" + p.val + "，返回它");
            return root;
        }

        if (root == q) {
            System.out.println("找到节点 q：" + q.val + "，返回它");
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            System.out.println("节点 " + root.val + " 的左右子树分别找到 p 和 q，返回当前节点作为最近公共祖先");
            return root;
        }

        TreeNode res = left != null ? left : right;

        System.out.println("节点 " + root.val + " 返回非空子树结果：" + (res != null ? res.val : "null"));

        return res;
    }

    // 构造测试用例
    public static void main(String[] args) {
        /*
                 3
                / \
               5   1
              / \ / \
             6  2 0  8
               / \
              7   4
         */
        TreeNode root = new TreeNode(3);
        TreeNode n5 = new TreeNode(5);
        TreeNode n1 = new TreeNode(1);
        TreeNode n6 = new TreeNode(6);
        TreeNode n2 = new TreeNode(2);
        TreeNode n0 = new TreeNode(0);
        TreeNode n8 = new TreeNode(8);
        TreeNode n7 = new TreeNode(7);
        TreeNode n4 = new TreeNode(4);

        root.left = n5; root.right = n1;
        n5.left = n6; n5.right = n2;
        n1.left = n0; n1.right = n8;
        n2.left = n7; n2.right = n4;

        LowestCommonAncestor solution = new LowestCommonAncestor();

        // 测试1：p=5, q=1, 最近公共祖先应该是3
        System.out.println("测试1: p=5, q=1");
        TreeNode lca1 = solution.lowestCommonAncestor(root, n5, n1);
        System.out.println("最近公共祖先: " + lca1.val);
        System.out.println("---------------------------");

        // 测试2：p=7, q=4, 最近公共祖先应该是2
        System.out.println("测试2: p=7, q=4");
        TreeNode lca2 = solution.lowestCommonAncestor(root, n7, n4);
        System.out.println("最近公共祖先: " + lca2.val);
        System.out.println("---------------------------");

        // 测试3：p=6, q=4, 最近公共祖先应该是5
        System.out.println("测试3: p=6, q=4");
        TreeNode lca3 = solution.lowestCommonAncestor(root, n6, n4);
        System.out.println("最近公共祖先: " + lca3.val);
        System.out.println("---------------------------");

        // 测试4：p=7, q=8, 最近公共祖先应该是3
        System.out.println("测试4: p=7, q=8");
        TreeNode lca4 = solution.lowestCommonAncestor(root, n7, n8);
        System.out.println("最近公共祖先: " + lca4.val);
        System.out.println("---------------------------");
    }
}



