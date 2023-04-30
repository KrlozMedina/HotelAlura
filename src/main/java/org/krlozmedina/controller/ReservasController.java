package org.krlozmedina.controller;

import org.krlozmedina.dao.ReservasDAO;
import org.krlozmedina.model.Reserva;
import org.krlozmedina.utils.UtilsJPA;

import javax.persistence.EntityManager;
import java.util.Date;

public class ReservasController {

    public static Integer save(Date fechaEntrada, Date fechaSalida, Integer valor, String formaPago) {
        Reserva reserva = new Reserva(fechaEntrada, fechaSalida, valor, formaPago);
        EntityManager em = UtilsJPA.getEntityManager();
        ReservasDAO reservasDAO = new ReservasDAO(em);

        em.getTransaction().begin();
        reservasDAO.save(reserva);
        em.getTransaction().commit();
        em.close();

        return reserva.getId();
    }
}
