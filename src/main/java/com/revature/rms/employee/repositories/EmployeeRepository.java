package com.revature.rms.employee.repositories;


import com.revature.rms.employee.entities.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer>{

    /**
     * findById method: The id parameter is passed as the input.
     * An employee is returned when the input id matches a database record.
     * @param id employee id int
     * @return employee with matching id int
     */
    Employee findById(int id);

    /**
     * findByFirstName method: The firstName parameter is passed as the input.
     * An employee is returned when the input firstName matches a database record.
     * @param firstName employee firstName String
     * @return employee with matching firstName String
     */
    Employee findByFirstName(String firstName);

    /**
     * findByEmail method: The email parameter is passed as the input
     * An employee is returned when the input email matches a database record
     * @param email
     * @return
     */
    Employee findByEmail(String email);

}
