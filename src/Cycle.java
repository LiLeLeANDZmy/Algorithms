
public class Cycle {
    // 判断链表是否有环（快慢指针法）
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;          // 慢指针走一步
            fast = fast.next.next;     // 快指针走两步
            if (slow == fast) return true; // 有环
        }
        return false;
    }

    // 构建无环链表
    public ListNode buildList(int[] vals) {
        if (vals.length == 0) return null;
        ListNode head = new ListNode(vals[0]);
        ListNode curr = head;
        for (int i = 1; i < vals.length; i++) {
            curr.next = new ListNode(vals[i]);
            curr = curr.next;
        }
        return head;
    }

    // 构建带环链表，pos 为尾节点连接的位置下标（0开始），-1 表示不构成环
    public ListNode buildCycleList(int[] vals, int pos) {
        if (vals.length == 0) return null;
        ListNode head = new ListNode(vals[0]);
        ListNode curr = head;
        ListNode cycleEntry = null;

        for (int i = 1; i < vals.length; i++) {
            curr.next = new ListNode(vals[i]);
            curr = curr.next;
            if (i == pos) {
                cycleEntry = curr;
            }
        }

        // 注意：pos = 0 时也要连接头节点
        if (pos == 0) cycleEntry = head;

        if (pos >= 0) curr.next = cycleEntry;
        return head;
    }

    public static void main(String[] args) {
        Cycle cycle = new Cycle();

        // 测试用例 1：无环
        ListNode list1 = cycle.buildList(new int[]{3, 2, 0, -4});
        System.out.println("用例1（无环）：" + cycle.hasCycle(list1)); // false

        // 测试用例 2：有环，pos = 1（2这个值）
        ListNode list2 = cycle.buildCycleList(new int[]{3, 2, 0, -4}, 1);
        System.out.println("用例2（有环）：" + cycle.hasCycle(list2)); // true

        // 测试用例 3：只有一个节点，无环
        ListNode list3 = cycle.buildList(new int[]{1});
        System.out.println("用例3（无环）：" + cycle.hasCycle(list3)); // false

        // 测试用例 4：一个节点构成环（自己指向自己）
        ListNode list4 = cycle.buildCycleList(new int[]{1}, 0);
        System.out.println("用例4（有环）：" + cycle.hasCycle(list4)); // true

        // 测试用例 5：空链表
        ListNode list5 = cycle.buildList(new int[]{});
        System.out.println("用例5（空链表）：" + cycle.hasCycle(list5)); // false
    }
}
