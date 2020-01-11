package nl.cge.jakartaee8.batch.control.jobstatus;

import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.batch.runtime.JobExecution;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class JobStatusController {

    public List<JobStatusDto> getStatussen() {
        JobOperator jobOperator = BatchRuntime.getJobOperator();
        return jobOperator.getJobNames().stream()
                .flatMap(jobName -> jobOperator.getJobInstances(jobName, 0, 25).stream())
                .map(jobInstance -> jobOperator.getJobExecution(jobInstance.getInstanceId()))
                .map(this::map)
                .collect(Collectors.toList());
    }

    private JobStatusDto map(JobExecution jobExecution) {
        JobStatusDto dto = new JobStatusDto();
        dto.setExecutionId(jobExecution.getExecutionId());
        dto.setJobName(jobExecution.getJobName());
        dto.setBatchStatus(jobExecution.getBatchStatus().name());
        dto.setExitStatus(jobExecution.getExitStatus());
        dto.setStartTime(new java.sql.Date(jobExecution.getStartTime().getTime()).toLocalDate());
        Date endTime = jobExecution.getEndTime();
        if (endTime != null) {
            dto.setEndTime(new java.sql.Date(endTime.getTime()).toLocalDate());
        }
        return dto;
    }
}
