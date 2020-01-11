package nl.cge.jakartaee8.batch.control.jobstatus;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class JobStatusDto {

    private Long executionId;
    private String jobName;
    private String batchStatus;
    private String exitStatus;
    private LocalDate startTime;
    private LocalDate endTime;
}
