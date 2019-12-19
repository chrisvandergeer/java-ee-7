package nl.cge.jakartaee8.jaxrs20.boundary;

import nl.cge.jakartaee8.jaxrs20.entity.InputDto;
import nl.cge.jakartaee8.jaxrs20.entity.OutputDto;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

import static java.math.RoundingMode.CEILING;
import static java.time.temporal.TemporalAdjusters.firstDayOfMonth;

@Stateless
@Consumes("application/json")
@Produces("application/json")
@Path("myjaxrs")
public class MyJaxrsResource {

    @POST
    public Response doPost(InputDto inputDto) {
        LocalDate localDate = new Date(inputDto.getDatum().getTime()).toLocalDate().with(firstDayOfMonth());
        OutputDto outputDto = new OutputDto(
                Date.valueOf(localDate),
                inputDto.getBedrag().multiply(BigDecimal.valueOf(2)).setScale(2, CEILING)
        );
        return Response.ok(outputDto).build();
    }

}
