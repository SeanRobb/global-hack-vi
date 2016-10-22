package io.ctl.globalhack.common.person.info.exit.info;

public enum  MaintainHousingStatus {
    With_Out_Subsidy (1),
    With_Previous_Subsidy (2),
    With_Acquired_Subsidy (3),
    Other_Financial_Assistance (4);

    private Integer value;

    MaintainHousingStatus(Integer value) {
        this.value = value;
    }

    public Integer get() {
        return value;
    }
}
