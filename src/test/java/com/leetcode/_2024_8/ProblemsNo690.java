package com.leetcode._2024_8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 690. 员工的重要性
 *
 * @author DHW
 * @date 2024/8/26 9:56
 * @Version 1.0
*/
public class ProblemsNo690 {

    @Test
    public void solution() {
        List<Employee> employees = new ArrayList<>();
        Employee employees1 = new Employee(1, 5, null);
        employees.add(employees1);
        System.out.println("res = " + getImportance(employees, 1));
    }

    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        return getImportance(map, id);
    }

    public int getImportance(Map<Integer, Employee> map, int id) {
        Employee employee = map.get(id);
        int res = employee.importance;
        if(employee.subordinates != null) {
            for (Integer sub : employee.subordinates) {
                res += getImportance(map, sub);
            }
        }
        return res;
    }

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;

        public Employee(int id, int importance, List<Integer> subordinates) {
            this.id = id;
            this.importance = importance;
            this.subordinates = subordinates;
        }

    };
}

