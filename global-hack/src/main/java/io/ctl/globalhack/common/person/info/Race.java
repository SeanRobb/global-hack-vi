package io.ctl.globalhack.common.person.info;

/**
 * Created by sean on 10/22/16.
 */
public enum Race {
    AmIndAKNative(1), Asian(2), Black(3), NativeHIOtherPacific(4), White(5),

    Client_Does_Not_Know(8), Client_Refused(9), Data_Not_Collected(99);

    private Integer value;

    Race(Integer value) {
        this.value = value;
    }

    public Integer get() {
        return value;
    }
}
