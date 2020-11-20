package net.flat.streams.actividad1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import net.flat.streams.datos.UtilDatos;
import net.flat.streams.dto.Clima;

/**
 *
 * @author gjijon
 */
public class T1ActividadBFunctionalInterface {

    public static void ejecutaEjemploFunctionalInterface(List<Clima> climas) {
        UtilDatos.imprimeEnunciado("Filtrar usando Predicate y Streams:");
        
        List<Clima> climasFiltradosGranizo = T1ActividadBFunctionalInterface.filtrar(climas,
                clima -> UtilDatos.VAR_PRECIPITACIONES_GRANIZO.equals(clima.getPrecipitaciones()));
        UtilDatos.imprimeDatos(climasFiltradosGranizo);

        UtilDatos.imprimeEnunciado("Filtrar usando Consumer:");
        
        T1ActividadBFunctionalInterface.consumir(
                climas, clima -> {
                    if (clima.getNombreCiudad().contains("u")) {
                        System.out.println(clima);
                    }
                }
        );
    }

    public static <T> List<T> filtrar(List<T> lista, Predicate<T> pre) {
        List<T> resultados = new ArrayList<>();
        lista.stream().filter(t -> (pre.test(t))).forEachOrdered(t -> {
            resultados.add(t);
        });
        return resultados;
    }

    public static <T> void consumir(List<T> lista, Consumer<T> con) {
        for (T t : lista) {
            con.accept(t);
        }
    }
}
