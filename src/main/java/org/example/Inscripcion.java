package org.example;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Inscripcion {
    private Set<Materia> materiasACursar;
    private boolean fueAprobada;
    private Alumno alumno;
    private LocalDateTime fechaDeEvaluacion;

    public Inscripcion(Alumno alumno, LocalDateTime fechaDeEvaluacion) {
        this.alumno = alumno;
        this.materiasACursar = new HashSet<>();
        this.fechaDeEvaluacion = fechaDeEvaluacion;
        this.fueAprobada = false;
    }

    public void agregarMateriasACursar(Materia ... materias) {
        Collections.addAll(this.materiasACursar, materias);
    }

    public boolean aprobada() {
        for (Materia materia : materiasACursar) {
            if (!materia.cumpleCorrelativas(alumno.getMateriasAprobadas())) {
                return false;
            }
        }
        fueAprobada = true;
        return true;
    }
}
