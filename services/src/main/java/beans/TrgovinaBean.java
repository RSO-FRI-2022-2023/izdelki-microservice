package beans;

import models.Izdelek;
import models.Trgovina;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
public class TrgovinaBean {

    private Logger logger = Logger.getLogger(TrgovinaBean.class.getName());

    @PostConstruct
    private void init() {
        logger.info("Incializacija zrna " + TrgovinaBean.class.getSimpleName());
    }

    @PersistenceContext(unitName = "izdelki-jpa")
    private EntityManager em;

    public List<Trgovina> vrniTrgovine() {
        Query q = em.createNamedQuery("Trgovina.getAll");
        List<Trgovina> resultSet = (List<Trgovina>) q.getResultList();
        return resultSet;
    }

    public Trgovina vrniTrgovino(int idTrgovine) {
        Query q = em.createNamedQuery("Trgovina.getById");
        q.setParameter("idTrgovine",idTrgovine);
        Trgovina trgovina = null;
        try{
            trgovina = (Trgovina)q.getSingleResult();
        }catch (Exception ignored){}
        return trgovina;
    }

    public Trgovina vrniTrgovino(String ime) {
        Query q = em.createNamedQuery("Trgovina.getByIme");
        q.setParameter("ime",ime);
        Trgovina trgovina = null;
        try{
            trgovina = (Trgovina)q.getSingleResult();
        }catch (Exception ignored){}
        return trgovina;
    }

    @Transactional
    public boolean odstraniTrgovino(int idTrgovine) {
        Trgovina trgovina = vrniTrgovino(idTrgovine);
        if(trgovina != null) {
            em.remove(trgovina);
            return true;
        }
        return false;
    }
    @Transactional
    public Trgovina dodajTrgovino(Trgovina trgovina){
        if(trgovina != null){
            em.persist(trgovina);
        }
        return trgovina;
    }
}
