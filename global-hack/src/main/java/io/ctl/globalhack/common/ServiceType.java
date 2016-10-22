package io.ctl.globalhack.common;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class ServiceType {
    @Id
    private String id;

    private String name;
}
