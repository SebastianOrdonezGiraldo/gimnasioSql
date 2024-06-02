package org.example.ports.out;

import org.example.domain.Miembro;

import java.util.List;

public interface MiembroRepositoryPort {
    void agregarMiembro(Miembro miembro);
    void actualizarMiembro(Miembro miembro);
    void eliminarMiembro(int numeroMembresia);

    List<Miembro> obtenerMiembros();
    Miembro obtenerMiembroPorNumeroMembresia(int numeroMembresia);
}
