package nl.cge.jakartaee8.batch.control.batch;

import nl.cge.jakartaee8.batch.entity.MyEntity;

import javax.batch.api.chunk.ItemProcessor;
import javax.inject.Named;

@Named
public class MyBatchItemProcessor implements ItemProcessor {

    @Override
    public MyEntity processItem(Object obj) throws Exception {
        MyEntity myEntity = (MyEntity) obj;
        myEntity.setCalculatedUuid(calculateUuid(myEntity));
        return myEntity;
    }

    private String calculateUuid(MyEntity myEntity) {
        MyEntity otherEntity = new MyEntity();
        while (myEntity.hashCode() != otherEntity.hashCode()) {
            otherEntity = new MyEntity();
        }
        return otherEntity.getUuid();
    }

}
