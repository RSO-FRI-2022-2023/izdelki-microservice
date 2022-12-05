package si.fri.rso.zddt.izdelki.api.v1.resources;

import com.kumuluz.ee.cors.annotations.CrossOrigin;
import com.kumuluz.ee.logs.cdi.Log;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import si.fri.rso.zddt.common.models.Trgovina;
import si.fri.rso.zddt.izdelki.services.DTOs.TrgovinaDTO;
import si.fri.rso.zddt.izdelki.services.DTOs.TrgovinaDistanceDTO;
import si.fri.rso.zddt.izdelki.services.beans.TrgovinaBean;
import si.fri.rso.zddt.izdelki.services.clients.DistanceClient;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;

@Log
@ApplicationScoped
@Path("trgovine")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@CrossOrigin(supportedMethods = "GET, POST, PUT, DELETE, HEAD, OPTIONS")
public class TrgovinaResource {

    @Context
    protected UriInfo uriInfo;

    @Inject
    private TrgovinaBean trgovinaBean;

    @Inject
    private DistanceClient distanceClient;

    @Operation(description = "Vrne seznam trgovin.", summary = "Seznam trgovin")
    @APIResponses({
            @APIResponse(responseCode = "200",
                    description = "Seznam trgovin.",
                    content = @Content(
                            schema = @Schema(implementation = Trgovina.class))
            ),
            @APIResponse(responseCode = "404", description = "Trgovine not found")
    })
    @GET
    public Response vrniTrgovine() {
        List<Trgovina> trgovine = (List<Trgovina>) trgovinaBean.vrniTrgovine();
        return Response.status(Response.Status.OK).entity(trgovine).build();
    }

    @Operation(description = "Vrne podrobnosti trgovine.", summary = "Podrobnosti trgovine")
    @APIResponses({
            @APIResponse(responseCode = "200",
                    description = "Podrobnosti trgovine.",
                    content = @Content(
                            schema = @Schema(implementation = Trgovina.class))
            ),
            @APIResponse(responseCode = "404", description = "Trgovina ne obstaja")
    })
    @GET
    @Path("{id}")
    public Response vrniTrgovino(@Parameter(
            description = "Identifikator trgovine.",
            required = true)
                                 @PathParam("id") int id) {
        Trgovina trgovina = trgovinaBean.vrniTrgovino(id);
        if (trgovina != null) {
            return Response.status(Response.Status.OK).entity(trgovina).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @Operation(description = "Vrne podrobnosti trgovine glede na ime trgovine.", summary = "Podrobnosti trgovine ime")
    @APIResponses({
            @APIResponse(responseCode = "200",
                    description = "Podrobnosti trgovine.",
                    content = @Content(
                            schema = @Schema(implementation = Trgovina.class))
            ),
            @APIResponse(responseCode = "404", description = "Trgovina ne obstaja")
    })
    @GET
    @Path("/ime/{ime}")
    public Response vrniTrgovino(@Parameter(
            description = "Identifikator trgovine.",
            required = true)
                                 @PathParam("ime") String ime) {
//        logger.log(Level.ALL, ime);
        Trgovina trgovina = trgovinaBean.vrniTrgovino(ime);
        if (trgovina != null) {
            return Response.status(Response.Status.OK).entity(trgovina).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @Operation(description = "Dodaj trgovino.", summary = "Dodajanje trgovine")
    @APIResponses({
            @APIResponse(responseCode = "201",
                    description = "Trgovina uspešno dodana."
            ),
            @APIResponse(responseCode = "405", description = "Validacijska napaka."),
    })
    @POST
    public Response dodajTrgovino(@RequestBody(
            description = "DTO bbjekt s podrobnostmi trgovine.",
            required = true,
            content = @Content(
                    schema = @Schema(implementation = Trgovina.class))) TrgovinaDTO trgovinaDTO) {
        Trgovina t = new Trgovina();
        t.setIme(trgovinaDTO.getIme());
        t.setLokacija(trgovinaDTO.getLokacija());
        t = trgovinaBean.dodajTrgovino((t));
        if (t != null) {
            return Response.status(Response.Status.CREATED).entity(t).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    //vrni najbližjo trgovino
    @Operation(description = "Vrni najbližjo trgovino", summary = "Vrni najbližjo trgovino\"")
    @APIResponses({
            @APIResponse(responseCode = "200",
                    description = "Vrnjena najbližja trgovina"
            ),
            @APIResponse(responseCode = "405", description = "Validacijska napaka."),
    })

    @GET
    @Path("/najblizja/{lat}/{lng}")
    public Response najblizjaTrgovina(@Parameter(
            description = "Latitude trenutne lokacije",
            required = true)
                                          @PathParam("lat") double lat, @Parameter(
            description = "Longitude trenutne lokacije",
            required = true)
            @PathParam("lng") double lng) {

        var trgovina = distanceClient.vrniNajblizjo(lat,lng);


        if (trgovina != null) {
            return Response.status(Response.Status.CREATED).entity(trgovina).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }



    @Operation(description = "Izbriši trgovino.", summary = "Brisanje trgovine")
    @APIResponses({
            @APIResponse(
                    responseCode = "204",
                    description = "Trgovina uspešno izbrisana."
            ),
            @APIResponse(
                    responseCode = "404",
                    description = "Trgovina ne obstaja.")
    })
    @DELETE
    @Path("{id}")
    public Response odstraniTrgovino(@Parameter(
            description = "Identifikator trgovine za brisanje.",
            required = true)
                                     @PathParam("id") int id) {
        var success = trgovinaBean.odstraniTrgovino(id);
        if (success) {
            return Response.status(Response.Status.OK).entity(true).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }


}
