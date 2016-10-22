package io.ctl.globalhack.common.person.info.exit.info;

public enum LeftEarlyReason {
    Independant_Living(1),
    Education(2),
    Military(3),
    Other(4),
    Needs_Not_Met(5);

    private Integer value;

    LeftEarlyReason(Integer value) {
        this.value = value;
    }

    public Integer get() {
        return value;
    }
}
