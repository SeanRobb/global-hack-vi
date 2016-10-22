package io.ctl.globalhack.common.person.info.exit.info;

import io.ctl.globalhack.common.ResidenceType;
import io.ctl.globalhack.common.person.info.BasicInfo;
import io.ctl.globalhack.common.person.info.Status;
import lombok.Data;

import java.util.Date;

@Data
public class ExitInfo extends BasicInfo {
    private Date ExitDate;
    private ResidenceType destination;
    private String otherDestination;
    private AssessmentInfo assessmentInfo;
    private ProjectCompletionStatus projectCompletionStatus;
    private LeftEarlyReason leftEarlyReason;
    private ExpelledReason expelledReason;
    private Status familyReunificationAchieved;
}
