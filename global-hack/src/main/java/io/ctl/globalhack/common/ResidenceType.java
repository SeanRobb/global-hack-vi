package io.ctl.globalhack.common;

public enum ResidenceType {

    Deceased(24),
    Place_Not_Meant_For_Habitation(16),
    Emergency_Shelter(1),
    Safe_Haven(18),
    Interim_Housing(27),
    Foster_Care_Home(15),
    Non_Psychiatric_Hospital(6),
    Jail(7),
    Longterm_Care_Facility(25),
    Psychiatric_Hospital(4),
    Substance_Abuse_Treatment_Facility(5),
    Hotel_With_Out_Voucher(14),
    Owned_No_Subsidy(11),
    Owned_With_Subsidy(21),
    Perm_Housing_For_Previous_Homeless(3),
    Rent_No_Subsidy(10),
    Rent_With_VASH_Subsidy(19),
    Rent_With_GDP_TIP_Subsidy(28),
    Rent_With_Other_Subsidy(20),
    Residential_Project_OR_Halfway_House(29),
    Family_Residence(12),
    Family_Residence_Perm(22),
    Family_Residence_Temp(12),
    Friend_Residence(13),
    Friend_Residence_Perm(23),
    Friend_Residence_Temp(13),
    Transitional_Housing_For_Homeless(2),
    Moved_From_HOPWA_to_HOPWA_TN(27),
    Moved_From_HOPWA_to_HOPWA_PH(26),
    Other(17),
    No_Exit_Interview(30),

    Client_Does_Not_Know(8), Client_Refused(9), Data_Not_Collected(99);


    private Integer value;

    ResidenceType(Integer value) {
        this.value = value;
    }

    public Integer get() {
        return value;
    }
}
