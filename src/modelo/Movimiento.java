package modelo;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Movimiento {
    private String tipoFicha;
    private String movimiento;

    public Movimiento() {
        // nothing
    }

    // Constructor para buscar el tipo de ficha y guarde su movimiento
    public Movimiento(List<String> movimientos) {
        for (String movimiento : movimientos) {
            Pattern patron = Pattern.compile("([A-Z])(\\w*)");
            Matcher matcher = patron.matcher(movimiento);

            // inicializamos el tipo de ficha como ("P"), ya que el sistema pgn el peon esta vacio
            tipoFicha = "P";

            // Comparar que letra encontró
            while (matcher.find()) {
                tipoFicha = matcher.group(1);
                movimiento = matcher.group(2);

            }
        }
    }
}