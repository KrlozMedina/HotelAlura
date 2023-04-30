package org.krlozmedina.dao;

import org.krlozmedina.model.Huesped;

import javax.persistence.EntityManager;

public class HuespedesDAO {
    private EntityManager em;

    public HuespedesDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Huesped huesped) {
        this.em.persist(huesped);
    }
}