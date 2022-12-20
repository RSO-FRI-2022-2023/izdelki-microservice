package si.fri.rso.zddt.izdelki.api.v1.graphql;


import com.kumuluz.ee.graphql.annotations.GraphQLClass;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import si.fri.rso.zddt.common.models.Izdelek;
import si.fri.rso.zddt.izdelki.services.DTOs.IzdelekDTO;
import si.fri.rso.zddt.izdelki.services.beans.IzdelekBean;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@GraphQLClass
@ApplicationScoped
public class IzdelkiMutations {

    @Inject
    private IzdelekBean izdelekBean;

    @GraphQLMutation
    public Izdelek dodajIzdelek(@GraphQLArgument(name = "izdelek") Izdelek izdelek) {
        izdelekBean.dodajIzdelek(izdelek);
        return izdelek;
    }

    @GraphQLMutation
    public DeleteResponse deleteImageMetadata(@GraphQLArgument(name = "id") Integer id) {
        return new DeleteResponse(izdelekBean.odstraniIzdelek(id));
    }
}
