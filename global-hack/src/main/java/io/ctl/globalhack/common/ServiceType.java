package io.ctl.globalhack.common;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;

@Data
@Accessors(chain = true)
public class ServiceType {
    @Id
    private String id;
    private String name;
}
