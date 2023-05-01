package org.krlozmedina.controller;

import org.krlozmedina.dao.HuespedesDAO;
import org.krlozmedina.dao.ReservasDAO;
import org.krlozmedina.model.Huesped;
import org.krlozmedina.model.Reserva;
import org.krlozmedina.utils.UtilsJPA;

import javax.persistence.EntityManager;
import java.util.Date;

public class HuespedesController {
    public static void save(
            String nombre,
            String apellido,
            Date fechaNacimiento,
            String nacionalidad,
            long telefono,
            Reserva reserva) {
        Huesped huesped = new Huesped(nombre, apellido, fechaNacimiento, nacionalidad, telefono, reserva);
        EntityManager em = UtilsJPA.getEntityManager();
        HuespedesDAO huespedesDAO = new HuespedesDAO(em);

        em.getTransaction().begin();
        huespedesDAO.save(huesped);
        em.getTransaction().commit();
        em.close();
    }

    public Huesped find(Integer id) {
        EntityManager em = UtilsJPA.getEntityManager();
        HuespedesDAO huespedesDAO = new HuespedesDAO(em);

        return huespedesDAO.find(id);
    }

    public void delete(Huesped huesped) {
        EntityManager em = UtilsJPA.getEntityManager();
        HuespedesDAO huespedesDAO = new HuespedesDAO(em);

        em.getTransaction().begin();
        huespedesDAO.delete(huesped);
        em.getTransaction().commit();
        em.close();
    }
}