package io.ctl.globalhack.common;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@Accessors(chain = true)
public class NeedServiceOrg {

    @Id
    private String id;
    private String name;
    private List<Service> offer;
    private List<Service> available;
    private List<Service> inUse;
}
