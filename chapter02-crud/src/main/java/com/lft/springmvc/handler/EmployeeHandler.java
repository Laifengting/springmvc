package com.lft.springmvc.handler;

import com.lft.springmvc.dao.DepartmentDao;
import com.lft.springmvc.dao.EmployeeDao;
import com.lft.springmvc.entity.Department;
import com.lft.springmvc.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;
import java.util.Map;

@Controller
@RequestMapping ("employee")
public class EmployeeHandler {
    @Autowired
    private EmployeeDao employeeDao;
    
    @Autowired
    private DepartmentDao departmentDao;
    
    /**
     * 显示所有员工
     */
    @RequestMapping ("list")
    public String list(Map<String, Object> map) {
        Collection<Employee> allEmployees = employeeDao.getAllEmployees();
        map.put("employees", allEmployees);
        return "list";
    }
    
    /**
     * 跳转到添加员工页面
     */
    @RequestMapping (value = "emp", method = {RequestMethod.GET})
    public String emp(Map<String, Object> map) {
        Collection<Department> allDepartments = departmentDao.getAllDepartments();
        map.put("departments", allDepartments);
        map.put("employee", new Employee());
        return "input";
    }
    
    /**
     * 添加完成之后跳转列表页面
     */
    @RequestMapping (value = "emp", method = {RequestMethod.POST})
    public String addEmployee(Employee employee) {
        employeeDao.save(employee);
        return "redirect:list";
    }
    
    /**
     * 根据 id 删除员工
     */
    @RequestMapping (value = "emp/{id}", method = {RequestMethod.DELETE})
    public String deleteEmployeeById(@PathVariable (name = "id") Integer id) {
        employeeDao.deleteEmployeeById(id);
        return "redirect:list";
    }
    
}
