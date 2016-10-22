package io.ctl.globalhack.common.person.info.exit.info;

/**
 * Created by sean on 10/22/16.
 */
public enum  ExpelledReason {
    Criminal_Activity_Violence (1),
    Non_Compliance (2),
    Non_Payment(3),
    Max_Time_Reached(4),
    Project_Terminated(5),
    Unknown(6);

    private Integer value;

    ExpelledReason(Integer value) {
        this.value = value;
    }

    public Integer get() {
        return value;
    }
}
