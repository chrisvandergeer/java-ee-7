package nl.cge.jakartaee8.jaxrs20.boundary;

import nl.cge.jakartaee8.jaxrs20.entity.InputDto;
import nl.cge.jakartaee8.jaxrs20.entity.OutputDto;

import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;

@Stateless
@Consumes("application/json")
@Produces("application/json")
@Path("myjaxrs")
public class MyJaxrsResource {

    @GET
    public Response handleGet() {
        InputDto inputDto = new InputDto("geerc01", UUID.randomUUID().toString());
        Entity<InputDto> entity = Entity.entity(inputDto, MediaType.APPLICATION_JSON_TYPE);
        Response response = ClientBuilder.newClient()
                .target("http://localhost:9080/java_ee_7_war_exploded/resources/myjaxrs/internal")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .post(entity);
        OutputDto result = response.readEntity(OutputDto.class);
        System.out.println(result.getJsonWebToken());
        return Response.ok(result).build();
    }

    @Path("internal")
    @POST
    public Response internalPost(InputDto inputDto) {
        System.out.println(inputDto);
        OutputDto result = new OutputDto(UUID.randomUUID().toString());
        return Response.ok(result).build();
    }

}
