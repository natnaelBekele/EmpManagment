package com.binary.employeeManagement.services;

import com.binary.employeeManagement.model.Employee;
import com.binary.employeeManagement.repositories.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EmployeeService {
    private final EmployeeRepo repo;

    public void addEmployee(Employee employee) {

        repo.addEmployee(employee);
    }

    public List<Employee> findAllEmployee() {

        return repo.getAllEmployees();
    }
    public List<Employee> deleteEmployeeById(int id){
        return repo.deleteEmployeeById(id);

    }
    public Optional<Employee> updateEmployee(Employee updatedEmployee) {
        return repo.updateEmployee(updatedEmployee);
    }

    public Optional<Employee> findEmployeeById(int id) {
        return repo.getEmployeeById(id);
    }
}

