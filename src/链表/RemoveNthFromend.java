package 链表;

public class RemoveNthFromend {
    // 删除倒数第n个节点
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode fast = dummy;
        ListNode slow = dummy;

        System.out.println("目标：删除倒数第 " + n + " 个节点");
        System.out.print("原始链表：");
        printList(head);

        // fast先走n+1步，创建差距
        for (int i = 0; i <= n; i++) {
            if (fast != null) {
                System.out.println("fast 前进，第 " + i + " 步，当前 fast.val = " + (fast.val));
                fast = fast.next;
            }
        }

        // fast 和 slow 同步前进
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
            System.out.println("同步移动：当前 slow.val = " + slow.val + "，fast " + (fast != null ? "未到结尾" : "已到结尾"));
        }

        // 删除目标节点
        System.out.println("删除节点：slow 当前在 " + slow.val + "，其后节点是 " + slow.next.val);
        slow.next = slow.next.next;

        System.out.print("删除后的链表：");
        printList(dummy.next);
        System.out.println("--------------------------------------------------");

        return dummy.next;
    }

    // 打印链表工具
    private void printList(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val);
            if (cur.next != null) System.out.print(" -> ");
            cur = cur.next;
        }
        System.out.println();
    }

    // 创建链表工具
    private static ListNode buildList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int val : arr) {
            cur.next = new ListNode(val);
            cur = cur.next;
        }
        return dummy.next;
    }

    // 测试用例主函数
    public static void main(String[] args) {
        RemoveNthFromend sol = new RemoveNthFromend();

        // 测试用例 1：删除中间节点
        System.out.println("【测试用例 1】输入：[1,2,3,4,5], n = 2");
        ListNode head1 = buildList(new int[]{1, 2, 3, 4, 5});
        sol.removeNthFromEnd(head1, 2);

        // 测试用例 2：删除头节点
        System.out.println("【测试用例 2】输入：[1,2], n = 2");
        ListNode head2 = buildList(new int[]{1, 2});
        sol.removeNthFromEnd(head2, 2);

        // 测试用例 3：删除尾节点
        System.out.println("【测试用例 3】输入：[1,2,3], n = 1");
        ListNode head3 = buildList(new int[]{1, 2, 3});
        sol.removeNthFromEnd(head3, 1);

        // 测试用例 4：仅一个节点，删除自己
        System.out.println("【测试用例 4】输入：[1], n = 1");
        ListNode head4 = buildList(new int[]{1});
        sol.removeNthFromEnd(head4, 1);
    }
}

