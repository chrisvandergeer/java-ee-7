package nl.cge.jakartaee8.batch.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
public class MyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String uuid;

    @Column
    private String calculatedUuid;

    public MyEntity() {
        this.uuid = UUID.randomUUID().toString();
    }

    @Override
    public int hashCode() {
        return uuid.substring(0, 5).hashCode();
    }

}
