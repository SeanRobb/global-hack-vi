package io.ctl.globalhack.common.person.info;

/**
 * Created by sean on 10/22/16.
 */
public enum  Ethnicity {
    Non_Hispanic_Non_Latino (0),
    Hispanic_Latino (1),

    Client_Does_Not_Know(8), Client_Refused(9), Data_Not_Collected(99);

    private Integer value;

    Ethnicity(Integer value) {
        this.value = value;
    }

    public Integer get() {
        return value;
    }
}
