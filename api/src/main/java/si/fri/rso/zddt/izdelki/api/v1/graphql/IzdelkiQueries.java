package si.fri.rso.zddt.izdelki.api.v1.graphql;

import com.kumuluz.ee.graphql.annotations.GraphQLClass;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLQuery;
import si.fri.rso.zddt.common.models.Izdelek;
import si.fri.rso.zddt.izdelki.services.beans.IzdelekBean;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@GraphQLClass
@ApplicationScoped
public class IzdelkiQueries {

    @Inject
    private IzdelekBean izdelekBean;

    @GraphQLQuery
    public List<Izdelek> getIzdelke() {
        return izdelekBean.vrniIzdelke();
    }

    @GraphQLQuery
    public Izdelek getIzdelek(@GraphQLArgument(name = "id") Integer id) {
        return izdelekBean.vrniIzdelek(id);
    }

}
