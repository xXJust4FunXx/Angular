package net.nicooliver.service.dataService;

import net.nicooliver.service.data.employee.EmployeeResource;
import net.nicooliver.service.exception.EmployeeDataServiceException;
import net.nicooliver.service.exception.EmployeeNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class EmployeeDataService {
    private static final String EMPLOYEE_MS_GET_EMP_BY_ID_URL = "http://localhost:9000/employees/{employeeId}";

    public EmployeeResource getEmployeeById(int id) throws EmployeeNotFoundException, EmployeeDataServiceException {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> vars = new HashMap<>();
        vars.put("employeeId", id + "");
        try{
            EmployeeResource res = restTemplate.getForObject(EMPLOYEE_MS_GET_EMP_BY_ID_URL, EmployeeResource.class, vars);
            return res;
        } catch (RestClientResponseException e) {
            if(e.getRawStatusCode() == 400) {
                throw new EmployeeNotFoundException(String.format("The employee with the id %d was not found", id));
            } else {
                throw new EmployeeDataServiceException(e.getResponseBodyAsString());
            }
        }
    }
}
