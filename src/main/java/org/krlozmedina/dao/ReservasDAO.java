package org.krlozmedina.dao;

import org.krlozmedina.model.Reserva;

import javax.persistence.EntityManager;

public class ReservasDAO {
    private EntityManager em;

    public ReservasDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Reserva reserva) {
        this.em.persist(reserva);
    }
}
