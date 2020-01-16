package nl.cge.jakartaee8.transakties.boundary;

import nl.cge.jakartaee8.transakties.entity.Transaktie;
import nl.cge.jakartaee8.transakties.entity.ZoekOpdracht;

import javax.ejb.Stateless;
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

    @GET
    public List<Transaktie> findAll() {
        return find(new ZoekOpdracht());
    }

    @POST
    public List<Transaktie> find(ZoekOpdracht zoekOpdracht) {
        List<Transaktie> transakties = em.createQuery("select t from Transaktie t order by t.volgnummer desc", Transaktie.class)
                .getResultList()
                .stream()
                .filter(tr -> !zoekOpdracht.isZoekenOpTegenpartij() || tr.isTegenpartij(zoekOpdracht.getTegenpartij()))
                .filter(tr -> !zoekOpdracht.isZoekenOpOmschrijving() || tr.isOmschrijving(zoekOpdracht.getOmschrijving()) )
                .collect(Collectors.toList());
        return transakties;
    }
}
