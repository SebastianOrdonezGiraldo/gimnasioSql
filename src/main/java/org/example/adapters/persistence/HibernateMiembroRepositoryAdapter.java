package org.example.adapters.persistence;

import org.example.domain.Miembro;
import org.example.ports.out.MiembroRepositoryPort;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.swing.JOptionPane;
import java.util.List;

public class HibernateMiembroRepositoryAdapter implements MiembroRepositoryPort {

    private boolean existeNumeroMembresia(int numeroMembresia, Session session) {
        Miembro miembro = session.createQuery("FROM Miembro WHERE numeroMembresia = :numeroMembresia", Miembro.class)
                .setParameter("numeroMembresia", numeroMembresia)
                .uniqueResult();
        return miembro != null;
    }

    @Override
    public void agregarMiembro(Miembro miembro) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            // Verificar si el numeroMembresia ya existe
            if (existeNumeroMembresia(miembro.getNumeroMembresia(), session)) {
                throw new IllegalArgumentException("Número de membresía ya registrado");
            }

            session.save(miembro);
            transaction.commit();
        } catch (IllegalArgumentException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void actualizarMiembro(Miembro miembro) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(miembro);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarMiembro(int numeroMembresia) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Miembro miembro = session.createQuery("FROM Miembro WHERE numeroMembresia = :numeroMembresia", Miembro.class)
                    .setParameter("numeroMembresia", numeroMembresia)
                    .uniqueResult();
            if (miembro != null) {
                session.delete(miembro);
                transaction.commit();
                System.out.println("Miembro eliminado correctamente.");
            } else {
                System.out.println("No se encontró ningún miembro con el número de membresía especificado.");
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            System.out.println("Error al eliminar el miembro: " + e.getMessage());
        }
    }

    @Override
    public List<Miembro> obtenerMiembros() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Miembro", Miembro.class).list();
        }
    }

    @Override
    public Miembro obtenerMiembroPorNumeroMembresia(int numeroMembresia) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Miembro WHERE numeroMembresia = :numeroMembresia", Miembro.class)
                    .setParameter("numeroMembresia", numeroMembresia)
                    .uniqueResult();
        }
    }
}
