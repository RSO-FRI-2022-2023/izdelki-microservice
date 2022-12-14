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
import org.eclipse.microprofile.rest.client.inject.RestClient;
import si.fri.rso.zddt.common.models.Izdelek;
import si.fri.rso.zddt.common.models.PriljubljenIzdelek;
import si.fri.rso.zddt.izdelki.services.DTOs.IzdelekDTO;
import si.fri.rso.zddt.izdelki.services.beans.IzdelekBean;
import si.fri.rso.zddt.izdelki.services.clients.AsyncApi;
import si.fri.rso.zddt.izdelki.services.config.RestProperties;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.logging.Logger;

@Log
@ApplicationScoped
@Path("izdelki")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@CrossOrigin(supportedMethods = "GET, POST, PUT, DELETE, HEAD, OPTIONS")
public class IzdelekResource {

    @Inject
    @RestClient
    private AsyncApi asyncApi;

    @Context
    protected UriInfo uriInfo;

    @Inject
    private IzdelekBean izdelekBean;

    @Inject
    private RestProperties restProperties;

    private Logger log = Logger.getLogger(IzdelekResource.class.getName());

    @GET
    @Path("priljubljeni")
    public Response vrniPriljubljeneIzdelke() throws InterruptedException {

        CompletionStage<PriljubljenIzdelek[]> completionStage =
                asyncApi.getPriljubljeneIzdelkeAsync();

        CompletionStage<PriljubljenIzdelek[]> result = completionStage.whenComplete((s, throwable) -> log.severe("PODATKI PRIDOBLJENI"));
        completionStage.exceptionally(throwable -> {
            log.severe(throwable.getMessage());
            return null;
        });

        log.severe("PRED ODGOVOROM");
        return Response.status(Response.Status.OK).entity(result).build();
    }


    @Operation(description = "Vrne seznam izdelkov.", summary = "Seznam izdelkov")
    @APIResponses({
            @APIResponse(responseCode = "200",
                    description = "Seznam izdelkov.",
                    content = @Content(
                            schema = @Schema(implementation = Izdelek.class))
            ),
            @APIResponse(responseCode = "404", description = "Izdelki not found")
    })
    @GET
    public Response vrniIzdelke() {
        List<Izdelek> izdelki = izdelekBean.vrniIzdelke();
        return Response.status(Response.Status.OK).entity(izdelki).build();
    }

    @Operation(description = "Vrni podrobnosti izdelka.", summary = "Podrobnosti izdelka")
    @APIResponses({
            @APIResponse(responseCode = "200",
                    description = "Podrobnosti izdelka.",
                    content = @Content(
                            schema = @Schema(implementation = Izdelek.class))
            ),
            @APIResponse(responseCode = "404", description = "Izdelek ne obstaja")
    })
    @GET
    @Path("{id}")
    public Response vrniIzdelek(@Parameter(
            description = "Identifikator izdelka.",
            required = true)
                                @PathParam("id") int id) {
        Izdelek izdelek = izdelekBean.vrniIzdelek(id);
        if (izdelek != null) {
            return Response.status(Response.Status.OK).entity(izdelek).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @Operation(description = "Vrni podrobnosti izdelka.", summary = "Podrobnosti izdelka")
    @APIResponses({
            @APIResponse(responseCode = "200",
                    description = "Podrobnosti izdelka.",
                    content = @Content(
                            schema = @Schema(implementation = Izdelek.class))
            ),
            @APIResponse(responseCode = "404", description = "Izdelek ne obstaja")
    })
    @GET
    @Path("/kategorija/{kategorija}")
    public Response vrniIzdelkeKategorije(@Parameter(
            description = "Kategorija izdelka.",
            required = true) @PathParam("kategorija") String kategorija) {
        List<Izdelek> izdelki = izdelekBean.vrniIzdelke(kategorija);
        if (izdelki != null) {
            return Response.status(Response.Status.OK).entity(izdelki).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @Operation(description = "Dodaj izdelek.", summary = "Dodajanje izdelka")
    @APIResponses({
            @APIResponse(responseCode = "201",
                    description = "Izdelek uspe??no dodan."
            ),
            @APIResponse(responseCode = "405", description = "Validacijska napaka."),
    })
    @POST
    public Response dodajIzdelek(@RequestBody(
            description = "DTO objekt s podrobnostmi izdelka.",
            required = true,
            content = @Content(
                    schema = @Schema(implementation = Izdelek.class))) IzdelekDTO izdelekDTO) {
        Izdelek i = new Izdelek();
        i.setKategorija(izdelekDTO.getKategorija());
        i.setNaziv(izdelekDTO.getNaziv());
        i = izdelekBean.dodajIzdelek((i));
        if (i != null) {
            return Response.status(Response.Status.CREATED).entity(i).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @Operation(description = "Izbri??i izdelek.", summary = "Brisanje izdelka")
    @APIResponses({
            @APIResponse(
                    responseCode = "204",
                    description = "Izdelek uspe??no izbrisan."
            ),
            @APIResponse(
                    responseCode = "404",
                    description = "Izdelek ne obstaja.")
    })
    @DELETE
    @Path("{id}")
    public Response odstraniIzdelek(@Parameter(
            description = "Identifikator izdelka za brisanje.",
            required = true)
                                    @PathParam("id") int id) {
        var success = izdelekBean.odstraniIzdelek(id);
        if (success) {
            return Response.status(Response.Status.OK).entity(true).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }


}
