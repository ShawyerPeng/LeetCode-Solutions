package hashing;

import java.util.*;

/**
 * 问题：给出每个员工的编号, 重要程度和下属列表, 找出该员工的重要程度指数
 * 重要程度指数是他自己和下属的重要程度指数之和
 * 思路：
 * 第一种思路：把 id 作为 key 把员工对象作为 value，放在 map 对象中，利用递归求和。
 * 第二种思路：还是利用 map，借助一个链表结构活着也可以是一个队列或者栈进行进栈和出栈操作。
 */
public class EmployeeImportance {
    static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;

        public Employee(int id, int importance, List<Integer> subordinates) {
            this.id = id;
            this.importance = importance;
            this.subordinates = subordinates;
        }
    }

    public static int getImportance(List<Employee> employees, int id) {
        // 为了快速的通过 id 来定位到员工类，需要建立一个 id 和员工类的映射（HashMap 保证查询速度），然后我们根据给定的员工 id 来算其重要度
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees)
            map.put(employee.id, employee);

        int sum = 0;
        LinkedList<Employee> queue = new LinkedList<>();
        // 将Employee push到队列
        queue.add(map.get(id));
        while (!queue.isEmpty()) {
            // 获取(get)并移除(remove)此列表的头（第一个元素）
            Employee front = queue.poll();
            sum += front.importance;
            for (Integer sub : front.subordinates) {
                // 不断把下属加入到队列中
                queue.add(map.get(sub));
            }
        }
        return sum;
    }

    public static int getImportanceDFS(List<Employee> employees, int id) {
        // HashMap 保证查询速度
        Map<Integer, Employee> employeeMap = new HashMap<>();
        for (Employee employee : employees)
            employeeMap.put(employee.id, employee);

        return dfs(id, employeeMap);
    }

    private static int dfs(int id, Map<Integer, Employee> employeeMap) {
        Employee employee = employeeMap.get(id);
        int sum = employee.importance;
        for (int rid : employee.subordinates) {
            sum += dfs(rid, employeeMap);
        }
        return sum;
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        List<Integer> sub1 = new ArrayList<>();
        sub1.add(2);
        sub1.add(3);
        List<Integer> sub2 = new ArrayList<>();
        List<Integer> sub3 = new ArrayList<>();
        employees.add(new Employee(1, 5, sub1));
        employees.add(new Employee(2, 3, sub2));
        employees.add(new Employee(3, 3, sub3));
        System.out.println(getImportance(employees, 1));
        System.out.println(getImportanceDFS(employees, 1));
    }
}
// http://zxi.mytechroad.com/blog/searching/leetcode-690-employee-importance/
// http://penghb.com/2017/11/05/leetCode/employeeImportance/