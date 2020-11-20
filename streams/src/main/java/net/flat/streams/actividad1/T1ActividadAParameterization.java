package net.flat.streams.actividad1;

import java.math.BigDecimal;
import java.util.List;
import net.flat.streams.datos.UtilDatos;
import net.flat.streams.dto.Clima;
import net.flat.streams.dto.filtros.ClimaLluviosoPredicate;
import net.flat.streams.dto.filtros.behavior.FiltroClimaBehavior;
import net.flat.streams.dto.interfaces.predicados.ClimaPredicate;

/**
 *
 * @author gjijon
 */
public class T1ActividadAParameterization {

    public static void ejecutaEjemploParametrizacion(List<Clima> climas) {

        UtilDatos.imprimeEnunciado("Filtrar usando método tradicional:");
        List<Clima> climasFiltradosSoleado = FiltroClimaBehavior.filtrarClimaPorCieloSoleado(climas);
        UtilDatos.imprimeDatos(climasFiltradosSoleado);

        UtilDatos.imprimeEnunciado("Filtrar usando behavior parameterization");
        List<Clima> climasFiltradosPredicado = FiltroClimaBehavior.filtrarClimaPorCieloSoleado(climas, new ClimaLluviosoPredicate());
        UtilDatos.imprimeDatos(climasFiltradosPredicado);

        UtilDatos.imprimeEnunciado("Filtrar usando behavior parameterization con clases anónimas");
        List<Clima> climasFiltradosLatitudMenor2 = FiltroClimaBehavior.filtrarClimaPorCieloSoleado(climas, new ClimaPredicate() {
            @Override
            public boolean filtrar(Clima clima) {
                return clima.getLatitud().compareTo(new BigDecimal("2")) < 0;
            }
        });
        UtilDatos.imprimeDatos(climasFiltradosLatitudMenor2);
    }
}
