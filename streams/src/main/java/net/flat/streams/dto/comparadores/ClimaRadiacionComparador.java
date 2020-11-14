package net.flat.streams.dto.comparadores;

import java.util.Comparator;
import net.flat.streams.dto.Clima;

/**
 *
 * @author gjijon
 */
public class ClimaRadiacionComparador implements Comparator<Clima> {

    @Override
    public int compare(Clima o1, Clima o2) {
        return Integer.valueOf(o1.getRadiacion()).compareTo(o2.getRadiacion());
    }

}
