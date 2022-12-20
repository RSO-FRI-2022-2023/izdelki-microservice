package si.fri.rso.zddt.izdelki.api.v1.resources;
import com.kumuluz.ee.logs.cdi.Log;
import si.fri.rso.zddt.izdelki.services.clients.DistanceClient;
import si.fri.rso.zddt.izdelki.services.clients.FaultToleranceExampleClient;
import si.fri.rso.zddt.izdelki.services.config.RestProperties;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.logging.Logger;

@ApplicationScoped
@Log
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("fault-tolerance")
public class FaultToleranceExample {


    private Logger log = Logger.getLogger(FaultToleranceExample.class.getName());

    @Inject
    private FaultToleranceExampleClient faultToleranceExampleClient;

    @GET
    public Response simulateFaultTolerance() {

        var a= faultToleranceExampleClient.getSteviloPriljubljenihIzdelkov();
        return Response.status(Response.Status.OK).entity(a).build();
    }

}

