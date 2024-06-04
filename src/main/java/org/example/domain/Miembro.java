package org.example.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Miembro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private int edad;
    private int numeroMembresia;

    public Miembro() {}

    public Miembro(String nombre, String apellido, int edad, int numeroMembresia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.numeroMembresia = numeroMembresia;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setNumeroMembresia(int numeroMembresia) {
        this.numeroMembresia = numeroMembresia;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public int getNumeroMembresia() {
        return numeroMembresia;
    }

    public String getApellido() {
        return apellido;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Apellido: " + apellido + ", Edad: " + edad + ", Número de membresía: " + numeroMembresia;
    }
}
