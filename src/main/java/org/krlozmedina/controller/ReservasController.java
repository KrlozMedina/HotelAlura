package org.krlozmedina.controller;

import org.krlozmedina.dao.ReservasDAO;
import org.krlozmedina.model.Reserva;
import org.krlozmedina.utils.UtilsJPA;

import javax.persistence.EntityManager;
import java.util.Date;

public class ReservasController {

    public static Reserva save(Date fechaEntrada, Date fechaSalida, Integer valor, String formaPago) {
        Reserva reserva = new Reserva(fechaEntrada, fechaSalida, valor, formaPago);
        EntityManager em = UtilsJPA.getEntityManager();
        ReservasDAO reservasDAO = new ReservasDAO(em);

        em.getTransaction().begin();
        reservasDAO.save(reserva);
        em.getTransaction().commit();
        em.close();

        return reserva;
    }

    public void editar(Reserva reserva){
        EntityManager em = UtilsJPA.getEntityManager();

        em.getTransaction().begin();
        em.merge(reserva);
        em.getTransaction().commit();
        em.close();
    }

    public Reserva find (Integer id) {
        EntityManager em = UtilsJPA.getEntityManager();
        ReservasDAO reservasDAO = new ReservasDAO(em);

        return reservasDAO.find(id);
    }

    public void delete(Reserva reserva) {
        EntityManager em = UtilsJPA.getEntityManager();
        ReservasDAO reservasDAO = new ReservasDAO(em);

        em.getTransaction().begin();
        reservasDAO.delete(reserva);
        em.getTransaction().commit();
        em.close();
    }
}
