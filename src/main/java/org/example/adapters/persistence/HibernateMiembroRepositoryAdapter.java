package org.example.adapters.persistence;

import org.example.domain.Miembro;
import org.example.ports.out.MiembroRepositoryPort;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.swing.JOptionPane;
import java.util.List;

//Esta clase se encarga de la interacción con la base de datos para la entidad Miembro.
// Implementa operaciones CRUD  utilizando Hibernate para gestionar las transacciones y la sesión con la base de datos.
// Además, maneja errores y muestra mensajes en caso de fallos.

public class HibernateMiembroRepositoryAdapter implements MiembroRepositoryPort {

//Este método verifica si ya existe un miembro con el número de membresía dado en la base de datos.
// Utiliza una consulta HQL (Hibernate Query Language) para buscar el miembro.
    private boolean existeNumeroMembresia(int numeroMembresia, Session session) {
        Miembro miembro = session.createQuery("FROM Miembro WHERE numeroMembresia = :numeroMembresia", Miembro.class)
                .setParameter("numeroMembresia", numeroMembresia)
                .uniqueResult();
        return miembro != null;
    }

//Este método agrega un nuevo miembro a la base de datos. Si el número de membresía ya existe, lanza una excepción.
// La transacción se deshace en caso de error.
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

//Este método actualiza la información de un miembro existente en la base de datos.
// Utiliza una transacción de Hibernate y se asegura de deshacerla en caso de error.
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

//Este método elimina un miembro de la base de datos según su número de membresía.
// Si no se encuentra ningún miembro con ese número, muestra un mensaje.
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

//Este método recupera todos los miembros de la base de datos y los devuelve como una lista.
    @Override
    public List<Miembro> obtenerMiembros() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Miembro", Miembro.class).list();
        }
    }

//Este método recupera un miembro específico según su número de membresía.
    @Override
    public Miembro obtenerMiembroPorNumeroMembresia(int numeroMembresia) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Miembro WHERE numeroMembresia = :numeroMembresia", Miembro.class)
                    .setParameter("numeroMembresia", numeroMembresia)
                    .uniqueResult();
        }
    }
}
