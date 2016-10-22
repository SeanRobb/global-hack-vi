package io.ctl.globalhack.common;

import lombok.Data;

@Data
public class Address {
    private String street;
    private String city;
    private String zipCode;
    private String state;
    private boolean dataQuality;
}
