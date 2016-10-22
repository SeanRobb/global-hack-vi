package io.ctl.globalhack.common.person.info.exit.info;


public enum  HousingAssesment {
    Maintained_Housing (1),
    New_Housing (2),
    Family_Friends_Temp (3),
    Family_Friends_Perm (4),
    Transitional_Temp_Housing (5),
    Became_Homeless (6),
    Jail (7),
    Deceased (10),
    Client_Does_Not_Know(8), Client_Refused(9), Data_Not_Collected(99);


    private Integer value;

    HousingAssesment(Integer value) {
        this.value = value;
    }

    public Integer get() {
        return value;
    }
}
