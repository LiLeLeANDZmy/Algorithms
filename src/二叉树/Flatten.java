package 二叉树;

public class Flatten {
    public void flatten(TreeNode root) {
        TreeNode curr = root;

        while (curr != null) {
            System.out.println("当前节点: " + curr.val);

            if (curr.left != null) {
                System.out.println("  有左子树，开始处理左子树...");

                // 找到左子树中最右边的节点（前驱）
                TreeNode rightMost = curr.left;
                while (rightMost.right != null) {
                    rightMost = rightMost.right;
                }
                System.out.println("    左子树最右节点: " + rightMost.val);

                // 将当前节点的右子树接到左子树最右节点的右边
                rightMost.right = curr.right;

                if (curr.right != null) {
                    System.out.println("    把右子树 " + curr.right.val + " 接到 " + rightMost.val + " 的右边");
                } else {
                    System.out.println("    当前无右子树");
                }

                // 将左子树整体搬到右边，并清空左子树
                curr.right = curr.left;
                curr.left = null;
                System.out.println("  左子树 " + curr.right.val + " 移到右边");
            }

            // 打印当前链表结构
            printRightChain(curr);

            // 继续向下遍历
            curr = curr.right;
        }
    }

    // 辅助函数：打印当前节点右侧链表结构
    private void printRightChain(TreeNode node) {
        System.out.print("  当前链表结构: ");
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.right;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Flatten flatten = new Flatten();

        // 示例 1：root = [1,2,5,3,4,null,6]
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(5);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(4);
        root1.right.right = new TreeNode(6);

        System.out.println("==== 示例 1 ====");
        flatten.flatten(root1);
        printFinalResult(root1);

        // 示例 2：root = []
        System.out.println("\n==== 示例 2（空树） ====");
        flatten.flatten(null);

        // 示例 3：root = [0]
        TreeNode root3 = new TreeNode(0);
        System.out.println("\n==== 示例 3 ====");
        flatten.flatten(root3);
        printFinalResult(root3);
    }

    // 打印最终链表结果
    private static void printFinalResult(TreeNode node) {
        System.out.print("最终链表结构: ");
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.right;
        }
        System.out.println("null");
    }

}
