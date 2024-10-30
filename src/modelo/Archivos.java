package modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Archivos {
    public static String leerPgn(String nombreArchivo) {
        StringBuilder pgnContent = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String line;
            while ((line = br.readLine()) != null) {
                pgnContent.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pgnContent.toString();
    }

    public static String estraerMovimientos(String pgnContenido) {
        String[] lines = pgnContenido.split("\n");
        StringBuilder movimientos = new StringBuilder();

        for(String line : lines) {
            if (!line.startsWith("[") && !line.endsWith("]")) {
                movimientos.append(line).append(" ");
            }
        }
        return movimientos.toString().trim();
    }

    public static List<String> analizarMovimientos(String movimientos) {
        // Eliminar numeraciones como "43.", "44.", etc., con una expresión regular
        movimientos = movimientos.replaceAll("\\b\\d+\\.", "");

        String[] fichas = movimientos.split("\\s+");
        List<String> listaMovimientos = new ArrayList<>();

        for (String ficha: fichas) {
            // Filtramos cualquier resultado como "1-0", "0-1", "1/2-1/2"
            if (!ficha.matches("1-0|0-1|1/2-1/2")) {
                listaMovimientos.add(ficha);
            }
        }
        return listaMovimientos;
    }

    public static void main(String[] arg) {
        String nombreArchivo = "C:\\Users\\cerpa\\Documents\\Adams.pgn";
        String pgnContenido = leerPgn(nombreArchivo);
        String movimientos = estraerMovimientos(pgnContenido);
        List<String> listaMovimiento = analizarMovimientos(movimientos);

        System.out.println("Movimietos:");
        for (String movimiento: listaMovimiento) {
            System.out.println(movimiento);
        }
    }
}
