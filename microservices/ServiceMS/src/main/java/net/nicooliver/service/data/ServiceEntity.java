package net.nicooliver.service.data;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "services")
public class ServiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id")
    private EmployeeEntity employee;

    private String date;

    private float longitude;

    private float latitude;
}
