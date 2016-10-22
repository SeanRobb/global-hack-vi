package io.ctl.globalhack.common.person.info.enrollment;

import io.ctl.globalhack.common.Address;
import io.ctl.globalhack.common.person.info.BasicInfo;
import io.ctl.globalhack.common.person.info.Status;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class EnrollmentInfo extends BasicInfo {
    private RelationshipToHOH relationshipToHOH;
    private LengthOfStay lengthOfStay;
    private AmountOfTimesOnStreets amountOfTimesOnStreets;
    private ResidenceType residenceType;
    private TimeOnStreets timeOnStreets;
    private Status disablingCondition;
    private Status inPermanentHousing;
    private ESSHInfo esshInfo;
    private Date dateOfEngagement;
    private Date residentialMoveInDate;
    private PathInfo pathInfo;
    private String worstHousingSituation;
    private BigDecimal percentAMI;
    private Address lastPermanentAddress;
    private BigDecimal HPScreeningScore;
    private String VAMCStation;
}
