package io.ctl.globalhack.common.person.info.exit.info;

/**
 * Created by sean on 10/22/16.
 */
public enum AssessmentDisposition {
    Emergency_Shelter_Safe_Haven(1),
    Traditional_Housing(2),
    Rapid_Rehousing(3),
    Permanent_Supportive_Housing(4),
    Refered_To_Homeless_Prevention(5),
    Street_Outreach(6),
    Other_Continuum_Project(7),
    Homelessness_Diversion_Program(8),
    Continuum_Ineligible (9),
    Continuum_Unavailable (10),
    Other_Community_Program (11),
    Declined_Referral (12),
    Terminated_Assement(13),
    Other(14);


    private Integer value;

    AssessmentDisposition(Integer value) {
        this.value = value;
    }

    public Integer get() {
        return value;
    }
}
