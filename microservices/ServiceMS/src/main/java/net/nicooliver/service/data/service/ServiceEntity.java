package net.nicooliver.service.data.service;

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

    private Integer employeeId;

    private String date;

    private String longitude;

    private String latitude;
}
