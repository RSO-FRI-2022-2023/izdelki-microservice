package si.fri.rso.zddt.izdelki.api.v1.resources;
import com.kumuluz.ee.logs.cdi.Log;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.eclipse.microprofile.faulttolerance.Bulkhead;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;
import si.fri.rso.zddt.izdelki.services.clients.DistanceClient;
import si.fri.rso.zddt.izdelki.services.clients.FaultToleranceExampleClient;
import si.fri.rso.zddt.izdelki.services.config.RestProperties;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.time.temporal.ChronoUnit;
import java.util.logging.Logger;

@RequestScoped
@Log
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("fault-tolerance")
public class FaultToleranceExample {


    private Logger log = Logger.getLogger(FaultToleranceExample.class.getName());

    @Inject
    FaultToleranceExampleClient faultToleranceExampleClient;

    @GET
    public Response simulateFaultTolerance() {

//        var a= faultToleranceExampleClient.getSteviloPriljubljenihIzdelkov();
        var a = test();
        return Response.status(Response.Status.OK).entity(a).build();
    }
    private Integer test(){
        return faultToleranceExampleClient.getSteviloPriljubljenihIzdelkov();
    }

//    public int fallback() {
//        log.info("In FALLBACK method");
//        return -1;
//    }

//    @Timeout(value = 1, unit = ChronoUnit.SECONDS)
//    @CircuitBreaker(requestVolumeThreshold = 5, successThreshold = 2, failureRatio = 0.5)
//    @Fallback(fallbackMethod = "fallback")
//    public int getSteviloPriljubljenihIzdelkov(){
//
//        log.info("Calling fake service");
//        int a = 1/0;
//        return a;
//        try {
//            CloseableHttpClient httpClient = HttpClients.createDefault();
//            HttpGet request = new HttpGet("http://localhost:8088" + "/api/priljubljeni-izdelki");
//            HttpResponse response = httpClient.execute(request);
//            return response.getStatusLine().getStatusCode();
//        }
//        catch (Exception e) {
////            log.severe(e.getMessage());
////            throw new InternalServerErrorException(e);
////            throw new RuntimeException(e);
//        }
//        finally {
//            log.info("FINNALY");
//        }
}

