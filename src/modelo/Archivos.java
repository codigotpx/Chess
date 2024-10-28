package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Archivos {

    public static void main(String[] args) {

        String filePath = "C:\\Users\\cerpa\\Documents\\Adams.pgn";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine())!= null) {
                // Procesar cada linea
                if (line.startsWith("[") && line.endsWith("]")) {
                    System.out.println("Encabezado; " + line);
                } else if (!line.trim().isEmpty()) {
                    // Ees un movimiento
                    System.out.println("Movimiento " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
