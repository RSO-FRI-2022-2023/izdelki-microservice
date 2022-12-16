package si.fri.rso.zddt.izdelki.services.clients;

import javax.enterprise.context.Dependent;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.concurrent.CompletionStage;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import si.fri.rso.zddt.common.models.PriljubljenIzdelek;

@Path("priljubljeni")
@RegisterRestClient(configKey="priljubljeni-izdelki-api")
@Dependent
public interface AsyncApi {

    @GET
    CompletionStage<PriljubljenIzdelek[]> getPriljubljeneIzdelkeAsync();
}
