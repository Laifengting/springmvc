package com.lft.springmvc.dao;

import com.lft.springmvc.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DepartmentDao {
    private static Map<Integer, Department> departments = null;
    
    static {
        departments = new HashMap<>();
        departments.put(101, new Department(101, "广告部"));
        departments.put(102, new Department(102, "策划部"));
        departments.put(103, new Department(103, "客服部"));
        departments.put(104, new Department(104, "营销部"));
        departments.put(105, new Department(105, "设计部"));
        departments.put(106, new Department(106, "售后部"));
    }
    
    public Collection<Department> getAllDepartments() {
        return departments.values();
    }
    
    public Department getDepartmentById(Integer id) {
        return departments.get(id);
    }
}

