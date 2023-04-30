package org.krlozmedina.test;

import org.krlozmedina.dao.ReservasDAO;
import org.krlozmedina.model.Reserva;
import org.krlozmedina.utils.UtilsJPA;

import javax.persistence.EntityManager;
import java.util.Date;

public class TestHibernate {
    public static void main(String[] args) {
        saveReserva();
    }

    private static void saveReserva() {
        Reserva hoy = new Reserva(
                new Date(System.currentTimeMillis()),
                new Date(System.currentTimeMillis()),
                50000,
                "Credito"
        );
        EntityManager em = UtilsJPA.getEntityManager();
        ReservasDAO reservasDAO = new ReservasDAO(em);

        em.getTransaction().begin();
        reservasDAO.save(hoy);
        em.getTransaction().commit();
        em.close();
    }
}
