package com.rest.restApi.controller;

import com.rest.restApi.model.Employee;
import com.rest.restApi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> createPerson(@RequestBody Employee employee){
        Employee person1=  employeeService.save(employee);
        return new ResponseEntity<Employee>(person1, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updatePerson(@PathVariable String id, @RequestBody Employee employee){
        Employee employee1=  employeeService.updateEmployee(employee,id);
        return new ResponseEntity<Employee>(employee1, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<String>("Deleted",HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Employee> getPerson(@PathVariable String id){
        Employee employee =  employeeService.getEmployee(id);
        return new ResponseEntity<Employee>(employee,HttpStatus.OK);
    }

    @GetMapping("/{id}/name")
    public ResponseEntity<Employee> getPersonWithName(
            @PathVariable String id,
            @RequestParam(value = "includeDetails", required = true) Boolean name) {
        Employee employee = employeeService.getEmployeeWithName(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }




   /* @RestController combines @Controller and @ResponseBody
    @ResponseBody tells Spring to directly return the method’s response as JSON instead of resolving it as a view (like an HTML page).
    So, every method inside @RestController behaves as if @ResponseBody is already added.
    Spring Boot uses Jackson (by default) to convert Java objects to JSON
    If a method returns a Java object, Spring Boot automatically serializes it to JSON using the Jackson library (included in spring-boot-starter-web).
    */


 /* @RequestMapping (Class)	Defines a base URL for all methods.
    @RequestMapping (Method)	Maps a method to a specific request.
    @GetMapping	     for GET requests.
    @PostMapping	 for POST requests.
    @PutMapping	     for PUT requests.
    @DeleteMapping	 for DELETE requests.
    @RequestParam	Handles query parameters (?key=value).
    @PathVariable	Extracts values from URL path segments.
  */


  /*  @RequestParam (Extracts Query Parameters from URL)
    Used to capture query parameters from a request.
    Useful for optional or filtering parameters.
   */

    /* @RequestBody (Extracts JSON Body from HTTP Request)
    Used in POST, PUT, PATCH requests.
    Converts JSON request body into a Java object.
     */

}
