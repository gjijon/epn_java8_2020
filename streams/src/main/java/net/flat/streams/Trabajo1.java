package net.flat.streams;

import net.flat.streams.actividad1.T1ActividadBFunctionalInterface;
import net.flat.streams.actividad1.T1ActividadEMideTiempo;
import net.flat.streams.actividad1.T1ActividadCOperacionesConFiltro;
import net.flat.streams.actividad1.T1ActividadAParameterization;
import net.flat.streams.actividad1.T1ActividadDOrdenamiento;
import java.util.List;
import net.flat.streams.datos.UtilDatos;
import net.flat.streams.dto.Clima;

/**
 *
 * @author gjijon
 */
public class Trabajo1 {

    public static void main(String[] args) {
        UtilDatos.imprimeEnunciado("TAREA 1");
        
        List<Clima> climas = UtilDatos.obtieneDatos();

        UtilDatos.imprimeEnunciado("Pregunta a) Aplicar Behavior parameterization...");
        T1ActividadAParameterization.ejecutaEjemploParametrizacion(climas);

        UtilDatos.imprimeEnunciado("Pregunta b) Aplicar Functional Interface (Predicate, Consumer)...");
        T1ActividadBFunctionalInterface.ejecutaEjemploFunctionalInterface(climas);

        UtilDatos.imprimeEnunciado("Pregunta c) Crear 3 operaciones de Filtro...");
        T1ActividadCOperacionesConFiltro.ejecutaEjemploFiltros(climas);
        
        UtilDatos.imprimeEnunciado("Pregunta d) Crear 3 operaciones de Ordenamiento...");
        T1ActividadDOrdenamiento.ejecutaEjemploOrdenamiento(climas);
        
        UtilDatos.imprimeEnunciado("Pregunta e) Procesar alguna de las operaciones realizadas en los items anteriores en modo normal y paralelo y verificar los resultados.");
        T1ActividadEMideTiempo.ejecutaEjemploMedicionTiempos(UtilDatos.obtieneDatosMasivos());
        
    }
}
