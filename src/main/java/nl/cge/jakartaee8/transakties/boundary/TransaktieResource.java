package nl.cge.jakartaee8.transakties.boundary;

import nl.cge.jakartaee8.transakties.control.FindTransaktiesController;
import nl.cge.jakartaee8.transakties.control.MaandoverzichtController;
import nl.cge.jakartaee8.transakties.entity.Transaktie;
import nl.cge.jakartaee8.transakties.entity.ZoekOpdracht;
import nl.cge.jakartaee8.transakties.entity.ZoekResultaat;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
@Consumes("application/json")
@Produces("application/json")
@Path("transaktie")
public class TransaktieResource {

    @PersistenceContext(name = "my-pu")
    private EntityManager em;

    @Inject
    private FindTransaktiesController findTransaktiesController;

    @Inject
    private MaandoverzichtController maandoverzichtController;

    @GET
    public ZoekResultaat findAll() {
        return find(new ZoekOpdracht());
    }

    @POST
    public ZoekResultaat find(ZoekOpdracht zoekOpdracht) {
        List<Transaktie> transacties = findTransaktiesController.findTransacties(zoekOpdracht);
        ZoekResultaat zoekResultaat = new ZoekResultaat(transacties);
        if (zoekOpdracht.isZoekenOpTag() && !transacties.isEmpty()) {
            zoekResultaat.setMaandoverzicht(maandoverzichtController.aggregeer(transacties));
        }
        return zoekResultaat;
    }

    @POST
    @Path("addtag")
    public ZoekResultaat addTag(ZoekOpdracht zoekOpdracht) {
        List<Transaktie> transakties = findTransaktiesController.findTransacties(zoekOpdracht).stream()
                .map(tr -> tr.addTag(zoekOpdracht.getTag2add()))
                .collect(Collectors.toList());
        return new ZoekResultaat(transakties);
    }

}
