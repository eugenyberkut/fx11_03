package dbgui.model;

import tables.Avtor;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Yevhen on 11.03.2016.
 */
public class AvtorService {
    private EntityManager em;

    public AvtorService(EntityManager em) {
        this.em = em;
    }

    public List<Avtor> findAll() {
        return em.createQuery("select a from Avtor a").getResultList();
    }

    public Avtor create(String name, String comment) {
        Avtor avtor = new Avtor(name,comment);
        em.getTransaction().begin();
        em.persist(avtor);
        em.getTransaction().commit();
        return avtor;
    }
}
