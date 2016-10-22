package io.ctl.globalhack.common.person.info.income.benifits;

import io.ctl.globalhack.common.person.info.Status;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class IncomeStream {
    private String name;
    private Status status;
    private BigDecimal amount;
}
