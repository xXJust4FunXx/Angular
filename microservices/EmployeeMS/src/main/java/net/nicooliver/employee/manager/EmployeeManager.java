package net.nicooliver.employee.manager;

import net.nicooliver.employee.data.employee.Employee;
import net.nicooliver.employee.data.employee.EmployeeEntity;
import net.nicooliver.employee.exception.EmployeeEntityNotFoundException;
import net.nicooliver.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeManager {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        List<Employee> result = new ArrayList<>();
        for(EmployeeEntity employeeEntity : employeeRepository.findAll()) {
            result.add(convertEmployeeEntityToEmployee(employeeEntity));
        }
        return result;
    }

    public Employee getEmployeeById(Integer employeeId) {
        Optional<EmployeeEntity> foundEntity = employeeRepository.findById(employeeId);

        if(!foundEntity.isPresent())
            throw new EmployeeEntityNotFoundException(String.format("Employee with id %d does not exist!", employeeId));

        return convertEmployeeEntityToEmployee(foundEntity.get());
    }

    public Employee addEmployee(Employee employee) {
        return saveEmployee(employee);
    }

    public Employee editEmployee(Integer employeeId, Employee newEmployee) {
        Employee employee = getEmployeeById(employeeId);

        employee.setForename(newEmployee.getForename());
        employee.setSurname(newEmployee.getSurname());
        employee.setLatitude(newEmployee.getLatitude());
        employee.setLongitude(newEmployee.getLongitude());

        return employee;
    }

    public Employee deleteEmployee(Integer employeeId) {
        Optional<EmployeeEntity> optional = employeeRepository.findById(employeeId);

        if(!optional.isPresent())
            throw new EmployeeEntityNotFoundException(String.format("Garage with id %d does not exist!", employeeId));

        EmployeeEntity foundEntity = optional.get();
        employeeRepository.delete(foundEntity);
        return convertEmployeeEntityToEmployee(foundEntity);
    }

    private Employee convertEmployeeEntityToEmployee(EmployeeEntity employeeEntity) {
        Employee result = new Employee();

        result.setId(employeeEntity.getId());
        result.setForename(employeeEntity.getForename());
        result.setSurname(employeeEntity.getSurname());
        result.setLatitude(employeeEntity.getLatitude());
        result.setLongitude(employeeEntity.getLongitude());

        return result;
    }

    private EmployeeEntity convertEmployeeToEmployeeEntity(Employee employee) {
        EmployeeEntity result = new EmployeeEntity();

        if(employee.getId() != -1) {
            result.setId(employee.getId());
        }

        result.setForename(employee.getForename());
        result.setSurname(employee.getSurname());
        result.setLatitude(employee.getLatitude());
        result.setLongitude(employee.getLongitude());

        return result;
    }

    private Employee saveEmployee(Employee employee) {
        EmployeeEntity storedEntity = employeeRepository.save(convertEmployeeToEmployeeEntity(employee));
        return convertEmployeeEntityToEmployee(storedEntity);
    }
}
