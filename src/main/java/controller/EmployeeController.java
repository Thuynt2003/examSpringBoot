package controller;

import entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")

public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("")
    public List<Employee> getAllEmployee(){
        return employeeService.getAll();
    }

    @PostMapping("/create")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }

    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        return employeeService.updateEmployee(id,employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
    }

    @GetMapping("/search")
    public List<Employee> search(String search){
        return employeeService.searchProduct(search);
    }

}
