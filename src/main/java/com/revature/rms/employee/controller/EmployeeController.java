package com.revature.rms.employee.controller;

import com.revature.rms.employee.dtos.EmployeeDto;
import com.revature.rms.employee.entities.Employee;
import com.revature.rms.core.exceptions.InvalidRequestException;
import com.revature.rms.employee.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {this.employeeService = employeeService;}

    /**
     * getEmployeeById method: Returns an employee object when the id int matches a record in the database.
     * @param id employeeId int value
     * @return an employee with matching id
     */
    @GetMapping(value="/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee getEmployeeById(@PathVariable int id) {return employeeService.findById(id);}

    /**
     * getEmployeesById method: Returns a set of employee objects when the ids- ints match records in the database.
     * @param ids employeeId int values
     * @return a set of employees with matching ids
     */
    @GetMapping(value="/ids/{ids}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<Employee> getEmployeesByIds(@PathVariable @RequestBody Set<Integer> ids){
        Set<Employee> employees = new HashSet<>();
        for (int s : ids) {
            employees.add(employeeService.findById(s));
        }
        return employees;
    }

    /**
     * addEmployee method: Takes in a employee object as the input.
     * @param employee newly persisted employee object
     * @return the newly added employee object
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee addNewEmployee(@RequestBody @Valid EmployeeDto employee,
                                   @RequestHeader(value = "Authorization") int id) {
        return employeeService.save(employee, id);
    }

    /**
     * update method: The employee object is inputted and changes are saved.
     * @param employee newly updated employee object
     * @return updated/modified employee object
     */
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee updateEmployee(@RequestBody @Valid EmployeeDto employee) {
        return employeeService.update(employee);
    }

    /**
     * getByfirstname method: Returns an employee object when the firstName String matches a record in the database.
     * @param firstName object
     * @return an employee with matching firstName
     */
    @GetMapping(value = "/firstname", produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee getByFirstName(@RequestParam @Valid String firstName) {return employeeService.findByFirstname(firstName);}

    /**
     * getAllEmployees method: Returns a list of all the employee objects in the database.
     * @return a list of all the employees
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> getAllEmployees() {return employeeService.findAll();}

    /**
     * deleteEmployeeById method: Deletes an employee object based on its id int
     * @param id employeeId int value
     */
    @DeleteMapping(value = "/{id}")
    public void deleteEmployeeById(@PathVariable int id) {
        if (id <= 0) {
            throw new InvalidRequestException("id may not be below 1");
        }
        employeeService.delete(id);
    }

    /**
     * getEmployeesByOwnerId method: Retrieves a list of employees based on the boss' ID
     * @param id Boss' ID
     * @return List of employees
     */
    @GetMapping(value = "/owners/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> getEmployeesByOwnerId(@PathVariable int id){return employeeService.findByOwnerId(id);}

    /**
     * test method: test endpoint to ensure controller is working
     * @return String saying "employeeController loaded"
     */
    @GetMapping("/test")
    public @ResponseBody String test() {return "employeeController loaded";}
}
