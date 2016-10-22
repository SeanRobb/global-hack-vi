package io.ctl.globalhack.common;

import io.ctl.globalhack.common.person.info.Race;
import io.ctl.globalhack.common.person.info.Gender;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

@Data
@Accessors(chain = true)
public class PersonInNeed {
    @Id
    private String id;
    private String firstName;
    private String middleName;
    private String lastName;
    private Gender gender;
    private Date dateCreated;
    private Date dateUpdated;
    private Race race;
    private List<String> phoneNumbers;
}
