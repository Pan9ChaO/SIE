package com.fran.mapper;

import com.fran.pojo.Department;
import com.fran.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@Repository
public class EmployeeDao {


    private static Map<Integer, Employee> employees = null;

    @Autowired
    private DepartmentDao departmentDao;

    //员工所属部门


    static {
        employees = new HashMap<Integer, Employee>();

        employees.put(1001, new Employee(1001,"AA", "A770782919@qq.com", 0, new Department(101, "教学部")));
        employees.put(1002, new Employee(1002,"BB", "B770782919@qq.com", 1, new Department(102, "市场部")));
        employees.put(1003, new Employee(1003,"CC", "C770782919@qq.com", 0, new Department(103, "教研部")));
        employees.put(1004, new Employee(1004,"DD", "D770782919@qq.com", 1, new Department(104, "运营部门")));
        employees.put(1005, new Employee(1005,"EE", "E770782919@qq.com", 0, new Department(105, "后勤部")));
    }

    private static Integer initId = 1006;

    public void save(Employee employee){
        if(employee.getId() == null)
                employee.setId(initId++);

        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(),employee);

    }
    public Collection<Employee> getAll(){
        return employees.values();
    }

    //通过id查询员工
    public Employee getEmployeeById(Integer id){
        return employees.get(id);

    }
    public void delete(Integer id){

        employees.remove(id);
    }



}
