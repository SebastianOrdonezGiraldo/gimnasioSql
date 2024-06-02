package org.example.ports.in;

import org.example.domain.Miembro;

import java.util.List;

public interface MiembroServicePort {
    void registrarMiembro(Miembro miembro);
    void actualizarMiembro(Miembro miembro);
    void eliminarMiembro(int numeroMembresia);

    List<Miembro> obtenerMiembros();
    Miembro obtenerMiembroPorNumeroMembresia(int numeroMembresia);


}