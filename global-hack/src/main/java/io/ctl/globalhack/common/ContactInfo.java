package io.ctl.globalhack.common;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ContactInfo {

    private String name;
    private String number;
    private String email;

}
