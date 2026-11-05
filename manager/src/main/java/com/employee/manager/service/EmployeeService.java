package com.employee.manager.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.manager.entity.Employee;
import com.employee.manager.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepo;
    
    public List<Employee> getEmployees() {
        return employeeRepo.findAll();
    }
    public List<Employee> addEmployee(Employee employee) {
        employeeRepo.save(employee);
        return employeeRepo.findAll();
    }
    public List<Employee> updateEmployee(Employee employee) {
        employeeRepo.save(employee);
        return employeeRepo.findAll();
    }
    public String deleteEmployee(int id) {
        employeeRepo.deleteById(employeeRepo.findById((long)id).get().getId());
        return "deleted successfully";
    }

}