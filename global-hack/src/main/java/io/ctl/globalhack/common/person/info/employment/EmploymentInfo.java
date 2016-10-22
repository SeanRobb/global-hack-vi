package io.ctl.globalhack.common.person.info.employment;

import io.ctl.globalhack.common.person.info.Status;
import lombok.Data;

@Data
public class EmploymentInfo {
    private Status employed;
    private EmployedStatus employedStatus;
    private UnEmployedStatus unEmployedStatus;
}
