package beans;

import models.Cena;
import models.Izdelek;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
public class CenaBean {

    private Logger logger = Logger.getLogger(Cena.class.getName());

    @PostConstruct
    private void init() {
        logger.info("Incializacija zrna " + CenaBean.class.getSimpleName());
    }

    @PersistenceContext(unitName = "izdelki-jpa")
    private EntityManager em;

    public List<Cena> vrniVseCene() {
        Query q = em.createNamedQuery("Cena.getAll");
        List<Cena> resultSet = (List<Cena>) q.getResultList();
        return resultSet;
    }

    public List<Cena> vrniCeneIzdelka(int izdelekId) {
        Query q = em.createNamedQuery("Cena.getByizdelekId");
        q.setParameter("izdelekId",izdelekId);
        List<Cena> resultSet = null;
        try{
            resultSet = (List<Cena>) q.getResultList();
        }catch (Exception ignored){}
        return resultSet;
    }

    public Cena vrniCeno(int id) {
        Query q = em.createNamedQuery("Cena.getByid");
        q.setParameter("id",id);
        Cena cena = null;
        try{
            cena = (Cena) q.getSingleResult();
        }catch (Exception ignored){}
        return cena;
    }

    public List<Cena> vrniCeneTrgovine(int trgovinaId) {
        Query q = em.createNamedQuery("Cena.getByTrgovinaId");
        q.setParameter("trgovinaId",trgovinaId);
        List<Cena> resultSet = null;
        try{
            resultSet = (List<Cena>) q.getResultList();
        }catch (Exception ignored){}
        return resultSet;
    }

    @Transactional
    public boolean odstraniCeno(int cenaId) {
        Cena cena = vrniCeno(cenaId);
        if(cena != null) {
            em.remove(cena);
            return true;
        }
        return false;
    }
    @Transactional
    public Cena dodajCeno(Cena cena){
        if(cena != null){
            em.persist(cena);
        }
        return cena;
    }

}
