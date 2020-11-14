package net.flat.streams.dto.filtros;

import net.flat.streams.datos.ClimaDatos;
import net.flat.streams.dto.Clima;
import net.flat.streams.dto.interfaces.funcionales.FunctionClima;

/**
 *
 * @author gjijon
 */
public class ClimaSoleadoFiltro implements FunctionClima {

    @Override
    public boolean filtrar(Clima clima) {
        return ClimaDatos.VAR_PRECIPITACIONES_SOLEADO.equals(clima.getPrecipitaciones());
    }

}
