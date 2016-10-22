package io.ctl.globalhack.common.person.info;

/**
 * Created by sean on 10/22/16.
 */
public enum Gender {
    Male(1), Female(0),
    Transgender_male_to_female(2), Transgender_female_to_male(3),
    Does_not_identify_as_male_or_female(4),
    Client_Does_Not_Know(8), Client_Refused(9), Data_Not_Collected(99);

    private Integer value;

    Gender(Integer value) {
        this.value = value;
    }

    public Integer get() {
        return value;
    }
}
