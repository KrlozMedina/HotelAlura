package org.krlozmedina.dao;

import org.krlozmedina.model.Reserva;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class ReservasDAO {
    private EntityManager em;

    public ReservasDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Reserva reserva) {
        this.em.persist(reserva);
    }

    public List<Reserva> list() {
        String jqpl = "SELECT r FROM Reserva AS r";
        return em.createQuery(jqpl, Reserva.class).getResultList();
    }

    public Reserva find(Integer id) {
        return this.em.find(Reserva.class, id);
    }

    public void delete(Reserva reserva) {
        reserva = this.em.merge(reserva);
        this.em.remove(reserva);
    }
}
