package org.example.application;

import org.example.domain.Miembro;
import org.example.ports.out.MiembroRepositoryPort;

import java.util.ArrayList;
import java.util.List;

public class MiembroRepositoryImpl implements MiembroRepositoryPort {
    private List<Miembro> miembros = new ArrayList<>();

    @Override
    public void agregarMiembro(Miembro miembro) {
        miembros.add(miembro);
    }

    @Override
    public void actualizarMiembro(Miembro miembro) {
        for (int i = 0; i < miembros.size(); i++) {
            if (miembros.get(i).getNumeroMembresia() == miembro.getNumeroMembresia()) {
                miembros.set(i, miembro);
                return;
            }
        }
    }



    @Override
    public void eliminarMiembro(int numeroMembresia) {
        miembros.removeIf(miembro -> miembro.getNumeroMembresia() == numeroMembresia);
    }

    @Override
    public List<Miembro> obtenerMiembros() {
        return new ArrayList<>(miembros);
    }



    @Override
    public Miembro obtenerMiembroPorNumeroMembresia(int numeroMembresia) {
        for (Miembro miembro : miembros) {
            if (miembro.getNumeroMembresia() == numeroMembresia) {
                return miembro;
            }
        }
        return null; // Si no se encuentra ningún miembro con el número de membresía especificado
    }


}
