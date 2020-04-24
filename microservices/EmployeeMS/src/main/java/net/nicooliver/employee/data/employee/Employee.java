package net.nicooliver.employee.data.employee;

import lombok.Data;

@Data
public class Employee {
    private int id;
    private String forename;
    private String surname;
    private String longitude;
    private String latitude;
}
