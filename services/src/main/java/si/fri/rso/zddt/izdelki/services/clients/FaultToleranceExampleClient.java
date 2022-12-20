package si.fri.rso.zddt.izdelki.services.clients;

import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;
import si.fri.rso.zddt.common.models.PriljubljenIzdelek;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import java.time.temporal.ChronoUnit;
import java.util.logging.Logger;

@RequestScoped
public class FaultToleranceExampleClient {

    private Logger log = Logger.getLogger(FaultToleranceExampleClient.class.getName());
    private Client httpClient;
    private String baseUrl;

    @PostConstruct
    private void init() {
        httpClient = ClientBuilder.newClient();
        baseUrl = "http://localhost:8082"; // only for demonstration - napačen naslov za distances
    }


    @Timeout(value = 2, unit = ChronoUnit.SECONDS)
    @CircuitBreaker(requestVolumeThreshold = 3)
    @Fallback(fallbackMethod = "getSteviloPriljubljenihIzdelkovFallback")
    public Integer getSteviloPriljubljenihIzdelkov() {

        log.info("Calling fake distances service: getting distances");

        try {
            return httpClient
                    .target(baseUrl + "/v1/fault-tolerance")
                    .request().get(new GenericType<Integer>() {
                    });
        }
        catch (WebApplicationException | ProcessingException e) {
            log.severe(e.getMessage());
            throw new InternalServerErrorException(e);
        }
        finally {
            log.info("FINNALY");
        }
    }

    public Integer getSteviloPriljubljenihIzdelkovFallback() {
        log.info("In FALLBACK method");
        return 0;
    }
}
