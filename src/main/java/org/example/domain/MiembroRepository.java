package org.example.domain;

import java.util.List;
//La interfaz MiembroRepository define los métodos de acceso y manipulación de los datos de Miembro.
public interface MiembroRepository {
    void agregarMiembro(Miembro miembro);
    void actualizarMiembro(Miembro miembro);
    void eliminarMiembro(int numeroMembresía);
    List<Miembro> obtenerMiembros();
}