package io.ctl.globalhack.common;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@Accessors(chain = true)
public class Service {
    private String name;
    private BigDecimal amount;
}
