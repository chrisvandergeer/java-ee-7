package nl.cge.jakartaee8.transakties.control;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.InputStream;

@Stateless
public class HandleFileUploadController {

    @Inject
    private TransaktieAssembler assembler;

    @PersistenceContext(name = "my-pu")
    private EntityManager em;

    public void execute(InputStream inputStream) {
        assembler.assemble(inputStream).forEach(transaktie -> em.persist(transaktie));
    }
}
