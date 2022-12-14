package si.fri.rso.zddt.izdelki.services.beans;

import lombok.extern.slf4j.Slf4j;
import si.fri.rso.zddt.common.models.Izdelek;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import org.eclipse.microprofile.metrics.annotation.Timed;

@Slf4j
@RequestScoped
public class IzdelekBean {

    @PostConstruct
    private void init() {
        log.info("Incializacija zrna " + IzdelekBean.class.getSimpleName());
    }

    @PersistenceContext(unitName = "izdelki-jpa")
    private EntityManager em;

    @Timed
    public List<Izdelek> vrniIzdelke() {
        Query q = em.createNamedQuery("Izdelek.getAll");
        List<Izdelek> resultSet = (List<Izdelek>) q.getResultList();
        return resultSet;
    }

    public Izdelek vrniIzdelek(int izdelekId) {
        Query q = em.createNamedQuery("Izdelek.getById");
        q.setParameter("idIzdelka", izdelekId);
        Izdelek izdelek = null;
        try {
            izdelek = (Izdelek) q.getSingleResult();
        } catch (Exception ignored) {
        }
        return izdelek;
    }

    public List<Izdelek> vrniIzdelke(String kategorija) {
        Query q = em.createNamedQuery("Izdelek.getByCategory");
        q.setParameter("kategorija", kategorija);
        List<Izdelek> resultSet = (List<Izdelek>) q.getResultList();
        try {
            resultSet = (List<Izdelek>) q.getResultList();
        } catch (Exception ignored) {
        }
        return resultSet;
    }

    @Transactional
    public boolean odstraniIzdelek(int idIzdelka) {
        Izdelek izdelek = vrniIzdelek(idIzdelka);
        if (izdelek != null) {
            em.remove(izdelek);
            return true;
        }
        return false;
    }

    @Transactional
    public Izdelek dodajIzdelek(Izdelek izdelek) {
        if (izdelek != null) {
            em.persist(izdelek);
        }
        return izdelek;
    }
}
