package net.flat.streams.actividad2;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import net.flat.streams.datos.UtilDatos;
import net.flat.streams.dto.Nomina;

/**
 *
 * @author gjijon
 */
public class T2ActividadBValidacionesArchivo {
    
    private static final String EMAIL_PATTERN = "^(.+)@(\\S+)$";
    private static final Pattern VALIDADOR = Pattern.compile(EMAIL_PATTERN);
    
    public static List<Nomina> ejecutaValidacionesArchivo() throws IOException {
        
        UtilDatos.imprimeEnunciado("Entrando a validar contenido archivo CSV con parallel: (Monto, null y correo correcto)");
        List<Nomina> datosNominaImportados;
        try ( Stream<String> lineasArchivo = Files.lines(Paths.get("/tmp/datosnominaconerrores.csv"))) {
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
                        try {
                            nuevaNomina.setSueldo(new BigDecimal(datos[5]));
                        } catch (NumberFormatException e) {
                            System.out.println(String.format("Error en monto, se retorno null. ID PROBLEMA: %s", datos[5]));
                            return null;
                        }
                        return nuevaNomina;
                    })
                    .filter(T2ActividadBValidacionesArchivo::validarSiNominaExiste)
                    .filter(T2ActividadBValidacionesArchivo::validarCorreoElectronicoCorrecto)
                    .collect(Collectors.toList());
            UtilDatos.imprimeDato(Optional.of(String.format("Registros leídos con validación de archivo: %s", datosNominaImportados.size())));
            return datosNominaImportados;
        } catch (IOException ex) {
            Logger.getLogger(T2ActividadALecturaArchivo.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }
    
    public static boolean validarCorreoElectronicoCorrecto(Nomina nomina) {
        Matcher matcher = VALIDADOR.matcher(nomina.getEmail());
        return matcher.matches();
    }
    
    public static boolean validarSiNominaExiste(Nomina nomina) {
        return nomina != null && nomina.getEmail() != null;
    }
}
