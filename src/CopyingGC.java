import java.util.*;

class GcObject {
    String name;
    int age; // 表示“存活次数”或“GC年龄”

    public GcObject(String name) {
        this.name = name;
        this.age = 0;
    }

    @Override
    public String toString() {
        return name + "(age=" + age + ")";
    }
}

public class CopyingGC {

    List<GcObject> fromSpace = new ArrayList<>();
    List<GcObject> toSpace = new ArrayList<>();
    Set<GcObject> roots = new HashSet<>();

    public void allocate(String name) {
        GcObject obj = new GcObject(name);
        fromSpace.add(obj);
        roots.add(obj); // 模拟有引用
    }

    public void simulateGC() {
        toSpace.clear();
        System.out.println("开始 GC，from 空间：" + fromSpace);

        for (GcObject obj : fromSpace) {
            if (roots.contains(obj)) {
                obj.age++;
                toSpace.add(obj); // 复制活对象
            }
        }

        // 交换 from 和 to
        List<GcObject> temp = fromSpace;
        fromSpace = toSpace;
        toSpace = temp;

        System.out.println("GC 结束，存活对象：" + fromSpace);
    }

    public static void main(String[] args) {
        CopyingGC gc = new CopyingGC();

        gc.allocate("A");
        gc.allocate("B");
        gc.allocate("C");

        // 模拟某些对象失去引用
        gc.roots.removeIf(o -> o.name.equals("B"));

        gc.simulateGC(); // 第一次 GC

        // 再添加对象
        gc.allocate("D");

        gc.simulateGC(); // 第二次 GC
    }
}
