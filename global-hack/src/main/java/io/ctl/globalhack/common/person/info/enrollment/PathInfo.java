package io.ctl.globalhack.common.person.info.enrollment;

import io.ctl.globalhack.common.person.info.Status;
import lombok.Data;

import java.util.Date;

@Data
public class PathInfo {

    private Date dateOfPATHStatus;
    private Status clientEnrolledInPATH;
    private String reasonNotEnrolledInPATH;
}
