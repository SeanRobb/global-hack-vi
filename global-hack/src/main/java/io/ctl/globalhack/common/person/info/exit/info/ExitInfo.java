package io.ctl.globalhack.common.person.info.exit.info;

import io.ctl.globalhack.common.ResidenceType;
import lombok.Data;

import java.util.Date;

@Data
public class ExitInfo {
    private Date ExitDate;
    private ResidenceType destination;
    private String otherDestination;
}
