package service;

import entity.Employee;
import org.springframework.stereotype.Service;
import repository.EmployeeRepository;

import java.util.List;

@Service

public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }

    public Employee createEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee employee){
        return employeeRepository.findById(id)
                    .map(e-> {
                        e.setName(employee.getName());
                        e.setAge(employee.getAge());
                        e.setSalary(employee.getSalary());
                        return employeeRepository.save(e);

                })
                .orElseGet(()->{
                    employee.setId(id);
                    return employeeRepository.save(employee);
                });
    }

    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }
    public List<Employee> searchProduct(String search){
        return employeeRepository.findAllByNameContaining(search);
    }

}
