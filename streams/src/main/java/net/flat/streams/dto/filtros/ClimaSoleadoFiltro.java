package net.flat.streams.dto.filtros;

import net.flat.streams.datos.UtilDatos;
import net.flat.streams.dto.Clima;
import net.flat.streams.dto.interfaces.funcionales.FunctionClima;

/**
 *
 * @author gjijon
 */
public class ClimaSoleadoFiltro implements FunctionClima {

    @Override
    public boolean filtrar(Clima clima) {
        return UtilDatos.VAR_PRECIPITACIONES_SOLEADO.equals(clima.getPrecipitaciones());
    }

}
