package net.nicooliver.employee.dataService;

import net.nicooliver.employee.data.employee.Employee;
import net.nicooliver.employee.data.employee.EmployeeDto;
import net.nicooliver.employee.data.employee.EmployeeResource;
import net.nicooliver.employee.data.location.LongitudeLatitude;
import net.nicooliver.employee.exception.EmployeeBadRequestException;
import net.nicooliver.employee.manager.EmployeeManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDataService {
    @Autowired
    private EmployeeManager employeeManager;
    @Autowired
    private LocationIQDataService locationIQDataService;

    public List<EmployeeResource> getAllEmployees() {
        List<EmployeeResource> result = new ArrayList<>();
        for (Employee employee : employeeManager.getAllEmployees()) {
            result.add(convertEmployeeToEmployeeResource(employee));
        }
        return result;
    }

    public EmployeeResource getEmployeeById(Integer employeeId) {
        return convertEmployeeToEmployeeResource(employeeManager.getEmployeeById(employeeId));
    }

    public EmployeeResource addEmployee(EmployeeDto employeeDto) {
        checkEmployeeDto(employeeDto);

        return convertEmployeeToEmployeeResource(
                employeeManager.addEmployee(convertEmployeeDtoToEmployee(employeeDto)));
    }

    public EmployeeResource editEmployee(Integer employeeId, EmployeeDto employeeDto) {
        checkEmployeeDto(employeeDto);

        Employee editedEmployee = employeeManager.editEmployee(employeeId, convertEmployeeDtoToEmployee(employeeDto));
        return convertEmployeeToEmployeeResource(editedEmployee);
    }

    public EmployeeResource deleteEmployee(Integer employeeId) {
        return convertEmployeeToEmployeeResource(employeeManager.deleteEmployee(employeeId));
    }

    private Employee convertEmployeeDtoToEmployee(EmployeeDto employeeDto) {
        Employee result = new Employee();

        result.setId(-1);
        result.setForename(employeeDto.getForename());
        result.setSurname(employeeDto.getSurname());

//        LongitudeLatitude lonlat = locationIQDataService.getLongitudeLatitudeByAddress(employeeDto.getAddress());
//        result.setLongitude(lonlat.getLongitude());
//        result.setLatitude(lonlat.getLatitude());
        result.setLongitude("-1");
        result.setLatitude("-1");

        return result;
    }

    private EmployeeResource convertEmployeeToEmployeeResource(Employee employee) {
        EmployeeResource result = new EmployeeResource();

        result.setId(employee.getId());
        result.setName(employee.getSurname() + " " + employee.getForename());
//        result.setAddress(locationIQDataService.getAddress(employee.getLongitude(),
//                employee.getLatitude()));
        result.setAddress("testAddress");

        return result;
    }

    private void checkEmployeeDto(EmployeeDto employeeDto) {
        if(isNullOrEmpty(employeeDto.getForename())) {
            throw new EmployeeBadRequestException("The forename of the employee must be set");
        }
        if(isNullOrEmpty(employeeDto.getSurname())) {
            throw new EmployeeBadRequestException("The surname of the employee must be set");
        }
        if(isNullOrEmpty(employeeDto.getAddress())) {
            throw new EmployeeBadRequestException("The address of the employee must be set");
        }
        if(employeeDto.getForename().length() < 2) {
            throw new EmployeeBadRequestException("The forename of the employee must be longer than 1");
        }
        if(employeeDto.getSurname().length() < 2) {
            throw new EmployeeBadRequestException("The surname of the employee must be longer than 1");
        }
    }

    private boolean isNullOrEmpty(String string) {
        return string == null || string.equals("");
    }
}
