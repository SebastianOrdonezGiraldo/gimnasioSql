package org.example.ports.in;

import org.example.domain.Miembro;

import java.util.List;

//Esta interfaz define los métodos que el servicio de miembros debe implementar.
// Representa los casos de uso de la aplicación relacionados con los miembros.
public interface MiembroServicePort {
    void registrarMiembro(Miembro miembro);
    void actualizarMiembro(Miembro miembro);
    void eliminarMiembro(int numeroMembresia);

    List<Miembro> obtenerMiembros();
    Miembro obtenerMiembroPorNumeroMembresia(int numeroMembresia);


}