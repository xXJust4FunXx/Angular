package net.nicooliver.service.data.service;

import lombok.Data;
import net.nicooliver.service.data.employee.EmployeeResource;

@Data
public class ServiceResource {
    private int id;
    private String name;
    private EmployeeResource employee;
    private String date;
    private String address;
}
