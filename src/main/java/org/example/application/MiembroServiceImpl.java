package org.example.application;

import org.example.domain.Miembro;
import org.example.ports.in.MiembroServicePort;
import org.example.ports.out.MiembroRepositoryPort;

import java.util.List;

//Esta clase implementa la interfaz MiembroServicePort y se encarga de la lógica de aplicación relacionada con los miembros.
// Aquí es donde se definen los casos de uso o servicios específicos que la aplicación debe proporcionar en relación con los
// miembros.
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
