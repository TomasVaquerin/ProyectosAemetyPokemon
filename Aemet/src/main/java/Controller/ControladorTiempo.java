package Controller;

import org.example.Clima;
import org.example.Temperatura;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Nodes.collect;


public class ControladorTiempo {
    private static ControladorTiempo instance;
    private Clima clima;

    private ControladorTiempo(){
        findFiles();
    }

    public static ControladorTiempo getInstance() {
        if (instance == null) {
            instance = new ControladorTiempo();
        }
        return instance;
    }

    private void findFiles(){
        // Obtener la ruta actual
        Path currentRelativePath = Paths.get("");
        String ruta = currentRelativePath.toAbsolutePath().toString();
        String dir = ruta + File.separator + "data";

        // Nombres de los archivos que quieres leer
        String[] nombresArchivos = {"Aemet20171029.csv", "Aemet20171030.csv", "Aemet20171031.csv"};

        // Leer cada archivo
        for (String nombreArchivo : nombresArchivos) {
            String rutaArchivo = dir + File.separator + nombreArchivo;
            System.out.println("Fichero-----------------" + rutaArchivo);
            loadClima(rutaArchivo);

        }
    }

    private void loadClima(String rutaArchivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            // Crear un nuevo objeto Clima
            this.clima = new Clima();

            this.clima.setTemperaturas((ArrayList<Temperatura>) reader.lines()
                    .map(linea -> linea.split(";")) // separar cada línea en un array de strings
                    .map(valores -> new Temperatura(
                            valores[0],
                            valores[1],
                            Double.parseDouble(valores[3]),
                            LocalDate.parse(valores[4]),
                            Double.parseDouble(valores[5]),
                            LocalDate.parse(valores[6]),
                            Double.parseDouble(valores[7])))
                    .collect(Collectors.toList()));

            // Imprimir cada temperatura
            this.clima.getTemperaturas().forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ControladorTiempo ct = new ControladorTiempo();

    }

}
