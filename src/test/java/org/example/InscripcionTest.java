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

    @Test
    @DisplayName("La inscripcion de un alumno X no es aprobada")
    public void LaInscripcionNoEsAprobada(){
        Materia paradigmas = new Materia("Paradigmas");
        Materia logica = new Materia("Logica");
        Materia algoritmos = new Materia("Algoritmos");
        Materia analisis2 = new Materia("Analisis 2");
        Materia analisis1 = new Materia("Analisis 1");
        Materia algebra = new Materia("Algebra");
        paradigmas.agregarCorrelativas(logica, algoritmos);
        analisis2.agregarCorrelativas(analisis1, algebra);

        Alumno alumno2 = new Alumno("Carla", "Espinoza");
        alumno2.agregarMateriasAprobadas(algebra, logica, algoritmos);

        Inscripcion inscripcion = new Inscripcion(alumno2, LocalDateTime.now());
        inscripcion.agregarMateriasACursar(paradigmas, analisis2);

        Assertions.assertFalse(inscripcion.aprobada());
    }
}
