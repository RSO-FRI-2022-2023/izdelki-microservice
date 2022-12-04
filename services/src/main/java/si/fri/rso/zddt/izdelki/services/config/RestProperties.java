package si.fri.rso.zddt.izdelki.services.config;

import javax.enterprise.context.ApplicationScoped;
import com.kumuluz.ee.configuration.cdi.ConfigBundle;
import com.kumuluz.ee.configuration.cdi.ConfigValue;

@ConfigBundle("rest-properties")
@ApplicationScoped
public class RestProperties {

    @ConfigValue(watch = true)
    private Boolean discount;

    private Boolean broken;


    public Boolean getDiscount() {
        return this.discount;
    }

    public void setDiscount(final Boolean discount) {
        this.discount = discount;
    }

    public Boolean getBroken() {
        return broken;
    }

    public void setBroken(Boolean broken) {
        this.broken = broken;
    }
}