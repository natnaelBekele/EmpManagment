package com.binary.employeeManagement.controller;

import com.binary.employeeManagement.model.Employee;
import com.binary.employeeManagement.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeManagementController {
    private final EmployeeService employeeService;

    @GetMapping({"", "/list"})
    public String employee(Model m) {
        m.addAttribute("employeesList", employeeService.findAllEmployee());
        return "employees/displayEmployeePage";
    }

    @GetMapping({"/create"})
    public String createEmployee(Model model) {
        model.addAttribute("createEmployee", new Employee());
        return "employees/createEmployeePage";
    }

    @PostMapping({"/create"})
    public String createEmployee(@ModelAttribute("createEmployee") Employee employee) {
        employeeService.addEmployee(employee);
        return "redirect:/employees/list";
    }

    @GetMapping("/delete/{id}")
    public String deletePostPage(@PathVariable("id") Integer id) {
        return "employees/deleteEmployeePage";
    }

    @PostMapping({"/delete/{id}"})
    public String deleteEmployee(@PathVariable("id") Integer id) {
        employeeService.deleteEmployeeById(id);
        return "redirect:/employees/list";
    }


    @PostMapping("/update/{id}")
    public String updateEmployee(@ModelAttribute("updateEmployee") Employee employee) {
employeeService.updateEmployee(employee);
        return "redirect:/employees/list";
    }
    @GetMapping("/update/{id}")
    public String updateEmployee(@PathVariable("id") Integer id,Model model) {
        Optional<Employee> updated = employeeService.findEmployeeById(id);
        Employee updatedEmployee = null;
        if(updated.isPresent()){
            updatedEmployee = updated.get();
        }
        else {
            return "redirect:/employees/list";
        }

        model.addAttribute("updateEmployee",updatedEmployee);
        return "employees/updateEmployee";
        // return updated.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


}







