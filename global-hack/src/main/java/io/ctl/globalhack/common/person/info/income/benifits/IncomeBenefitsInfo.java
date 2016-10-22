package io.ctl.globalhack.common.person.info.income.benifits;

import io.ctl.globalhack.common.person.info.BasicInfo;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class IncomeBenefitsInfo extends BasicInfo {
    private Date informationDate;
    private IncomeStream incomeFromAnySource;
    private List<IncomeStream> incomeStreams;
    private BenifitStream benifitFromAnySource;
    private List<BenifitStream> benifitStreams;
    private InsuranceStream insuranceFromAnySource;
    private List<InsuranceStream> insuranceStreams;
    private DataCollectionStage dataCollectionStage;
}
