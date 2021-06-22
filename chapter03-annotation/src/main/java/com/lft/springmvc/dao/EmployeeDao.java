package com.lft.springmvc.dao;

import com.lft.springmvc.entity.Department;
import com.lft.springmvc.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {
    private static Map<Integer, Employee> employees = null;
    
    static {
        employees = new HashMap<>();
        employees.put(1001, new Employee(1001, "Tom", "tom@qq.com", 1, new Department(101, "广告部")));
        employees.put(1002, new Employee(1002, "Jerry", "jerry@qq.com", 1, new Department(102, "策划部")));
        employees.put(1003, new Employee(1003, "Helen", "helen@qq.com", 0, new Department(103, "客服部")));
        employees.put(1004, new Employee(1004, "Mary", "mary@qq.com", 0, new Department(104, "营销部")));
        employees.put(1005, new Employee(1005, "Jack", "jack@qq.com", 1, new Department(105, "设计部")));
        employees.put(1006, new Employee(1006, "Suhai", "suhai@qq.com", 0, new Department(106, "售后部")));
    }
    
    private static Integer initId = 1007;
    
    public void save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(initId++);
        }
        // employee.setDepartment();
        employees.put(employee.getId(), employee);
    }
    
    public Collection<Employee> getAllEmployees() {
        return employees.values();
    }
    
    public Employee getEmployeeById(Integer id) {
        return employees.get(id);
    }
    
    public Boolean deleteEmployeeById(Integer id) {
        return employees.remove(id) != null;
    }
    
}
