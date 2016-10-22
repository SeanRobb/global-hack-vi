package io.ctl.globalhack.common.person.info.exit.info;

public enum ProjectCompletionStatus {
    Completed_Project (1),
    Youth_Left_Early (2),
    Youth_Expelled (3);

    private Integer value;

    ProjectCompletionStatus(Integer value) {
        this.value = value;
    }

    public Integer get() {
        return value;
    }
}
