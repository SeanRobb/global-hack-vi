package io.ctl.globalhack.common;

import io.ctl.globalhack.common.person.info.Ethnicity;
import io.ctl.globalhack.common.person.info.Gender;
import io.ctl.globalhack.common.person.info.Race;
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

    //Base Person info
    private String firstName;
    private String middleName;
    private String lastName;

    private Gender gender;
    private Race race;
    private Ethnicity ethnicity;

    //Location
    private Address address;

    //bare minimum
    private List<String> phoneNumbers;
    private String message;

    private Date dateCreated;
    private Date dateUpdated;
}
