package io.ctl.globalhack.common;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;

@Data
@Accessors(chain = true)
public class Coordinator {

    @Id
    private String id;
    private String firstName;
    private String lastName;

}
