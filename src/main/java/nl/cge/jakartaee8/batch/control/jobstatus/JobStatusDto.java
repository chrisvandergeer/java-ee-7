package nl.cge.jakartaee8.batch.control.jobstatus;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class JobStatusDto {

    private String jobName;
    private String batchStatus;
    private String exitStatus;
    private Date startTime;
    private Date endTime;
}
