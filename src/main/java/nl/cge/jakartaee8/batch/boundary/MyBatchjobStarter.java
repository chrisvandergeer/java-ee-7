package nl.cge.jakartaee8.batch.boundary;

import nl.cge.jakartaee8.batch.control.jobstatus.JobStatusController;
import nl.cge.jakartaee8.batch.control.jobstatus.JobStatusDto;

import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.batch.runtime.JobExecution;
import javax.batch.runtime.JobInstance;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.Properties;

@Stateless
@Consumes("application/json")
@Produces("application/json")
@Path("mybatchjob")
public class MyBatchjobStarter {

    @Inject
    private JobStatusController jobStatusController;

    @PersistenceContext(name = "my-pu")
    private EntityManager em;

    /**
     * Geeft de status van alle batchjobs terug.
     */
    @Path("status")
    @GET
    public Response status() {
        return Response.ok(jobStatusController.getStatussen()).build();
    }

    /**
     * Start de batchjob.
     */
    @Path("start")
    @GET
    public Response startBatch() {
        JobOperator jobOperator = BatchRuntime.getJobOperator();
        long batchjobId = jobOperator.start("myBatchJob", new Properties());
        return Response.ok(jobStatusController.getStatussen()).build();
    }

    @Path("stop")
    @POST
    public Response stopBatch(JobStatusDto jobStatusDto) {
        JobOperator jobOperator = BatchRuntime.getJobOperator();
        jobOperator.stop(jobStatusDto.getExecutionId());
        return Response.ok(jobStatusController.getStatussen()).build();
    }

    @Path("restart")
    @POST
    public Response restartBatch(JobStatusDto jobStatusDto) {
        JobOperator jobOperator = BatchRuntime.getJobOperator();
        jobOperator.restart(jobStatusDto.getExecutionId(), new Properties());
        return Response.ok(jobStatusController.getStatussen()).build();
    }

}
