package io.ctl.globalhack.common;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class NeedService {

    @Id
    private String id;
}
