package com.kuang.controller;

import com.kuang.dao.DepartmentDao;
import com.kuang.dao.EmployeeDao;
import com.kuang.pojo.Department;
import com.kuang.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;
    @RequestMapping("basic-table.html")
    public String list(Model model){
        Collection<Employee> all = employeeDao.getAll();
        model.addAttribute("emps",all);

        return "basic-table";
    }

    @RequestMapping("add")
    public String add(Model model){
        Collection<Department> department = departmentDao.getDepartment();
        //查出所有部门的信息
        model.addAttribute("departments",department);
        return "add";
    }

    @PostMapping("add")
    public String addPost(Employee employee){
        //添加的操作
        System.out.println("save=>"+employee);
        employeeDao.save(employee);//保存员工的信息

        return "redirect:basic-table.html";
    }

    @GetMapping("change/{id}")
    public String change(@PathVariable("id")Integer id, Model model){
        Employee employeeById = employeeDao.getEmployeeById(id);
        Collection<Department> department = departmentDao.getDepartment();
        //查出所有部门的信息
        model.addAttribute("departments",department);
        model.addAttribute("employee",employeeById);
        return "change";


    }

    @PostMapping("/update")
    public String changePost(Employee employee){
        //添加的操作
        System.out.println("change=>"+employee);
        employeeDao.save(employee);//保存员工的信息

        return "redirect:basic-table.html";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id")Integer id){
        Employee employeeById = employeeDao.getEmployeeById(id);
        System.out.println("delete:"+employeeById);
        employeeDao.delete(id);
        return "basic-table";
    }


}
