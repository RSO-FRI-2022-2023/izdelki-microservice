package si.fri.rso.zddt.izdelki.api.v1.resources;
import com.kumuluz.ee.logs.cdi.Log;
import si.fri.rso.zddt.izdelki.services.config.RestProperties;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.logging.Logger;

@ApplicationScoped
@Log
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("health")
public class BreakResource {


    private Logger log = Logger.getLogger(BreakResource.class.getName());

    @Inject
    private RestProperties restProperties;

    @POST
    @Path("break")
    public Response makeUnhealthy() {

        restProperties.setBroken(true);

        return Response.status(Response.Status.OK).build();
    }

    @POST
    @Path("repair")
    public Response makeHealthy() {

        restProperties.setBroken(false);

        return Response.status(Response.Status.OK).build();
    }
}

