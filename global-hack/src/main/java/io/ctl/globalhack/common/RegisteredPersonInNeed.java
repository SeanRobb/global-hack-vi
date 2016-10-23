package io.ctl.globalhack.common;

import io.ctl.globalhack.common.person.info.Race;
import io.ctl.globalhack.common.person.info.Gender;
import io.ctl.globalhack.common.person.info.employment.EmploymentInfo;
import io.ctl.globalhack.common.person.info.veteran.VeteranInfo;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
public class RegisteredPersonInNeed {
    @Id
    private String id;
    private PersonInNeed personInNeed;
    private VeteranInfo veteranInfo;
    private EmploymentInfo employmentInfo;
}
