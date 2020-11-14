package net.flat.streams;

import java.util.List;
import net.flat.streams.datos.ClimaDatos;
import net.flat.streams.dto.Clima;

/**
 *
 * @author gjijon
 */
public class Main {

    public static void main(String[] args) {
        List<Clima> climas = ClimaDatos.obtieneDatos();

        ClimaDatos.imprimeEnunciado("Pregunta a) Aplicar Behavior parameterization...");
        ActividadAParameterization.ejecutaEjemploParametrizacion(climas);

        ClimaDatos.imprimeEnunciado("Pregunta b) Aplicar Functional Interface (Predicate, Consumer)...");
        ActividadBFunctionalInterface.ejecutaEjemploFunctionalInterface(climas);

        ClimaDatos.imprimeEnunciado("Pregunta c) Crear 3 operaciones de Filtro...");
        ActividadCOperacionesConFiltro.ejecutaEjemploFiltros(climas);
        
        ClimaDatos.imprimeEnunciado("Pregunta d) Crear 3 operaciones de Ordenamiento...");
        ActividadDOrdenamiento.ejecutaEjemploOrdenamiento(climas);
        
        ClimaDatos.imprimeEnunciado("Pregunta e) Procesar alguna de las operaciones realizadas en los items anteriores en modo normal y paralelo y verificar los resultados.");
        ActividadEMideTiempo.ejecutaEjemploMedicionTiempos(ClimaDatos.obtieneDatosMasivos());
        
    }
}
