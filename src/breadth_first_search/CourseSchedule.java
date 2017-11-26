package breadth_first_search;

import java.util.*;

/**
 * https://leetcode.com/problems/course-schedule
 * 问题：有0...n-1门课，有的课有前提条件，比如：如果选0号课，就必须先上1号课，这样就用pair对表示：[0,1]
 * 给定课程的门数和pair对，判断是否能完成所有课程
 * 思路：典型的图的拓扑排序题目，本质就是在有向图中检测环。
 * 在一个有向图中，每次找到一个没有前驱节点的节点（也就是入度为0的节点），然后把它指向其他节点的边都去掉
 * 重复这个过程（BFS），直到所有节点已被找到，或者没有符合条件的节点（如果图中有环存在）。
 * 实现步骤：
 * 1. 初始化图邻接矩阵 (u 依赖于于 v，则 matrix[u][v]==1) 和每个节点的入度数组 (u 依赖于 v，则 inDegree[v]++)。
 * 2. 从入度数组中选取一个没有前驱节点（即 inDegree[v]==0）的顶点输出。
 * 3. 从图中删除该顶点和所有以它为头节点的弧。(即所有 matrix[v][otherV]==1 的，inDegree[otherV]–)。
 * 4. 重复 2，3 步骤，直到全部顶点均已输出，或者图中不存在无前驱的顶点为止.(此时说明图中有环)。
 * 所以，这道题目就是检测最后构造的图中是否有环即可 (即检测 indegree 数组是否有顶点的值大于 0)。
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 1) return true;
        if (prerequisites.length == 0 || prerequisites[0].length == 0) return true;

        // 输入可能有重复的边，所以邻接表用 HashSet 存储
        Map<Integer, Set<Integer>> graph = new HashMap<>();

        // 先初始化图，每个赋一个空列表
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new HashSet<>());
        }
        // 根据边建立图，并计算入度
        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        // 找到有向图的入口
        Queue<Integer> queue = new LinkedList<>();
        int courseRemaining = numCourses;
        for (Map.Entry<Integer, Set<Integer>> entry : graph.entrySet()) {
            // 如果入度为0
            if (entry.getValue().size() == 0) {
                queue.offer(entry.getKey());
                courseRemaining--;
            }
        }

        // 按照拓扑排序的顺序，进行广度优先搜索
        while (!queue.isEmpty()) {
            int key = queue.poll();
            for (Map.Entry<Integer, Set<Integer>> entry : graph.entrySet()) {
                if (entry.getValue().contains(key)) {
                    entry.getValue().remove(key);
                    if (entry.getValue().size() == 0) {
                        queue.offer(entry.getKey());
                        courseRemaining--;
                    }
                }
            }
        }

        return courseRemaining == 0;
    }

    public static void main(String[] args) {
        CourseSchedule obj = new CourseSchedule();
        System.out.println(obj.canFinish(2, new int[][]{{1, 0}}));
        System.out.println(obj.canFinish(2, new int[][]{{1, 0}, {0, 1}}));
    }
}
// https://segmentfault.com/a/1190000003814058
// https://www.youtube.com/watch?v=pCvUGQ4l1-8