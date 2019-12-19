package nl.cge.jakartaee8.batch.control.batch;

import nl.cge.jakartaee8.batch.entity.MyEntity;

import javax.batch.api.AbstractBatchlet;
import javax.batch.runtime.BatchStatus;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.stream.IntStream;

@Named
public class PrepareBatch extends AbstractBatchlet {

    @PersistenceContext(name = "my-pu")
    private EntityManager em;

    @Transactional(Transactional.TxType.REQUIRED)
    @Override
    public String process() {
        IntStream.range(0, 100).boxed()
                .map(i -> new MyEntity())
                .forEach(entity -> em.persist(entity));
        return BatchStatus.COMPLETED.name();
    }

}
