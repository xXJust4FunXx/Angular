package net.nicooliver.service.data.service;

import lombok.Data;

@Data
public class Service {
    private int id;
    private String name;
    private int employeeId;
    private String date;
    private String longitude;
    private String latitude;
}
