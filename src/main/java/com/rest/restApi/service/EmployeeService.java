package com.rest.restApi.service;

import com.rest.restApi.model.Employee;
import com.rest.restApi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee save(Employee employee){
       return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Employee employee, String id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee existingPerson = optionalEmployee.get();
            existingPerson.setName(employee.getName());
            existingPerson.setAge(employee.getAge());
            existingPerson.setGender(employee.getGender());
            return employeeRepository.save(existingPerson);
        } else {
            throw new RuntimeException("Person not found with id: " + id);
        }
    }


    public void deleteEmployee(String id) {
        Optional<Employee> optionalPerson = employeeRepository.findById(id);
        if (optionalPerson.isPresent()) {
            employeeRepository.deleteById(id);
        } else {
            throw new RuntimeException("Person not found with id: " + id);
        }
    }

    public Employee getEmployee (String id) {
        Optional<Employee> optionalPerson = employeeRepository.findById(id);
         if(optionalPerson.isPresent()){
             return optionalPerson.get();
         }
         else {
             throw new RuntimeException("not found" +id);
         }
    }

    public Employee getEmployeeWithName (String id) {
            Optional<Employee> optionalPerson = employeeRepository.findById(id);
            if(optionalPerson.isPresent()){
                return optionalPerson.get();
            }
            else {
                throw new RuntimeException("not found" +id);
            }
    }


    public Employee updateEmployeeUsingPut(Employee employee) {
            return employeeRepository.save(employee);
    }
}
