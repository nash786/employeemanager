package com.naeem.emanager.service;

import com.naeem.emanager.EmployeeRepo;
import com.naeem.emanager.exception.UserNotFoundException;
import com.naeem.emanager.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    @Autowired
    private final EmployeeRepo employeeRepo;

    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee) {
        employee.setEmpCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployee() {
        return employeeRepo.findAll();
    }

    public Employee update(Employee employee) {
        return employeeRepo.save(employee);
    }

    public Employee findEmployee(Long id) {
        return employeeRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id" + id + "not found"));
    }

    public void deleteEmployee(Long id) {
        employeeRepo.deleteById(id);
    }
}
