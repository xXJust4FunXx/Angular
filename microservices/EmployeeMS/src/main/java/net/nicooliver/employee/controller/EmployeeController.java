package net.nicooliver.employee.controller;

import net.nicooliver.employee.data.employee.EmployeeDto;
import net.nicooliver.employee.data.employee.EmployeeResource;
import net.nicooliver.employee.dataService.EmployeeDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("employees")
public class EmployeeController {
    @Autowired
    private EmployeeDataService employeeDataService;

    @RequestMapping(method = RequestMethod.GET)
    public HttpEntity<List<EmployeeResource>> getAllEmployees() {
        return new HttpEntity<>(employeeDataService.getAllEmployees());
    }

    @RequestMapping(value = "{employeeId}", method = RequestMethod.GET)
    public EmployeeResource getEmployeeById(@PathVariable Integer employeeId) {
        return employeeDataService.getEmployeeById(employeeId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public EmployeeResource addEmployee(@RequestBody EmployeeDto employeeDto) {
        return employeeDataService.addEmployee(employeeDto);
    }

    @RequestMapping(value = "{employeeId}", method = RequestMethod.PUT)
    public EmployeeResource addEmployee(@PathVariable Integer employeeId, @RequestBody EmployeeDto employeeDto) {
        return employeeDataService.editEmployee(employeeId, employeeDto);
    }

    @RequestMapping(value = "{employeeId}", method = RequestMethod.DELETE)
    public EmployeeResource addEmployee(@PathVariable Integer employeeId) {
        return employeeDataService.deleteEmployee(employeeId);
    }
}
