package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class InscripcionTest {

    @Test
    @DisplayName("La inscripcion de un alumno X es aprobada")
    public void LaInscripcionSeEfectuaCorrectamente(){
        Materia paradigmas = new Materia("Paradigmas");
        Materia logica = new Materia("Logica");
        Materia algoritmos = new Materia("Algoritmos");
        paradigmas.agregarCorrelativas(logica, algoritmos);

        Alumno alumno = new Alumno("Juan", "Gonzalez");
        alumno.agregarMateriasAprobadas(logica, algoritmos);

        Inscripcion inscripcion = new Inscripcion(alumno, LocalDateTime.now());
        inscripcion.agregarMateriasACursar(paradigmas);

        Assertions.assertTrue(inscripcion.aprobada());
    }
}