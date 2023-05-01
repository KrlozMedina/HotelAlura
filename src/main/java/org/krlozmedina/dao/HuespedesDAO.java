package org.krlozmedina.dao;

import org.krlozmedina.model.Huesped;
import org.krlozmedina.model.Reserva;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class HuespedesDAO {
    private EntityManager em;

    public HuespedesDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Huesped huesped) {
        this.em.persist(huesped);
    }

    public List<Huesped> list() {
        String jqpl = "SELECT h FROM Huesped AS h";
        return em.createQuery(jqpl, Huesped.class).getResultList();
    }

    public Huesped find(Integer id) {
        return this.em.find(Huesped.class, id);
    }

    public void delete(Huesped huesped) {
        huesped = this.em.merge(huesped);
        this.em.remove(huesped);
    }
}