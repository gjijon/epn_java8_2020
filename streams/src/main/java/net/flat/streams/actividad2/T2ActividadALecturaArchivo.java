package net.flat.streams.actividad2;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import net.flat.streams.datos.UtilDatos;
import net.flat.streams.dto.Nomina;

/**
 *
 * @author gjijon
 */
public class T2ActividadALecturaArchivo {

    public static void ejecutaLecturaArchivo() {

        UtilDatos.imprimeEnunciado("Entrando a abrir archivo CSV con parallel:");
        List<Nomina> datosNominaImportados;
        try ( Stream<String> lineasArchivo = Files.lines(Paths.get("/tmp/datosnomina.csv"))) {
            datosNominaImportados = lineasArchivo
                    .skip(1)
                    .parallel()
                    .map(linea -> {
                        String datos[] = linea.split(",");
                        Nomina nuevaNomina = new Nomina();
                        nuevaNomina.setId(Integer.valueOf(datos[0]));
                        nuevaNomina.setNombre(datos[1]);
                        nuevaNomina.setApellido(datos[2]);
                        nuevaNomina.setEmail(datos[3]);
                        nuevaNomina.setEdad(Integer.valueOf(datos[4]));
                        nuevaNomina.setSueldo(new BigDecimal(datos[5]));
                        return nuevaNomina;
                    }).collect(Collectors.toList());
            UtilDatos.imprimeDato(Optional.of(String.format("Registros leídos sin validar contenido de archivo: %s", datosNominaImportados.size())));
        } catch (IOException ex) {
            Logger.getLogger(T2ActividadALecturaArchivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
