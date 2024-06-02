package org.example.application;

import org.example.domain.Miembro;
import org.example.ports.in.MiembroServicePort;
import org.example.ports.out.MiembroRepositoryPort;

import java.util.List;

public class MiembroServiceImpl implements MiembroServicePort {

    private final MiembroRepositoryPort miembroRepository;

    public MiembroServiceImpl(MiembroRepositoryPort miembroRepository) {
        this.miembroRepository = miembroRepository;
    }

    @Override
    public void registrarMiembro(Miembro miembro) {
        miembroRepository.agregarMiembro(miembro);
    }

    @Override
    public void actualizarMiembro(Miembro miembro) {
        miembroRepository.actualizarMiembro(miembro);
    }

    public void eliminarMiembro(int numeroMembresia) {
        miembroRepository.eliminarMiembro(numeroMembresia);
    }

    @Override
    public List<Miembro> obtenerMiembros() {
        return miembroRepository.obtenerMiembros();
    }

    @Override
    public Miembro obtenerMiembroPorNumeroMembresia(int numeroMembresia) {
        return miembroRepository.obtenerMiembroPorNumeroMembresia(numeroMembresia);
    }
}
