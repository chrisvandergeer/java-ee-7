package nl.cge.jakartaee8.batch.boundary;

import nl.cge.jakartaee8.batch.control.jobstatus.JobStatusController;

import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.Properties;

@Stateless
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

}
