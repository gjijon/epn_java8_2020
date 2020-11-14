package net.flat.streams;

import java.math.BigDecimal;
import java.util.List;
import net.flat.streams.datos.ClimaDatos;
import net.flat.streams.dto.Clima;
import net.flat.streams.dto.filtros.ClimaLluviosoPredicate;
import net.flat.streams.dto.filtros.behavior.FiltroClimaBehavior;
import net.flat.streams.dto.interfaces.predicados.ClimaPredicate;

/**
 *
 * @author gjijon
 */
public class ActividadAParameterization {

    public static void ejecutaEjemploParametrizacion(List<Clima> climas) {

        ClimaDatos.imprimeEnunciado("Filtrar usando método tradicional:");
        List<Clima> climasFiltradosSoleado = FiltroClimaBehavior.filtrarClimaPorCieloSoleado(climas);
        ClimaDatos.imprimeClimas(climasFiltradosSoleado);

        ClimaDatos.imprimeEnunciado("Filtrar usando behavior parameterization");
        List<Clima> climasFiltradosPredicado = FiltroClimaBehavior.filtrarClimaPorCieloSoleado(climas, new ClimaLluviosoPredicate());
        ClimaDatos.imprimeClimas(climasFiltradosPredicado);

        ClimaDatos.imprimeEnunciado("Filtrar usando behavior parameterization con clases anónimas");
        List<Clima> climasFiltradosLatitudMenor2 = FiltroClimaBehavior.filtrarClimaPorCieloSoleado(climas, new ClimaPredicate() {
            @Override
            public boolean filtrar(Clima clima) {
                return clima.getLatitud().compareTo(new BigDecimal("2")) < 0;
            }
        });
        ClimaDatos.imprimeClimas(climasFiltradosLatitudMenor2);
    }
}
