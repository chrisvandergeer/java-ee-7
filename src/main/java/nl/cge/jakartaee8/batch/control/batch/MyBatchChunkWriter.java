package nl.cge.jakartaee8.batch.control.batch;

import nl.cge.jakartaee8.batch.entity.MyEntity;

import javax.batch.api.chunk.AbstractItemWriter;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Named
public class MyBatchChunkWriter extends AbstractItemWriter {

    @PersistenceContext(name = "my-pu")
    private EntityManager em;

    @Override
    public void writeItems(List<Object> list) throws Exception {
        list.stream()
                .map(obj -> (MyEntity) obj)
                .forEach(entity -> em.persist(entity));
    }

}
