package io.ctl.globalhack.common.person.info.income.benifits;

public enum DataCollectionStage {

    Project_Entry(0),
    Project_Update(1),
    Project_Annual_Assessment(5),
    Project_Exit(3);

    private Integer value;

    DataCollectionStage(Integer value) {
        this.value = value;
    }

    public Integer get() {
        return value;
    }
}
