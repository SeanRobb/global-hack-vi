package io.ctl.globalhack.common;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Address {
    private String street;
    private String city;
    private String zipCode;
    private String state;
    private boolean dataQuality;
}
