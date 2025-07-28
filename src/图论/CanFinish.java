package 图论;

import java.util.*;

public class CanFinish {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 建图：邻接表
        List<List<Integer>> graph = new ArrayList<>();
        // 入度数组
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // 构建图和入度
        for (int[] pair : prerequisites) {
            int course = pair[0];
            int pre = pair[1];
            graph.get(pre).add(course);
            System.out.println(graph);

            inDegree[course]++;
        }
        System.out.println("初始入度数组: " + Arrays.toString(inDegree));

        System.out.println("邻接表结构:");
        for (int i = 0; i < numCourses; i++) {
            System.out.println(i + " -> " + graph.get(i));
        }

        // 拓扑排序队列：从入度为0的课程开始
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
                System.out.println("入度为0，入队课程: " + i);
            }
        }

        int finished = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            System.out.println("出队课程: " + curr);
            finished++;

            for (int next : graph.get(curr)) {
                inDegree[next]--;
                System.out.println("课程 " + next + " 入度减1，当前入度: " + inDegree[next]);
                if (inDegree[next] == 0) {
                    queue.offer(next);
                    System.out.println("课程 " + next + " 入度为0，入队");
                }
            }
        }

        System.out.println("完成的课程数量: " + finished + "，课程总数: " + numCourses);
        return finished == numCourses;
    }

    // 测试样例
    public static void main(String[] args) {
        CanFinish solver = new CanFinish();

        int[][] prereq1 = {{1, 0}, {2, 1}, {3, 2}};
        System.out.println(solver.canFinish(4, prereq1)); // true

        int[][] prereq2 = {{1, 0}, {0, 1}};
        System.out.println(solver.canFinish(2, prereq2)); // false

        int[][] prereq3 = {{1, 0}, {2, 1}, {0, 2}};
        System.out.println(solver.canFinish(3, prereq3)); // false


    }
}

