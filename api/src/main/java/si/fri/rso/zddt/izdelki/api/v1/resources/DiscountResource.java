package si.fri.rso.zddt.izdelki.api.v1.resources;

import com.kumuluz.ee.logs.cdi.Log;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import si.fri.rso.zddt.common.models.Cena;
import si.fri.rso.zddt.izdelki.services.beans.CenaBean;
import si.fri.rso.zddt.izdelki.services.config.RestProperties;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.logging.Level;
import java.util.logging.Logger;

@Log
@ApplicationScoped
@Path("/discount")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DiscountResource {

    private Logger log = Logger.getLogger(DiscountResource.class.getName());

    @Inject
    private RestProperties restProperties;

    @Inject
    private CenaBean cenaBean;


    @Operation(description = "Spremeni popust", summary = "Spremeni popust")
    @APIResponse(responseCode = "200",
            description = "Popust upoštevan"
    )
    @APIResponse(responseCode = "404", description = "Error")
    @POST
    @Path("discount")
    public Response dodajPopust() {
        double factor = 1.0;
        if(restProperties.getDiscount()){
            factor = 0.1;
            log.log(Level.INFO, "DISCOUNT APPLIED");
        }else{
            factor = 0;
            log.log(Level.INFO, "DISCOUNT RESET");
        }
        cenaBean.popust(factor);
        return Response.status(Response.Status.OK).build();
    }

}