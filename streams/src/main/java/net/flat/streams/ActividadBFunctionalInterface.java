package net.flat.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import net.flat.streams.datos.ClimaDatos;
import net.flat.streams.dto.Clima;

/**
 *
 * @author gjijon
 */
public class ActividadBFunctionalInterface {

    public static void ejecutaEjemploFunctionalInterface(List<Clima> climas) {
        ClimaDatos.imprimeEnunciado("Filtrar usando Predicate y Streams:");
        List<Clima> climasFiltradosGranizo = ActividadBFunctionalInterface.filtrar(
                climas,
                clima -> ClimaDatos.VAR_PRECIPITACIONES_GRANIZO.equals(clima.getPrecipitaciones()));
        ClimaDatos.imprimeClimas(climasFiltradosGranizo);

        ClimaDatos.imprimeEnunciado("Filtrar usando Consumer:");
        ActividadBFunctionalInterface.consumir(
                climas, clima -> {
                    if (clima.getNombreCiudad().contains("u")) {
                        System.out.println(clima);
                    }
                }
        );
    }

    public static <T> List<T> filtrar(List<T> lista, Predicate<T> pre) {
        List<T> resultados = new ArrayList<>();
        for (T t : lista) {
            if (pre.test(t)) {
                resultados.add(t);
            }
        }
        return resultados;
    }

    public static <T> void consumir(List<T> lista, Consumer<T> con) {
        for (T t : lista) {
            con.accept(t);
        }
    }
}
