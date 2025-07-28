package 哈希;
import java.util.HashMap;
import java.util.Map;

class LRUCache {

    class Node {
        int key, value;
        Node prev, next;
        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> map;
    private final Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        // Dummy nodes to avoid null checks
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        System.out.println("初始化 LRUCache，容量为: " + capacity);
    }

    private void remove(Node node) {
        System.out.println("移除节点: (" + node.key + ", " + node.value + ")");
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(Node node) {
        System.out.println("将节点移到头部: (" + node.key + ", " + node.value + ")");
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private void printCacheState() {
        System.out.print("当前缓存状态：");
        Node cur = head.next;
        while (cur != tail) {
            System.out.print("[" + cur.key + "=" + cur.value + "] ");
            cur = cur.next;
        }
        System.out.println();
    }

    public int get(int key) {
        System.out.println("get(" + key + ")");
        if (!map.containsKey(key)) {
            System.out.println(" → 不存在，返回 -1");
            printCacheState();
            return -1;
        }
        Node node = map.get(key);
        remove(node);
        addToHead(node);
        System.out.println(" → 找到，值为: " + node.value);
        printCacheState();
        return node.value;
    }

    public void put(int key, int value) {
        System.out.println("put(" + key + ", " + value + ")");
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            remove(node);
            addToHead(node);
        } else {
            if (map.size() == capacity) {
                Node lru = tail.prev;
                System.out.println("缓存满，淘汰最久未使用节点: (" + lru.key + ", " + lru.value + ")");
                remove(lru);
                map.remove(lru.key);
            }
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addToHead(newNode);
        }
        printCacheState();
    }
}

// =================== 测试类 ===================

class LRUCacheTest {
    public static void main(String[] args) {
        System.out.println("========= LRU 缓存机制测试开始 =========");

        LRUCache lRUCache = new LRUCache(2);

        lRUCache.put(1, 1);  // 缓存为 {1=1}
        lRUCache.put(2, 2);  // 缓存为 {1=1, 2=2}
        lRUCache.get(1);     // 返回 1，缓存更新为 {2=2, 1=1}
        lRUCache.put(3, 3);  // 淘汰 2，缓存为 {1=1, 3=3}
        lRUCache.get(2);     // 返回 -1
        lRUCache.put(4, 4);  // 淘汰 1，缓存为 {3=3, 4=4}
        lRUCache.get(1);     // 返回 -1
        lRUCache.get(3);     // 返回 3
        lRUCache.get(4);     // 返回 4

        System.out.println("========= LRU 缓存机制测试结束 =========");
    }
}
