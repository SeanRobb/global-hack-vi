package io.ctl.globalhack.common.person.info.employment;

import io.ctl.globalhack.common.person.info.BasicInfo;
import io.ctl.globalhack.common.person.info.Status;
import lombok.Data;

import java.util.Date;

@Data
public class EmploymentInfo extends BasicInfo {
    private Status employed;
    private EmployedStatus employedStatus;
    private UnEmployedStatus unEmployedStatus;
    private SchoolStatus schoolStatus;
    private String lastGradeCompleted;
}
