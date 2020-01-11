package nl.cge.jakartaee8.transakties.control;

import nl.cge.jakartaee8.transakties.entity.Transaktie;

import javax.inject.Inject;
import java.io.InputStream;
import java.util.List;

public class HandleFileUploadController {

    @Inject
    private TransaktieAssembler assembler;

    public void execute(InputStream inputStream) {
        List<Transaktie> transaktieList = assembler.assemble(inputStream);
        transaktieList.forEach(t -> System.out.println(t.toString()));
    }
}
