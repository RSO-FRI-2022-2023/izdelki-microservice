package si.fri.rso.zddt.izdelki.api.v1.health;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;
import si.fri.rso.zddt.izdelki.services.config.RestProperties;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@Liveness
@ApplicationScoped
public class BrokenHealthCheck implements HealthCheck {

    @Inject
    private RestProperties restProperties;

    @Override
    public HealthCheckResponse call() {
        if (restProperties.getBroken()) {
            return HealthCheckResponse.named(BrokenHealthCheck.class.getSimpleName()).down().build();
        } else {
            return HealthCheckResponse.named(BrokenHealthCheck.class.getSimpleName()).up().build();
        }
    }
}

