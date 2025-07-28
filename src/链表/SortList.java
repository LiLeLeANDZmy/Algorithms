package 链表;

public class SortList {
    // 主方法：归并排序链表
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        // 找中点并断开
        ListNode mid = getMid(head);
        ListNode rightHead = mid.next;
        mid.next = null;

        System.out.println("找到中点：" + mid.val);

        // 递归排序左右链表
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        // 合并两个有序链表
        ListNode merged = merge(left, right);
        System.out.print("合并链表：");
        printList(merged);
        System.out.println("--------------------------------");

        return merged;
    }

    // 获取链表中点（快慢指针）
    private ListNode getMid(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // 合并两个有序链表
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }

    // 打印链表
    private void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    // 构造链表
    private static ListNode buildList(int[] arr) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        for (int val : arr) {
            tail.next = new ListNode(val);
            tail = tail.next;
        }
        return dummy.next;
    }

    // 测试函数
    public static void main(String[] args) {
        SortList sorter = new SortList();

        // 测试用例1：无序4节点
        System.out.println("【测试用例1】输入：4 -> 2 -> 1 -> 3");
        ListNode head = buildList(new int[]{4, 2, 1, 3});
        System.out.print("原始链表：");
        sorter.printList(head);
        ListNode result = sorter.sortList(head);
        System.out.print("最终排序结果：");
        sorter.printList(result);
        System.out.println("================================\n");

        // 测试用例2：有负数
        System.out.println("【测试用例2】输入：-1 -> 5 -> 3 -> 4 -> 0");
        head = buildList(new int[]{-1, 5, 3, 4, 0});
        System.out.print("原始链表：");
        sorter.printList(head);
        result = sorter.sortList(head);
        System.out.print("最终排序结果：");
        sorter.printList(result);
        System.out.println("================================\n");

        // 测试用例3：空链表
        System.out.println("【测试用例3】输入：空链表");
        head = buildList(new int[]{});
        System.out.print("原始链表：");
        sorter.printList(head);
        result = sorter.sortList(head);
        System.out.print("最终排序结果：");
        sorter.printList(result);
        System.out.println("================================\n");

        // 测试用例4：只有一个元素
        System.out.println("【测试用例4】输入：1");
        head = buildList(new int[]{1});
        System.out.print("原始链表：");
        sorter.printList(head);
        result = sorter.sortList(head);
        System.out.print("最终排序结果：");
        sorter.printList(result);
        System.out.println("================================\n");

        // 测试用例5：两个元素乱序
        System.out.println("【测试用例5】输入：2 -> 1");
        head = buildList(new int[]{2, 1});
        System.out.print("原始链表：");
        sorter.printList(head);
        result = sorter.sortList(head);
        System.out.print("最终排序结果：");
        sorter.printList(result);
        System.out.println("================================");
    }

}
