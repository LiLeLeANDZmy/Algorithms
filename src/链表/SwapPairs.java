package 链表;

public class SwapPairs {
    // 交换链表中每两个相邻的节点
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;

        System.out.println("原始链表：");
        printList(dummy.next);
        System.out.println("--------------------------------");

        int step = 1;

        while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = first.next;

            System.out.println("第 " + step + " 次交换：");
            System.out.println("当前 prev 指向节点：" + (prev == dummy ? "dummy" : prev.val));
            System.out.println("first 节点：" + first.val);
            System.out.println("second 节点：" + second.val);

            // 开始交换
            System.out.println("开始交换指针...");

            prev.next = second;
            System.out.print("当前链表状态：");
            printList(dummy.next);

            first.next = second.next;
            System.out.print("当前链表状态：");
            printList(dummy.next);

            second.next = first;
            System.out.print("当前链表状态：");
            printList(dummy.next);

            // 打印当前链表状态
            System.out.print("当前链表：");
            printList(dummy.next);
            System.out.println("--------------------------------");

            // 移动 prev 指针
            prev = first;
            step++;
        }

        System.out.print("最终链表：");
        printList(dummy.next);
        return dummy.next;
    }

    // 工具：打印链表
    private static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null) System.out.print(" -> ");
            curr = curr.next;
        }
        System.out.println();
    }

    // 工具：构建链表
    private static ListNode buildList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int val : arr) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }
        return dummy.next;
    }

    // 主方法测试
    public static void main(String[] args) {
        SwapPairs sol = new SwapPairs();

        System.out.println("【测试用例1】输入：[1,2,3,4]");
        sol.swapPairs(buildList(new int[]{1,2,3,4}));
        System.out.println("======================================");

        System.out.println("【测试用例2】输入：[1,2,3]");
        sol.swapPairs(buildList(new int[]{1,2,3}));
        System.out.println("======================================");

        System.out.println("【测试用例3】输入：[1]");
        sol.swapPairs(buildList(new int[]{1}));
        System.out.println("======================================");

        System.out.println("【测试用例4】输入：[]");
        sol.swapPairs(buildList(new int[]{}));
        System.out.println("======================================");
    }
}
