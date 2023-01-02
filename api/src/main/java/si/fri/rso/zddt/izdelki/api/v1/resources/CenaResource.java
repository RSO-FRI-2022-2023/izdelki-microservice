package si.fri.rso.zddt.izdelki.api.v1.resources;

import com.kumuluz.ee.cors.annotations.CrossOrigin;
import com.kumuluz.ee.logs.cdi.Log;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import si.fri.rso.zddt.common.models.Cena;
import si.fri.rso.zddt.izdelki.services.DTOs.CenaDTO;
import si.fri.rso.zddt.izdelki.services.beans.CenaBean;
import si.fri.rso.zddt.izdelki.services.beans.IzdelekBean;
import si.fri.rso.zddt.izdelki.services.beans.TrgovinaBean;
import si.fri.rso.zddt.izdelki.services.config.RestProperties;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;
import java.util.logging.Level;

@Slf4j
@Log
@ApplicationScoped
@Path("cene")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@CrossOrigin(supportedMethods = "GET, POST, PUT, DELETE, HEAD, OPTIONS")
public class CenaResource {

    @Context
    protected UriInfo uriInfo;

    @Inject
    private CenaBean cenaBean;

    @Inject
    private IzdelekBean izdelekBean;

    @Inject
    private TrgovinaBean trgovinaBean;

    @Inject
    private RestProperties restProperties;

    @Operation(description = "Vrne seznam cen.", summary = "Seznam cen")
    @APIResponse(responseCode = "200",
            description = "Seznam cen.",
            content = @Content(
                    schema = @Schema(implementation = Cena.class))
    )
    @APIResponse(responseCode = "404", description = "Cena not found")
    @GET
    public Response vrniCene() {
        double factor = 1.0;
        if(restProperties.getDiscount()){
            factor = 0.1;
            log.info("DISCOUNT is SET");
            cenaBean.popust(factor);
        }else{
            factor = 0;
            log.info("DISCOUNT RESET");
        }
        cenaBean.popust(factor);
        List<Cena> cene = cenaBean.vrniVseCene();
        return Response.status(Response.Status.OK).entity(cene).build();
    }

    @Operation(description = "Vrni cene izdelka.", summary = "Cene izdelka ")
    @APIResponse(responseCode = "200",
            description = "Cene izdelka.",
            content = @Content(
                    schema = @Schema(implementation = Cena.class))
    )
    @APIResponse(responseCode = "404", description = "Izdelek ne obstaja")
    @GET
    @Path("izdelek/{id}")
    public Response vrniCeneIzdelka(@Parameter(
            description = "Identifikator izdelka.",
            required = true)
                                    @PathParam("id") int id) {
        List<Cena> cene = cenaBean.vrniCeneIzdelka(id);
        if (cene != null) {
            return Response.status(Response.Status.OK).entity(cene).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @Operation(description = "Vrni ceno.", summary = "Cena ")
    @APIResponse(responseCode = "200",
            description = "Cena.",
            content = @Content(
                    schema = @Schema(implementation = Cena.class))
    )
    @APIResponse(responseCode = "404", description = "Cena ne obstaja")
    @GET
    @Path("{id}")
    public Response vrniCeno(@Parameter(
            description = "Identifikator cene.",
            required = true)
                             @PathParam("id") int id) {
        Cena cena = cenaBean.vrniCeno(id);
        if (cena != null) {
            return Response.status(Response.Status.OK).entity(cena).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @Operation(description = "Dodaj ceno trgovine.", summary = "Dodajanje cene trgovine")
    @APIResponse(responseCode = "201",
            description = "Cena uspešno dodana."
    )
    @APIResponse(responseCode = "405", description = "Validacijska napaka.")
    @POST
    public Response dodajCeno(@RequestBody(
            description = "DTO objekt s podatki o ceni izdelka dolocene trgovine",
            required = true,
            content = @Content(
                    schema = @Schema(implementation = Cena.class))) CenaDTO cenaDTO) {
        Cena cena = new Cena();
        cena.setCena(cenaDTO.getCena());
        cena.setIzdelek(izdelekBean.vrniIzdelek(cenaDTO.getIzdelek_id()));
        cena.setTrgovina(trgovinaBean.vrniTrgovino(cenaDTO.getTrgovina_id()));

        cena = cenaBean.dodajCeno((cena));
        if (cena != null) {
            return Response.status(Response.Status.CREATED).entity(cena).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @Operation(description = "Izbriši ceno.", summary = "Brisanje cene")
    @APIResponse(
            responseCode = "204",
            description = "Cena uspešno izbrisana."
    )
    @APIResponse(
            responseCode = "404",
            description = "Cena ne obstaja.")
    @DELETE
    @Path("{id}")
    public Response odstraniCeno(@Parameter(
            description = "Identifikator cene za brisanje.",
            required = true)
                                 @PathParam("id") int id) {
        var success = cenaBean.odstraniCeno(id);
        if (success) {
            return Response.status(Response.Status.OK).entity(success).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
