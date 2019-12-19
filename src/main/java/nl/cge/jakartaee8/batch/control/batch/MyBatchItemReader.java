package nl.cge.jakartaee8.batch.control.batch;

import nl.cge.jakartaee8.batch.entity.MyEntity;

import javax.batch.api.chunk.AbstractItemReader;
import javax.batch.runtime.context.JobContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Named
public class MyBatchItemReader extends AbstractItemReader {

    @PersistenceContext(name = "my-pu")
    private EntityManager em;

    @Inject
    JobContext jobContext;

    @Override
    public MyEntity readItem() throws Exception {
        return em.createQuery(
                "select e from MyEntity e where e.calculatedUuid is null", MyEntity.class)
                .setMaxResults(1)
                .getResultList()
                .stream().findAny().orElse(null);

    }

}
