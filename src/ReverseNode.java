// 链表节点定义
class ListNode {
    int val;            // 节点值
    ListNode next;      // 指向下一个节点的引用

    ListNode(int val) {
        this.val = val;
    }
}

public class ReverseNode {

    // 反转单链表函数
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode temp = curr.next; // 暂存下一个节点
            curr.next = prev;          // 当前节点指向前一个节点
            prev = curr;               // prev前进
            curr = temp;               // curr前进
        }
        return prev; // 返回新链表头
    }

    // 打印链表函数
    public void printList(ListNode head) {
        if (head == null) {
            System.out.println("null");
            return;
        }
        while (head != null) {
            System.out.print(head.val + " → ");
            head = head.next;
        }
        System.out.println("null");
    }

    // 构建链表（通过数组）
    public ListNode buildList(int[] values) {
        if (values.length == 0) return null;
        ListNode head = new ListNode(values[0]);
        ListNode curr = head;
        for (int i = 1; i < values.length; i++) {
            curr.next = new ListNode(values[i]);
            curr = curr.next;
        }
        return head;
    }

    // 测试入口
    public static void main(String[] args) {
        ReverseNode sol = new ReverseNode();

        // 测试用例 1：多节点
        ListNode list1 = sol.buildList(new int[]{1, 2, 3, 4, 5});
        System.out.print("原链表1：");
        sol.printList(list1);
        ListNode rev1 = sol.reverseList(list1);
        System.out.print("反转后1：");
        sol.printList(rev1);

        // 测试用例 2：一个节点
        ListNode list2 = sol.buildList(new int[]{99});
        System.out.print("\n原链表2：");
        sol.printList(list2);
        ListNode rev2 = sol.reverseList(list2);
        System.out.print("反转后2：");
        sol.printList(rev2);

        // 测试用例 3：空链表
        ListNode list3 = sol.buildList(new int[]{});
        System.out.print("\n原链表3：");
        sol.printList(list3);
        ListNode rev3 = sol.reverseList(list3);
        System.out.print("反转后3：");
        sol.printList(rev3);

        // 测试用例 4：两个节点
        ListNode list4 = sol.buildList(new int[]{7, 8});
        System.out.print("\n原链表4：");
        sol.printList(list4);
        ListNode rev4 = sol.reverseList(list4);
        System.out.print("反转后4：");
        sol.printList(rev4);
    }
}