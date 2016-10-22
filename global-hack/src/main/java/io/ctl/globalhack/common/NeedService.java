package io.ctl.globalhack.common;

import com.ctlts.wfaas.data.orchestrate.repository.Collection;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;

@Data
@Accessors(chain = true)
public class NeedService {

    @Id
    private String id;
}
