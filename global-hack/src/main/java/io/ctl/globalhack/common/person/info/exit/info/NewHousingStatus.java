package io.ctl.globalhack.common.person.info.exit.info;


public enum  NewHousingStatus {
    With_On_Going_Subsidy (1),
    With_Out_On_Going_Subsidy (2);


    private Integer value;

    NewHousingStatus(Integer value) {
        this.value = value;
    }

    public Integer get() {
        return value;
    }
}
