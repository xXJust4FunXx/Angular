package net.nicooliver.service.data.location;

import lombok.Data;

@Data
public class AddressResourceObject {
    private String house_number;
    private String road;
    private String hamlet;
    private String village;
    private String county;
    private String state;
    private String postcode;
    private String country;
    private String country_code;
}
