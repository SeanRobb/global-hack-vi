package io.ctl.globalhack.common;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@Accessors(chain = true)
public class PersonInNeed {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private List<String> phoneNumbers;
}
