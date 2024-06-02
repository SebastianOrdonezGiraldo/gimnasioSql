package org.example.domain;

import java.util.List;

public interface MiembroRepository {
    void agregarMiembro(Miembro miembro);
    void actualizarMiembro(Miembro miembro);
    void eliminarMiembro(int numeroMembresía);
    List<Miembro> obtenerMiembros();
}