package org.example.ports.out;

import org.example.domain.Miembro;

import java.util.List;

//Esta interfaz define los métodos que el repositorio de miembros debe implementar.
// Representa las operaciones CRUD sobre la persistencia de datos de los miembros.
public interface MiembroRepositoryPort {
    void agregarMiembro(Miembro miembro);
    void actualizarMiembro(Miembro miembro);
    void eliminarMiembro(int numeroMembresia);

    List<Miembro> obtenerMiembros();
    Miembro obtenerMiembroPorNumeroMembresia(int numeroMembresia);
}
