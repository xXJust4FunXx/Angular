package net.nicooliver.employee.data.employee;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "employees")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;

    private String forename;

    private String surname;

    private String longitude;

    private String latitude;
}
