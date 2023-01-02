package si.fri.rso.zddt.izdelki.services.clients;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.WebApplicationException;
import java.io.IOException;
import java.time.temporal.ChronoUnit;
import java.util.logging.Logger;

@RequestScoped
public class FaultToleranceExampleClient {

    private Logger log = Logger.getLogger(FaultToleranceExampleClient.class.getName());

    public Integer fallback() {
        log.info("In FALLBACK method");
        return 0;
    }
//    @Timeout(value = 2, unit = ChronoUnit.SECONDS)
//    @CircuitBreaker(requestVolumeThreshold = 3)
    @Fallback(fallbackMethod = "fallback")
    public Integer getSteviloPriljubljenihIzdelkov() {

        log.info("Calling fake distances service: getting distances");
//        throw new InternalServerErrorException();
//        return 1;
//        return 1/0;
        int a = 1/0;
        return 0;
//        try {
////            CloseableHttpClient httpClient = HttpClients.createDefault();
////            HttpGet request = new HttpGet("http://localhost:8082" + "/api/priljubljeni-izdelki");
////            HttpResponse response = httpClient.execute(request);
////            return response.getStatusLine().getStatusCode();
//
//
//            return 0;
//        }
//        catch (WebApplicationException | ProcessingException | IOException e) {
//            log.severe(e.getMessage());
//            throw new InternalServerErrorException(e);
//        }
//        finally {
//            log.info("FINNALY");
//        }

    }
}
