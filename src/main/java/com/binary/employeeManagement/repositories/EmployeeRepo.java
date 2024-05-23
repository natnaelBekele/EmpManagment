package com.binary.employeeManagement.repositories;

import com.binary.employeeManagement.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepo {

    List<Employee> empList = new ArrayList<>();
    private Integer id = 0;

    public EmployeeRepo() {

    }

    public void addEmployee(Employee employee) {
        employee.setId(id);
        empList.add(employee);
        id++;
    }

    public List<Employee> getAllEmployees() {
        System.out.println(empList);
        return empList;
    }

    public List<Employee> deleteEmployeeById(int id) {
        for (int i = 0; i < empList.size(); i++) {

            if (empList.get(i).getId() == id) {
                empList.remove(i);
                break;
            }
        }
        return empList;
    }
    public Optional<Employee> updateEmployee(Employee updatedEmployee) {
        for (int i = 0; i < empList.size(); i++) {
            if (empList.get(i).getId().equals(updatedEmployee.getId())) {
                empList.set(i, updatedEmployee);
                return Optional.of(updatedEmployee);
            }
        }
        return Optional.empty();
    }

    public Optional<Employee> getEmployeeById(int id) {
        return empList.stream().filter(emp -> emp.getId() == id).findFirst();
    }
}


