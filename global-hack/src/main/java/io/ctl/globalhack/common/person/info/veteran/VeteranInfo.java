package io.ctl.globalhack.common.person.info.veteran;

import io.ctl.globalhack.common.person.info.BasicInfo;
import lombok.Data;

import java.util.Date;

@Data
public class VeteranInfo extends BasicInfo {
    private Date YearEnteredService;
    private Date YearSeparated;
    private Theater theater;
    private MilitaryBranch militaryBranch;
    private DischargeStatus dischargeStatus;
}
