package io.ctl.globalhack.common.person.info.veteran;

import io.ctl.globalhack.common.person.info.Status;
import lombok.Data;

@Data
public class Theater {
    private Status worldWarII;
    private Status koreanWar;
    private Status vietnamWar;
    private Status desertStorm;
    private Status afghanistanOEF;
    private Status iraqOIF;
    private Status iraqOND;
    private Status otherTheater;

}
