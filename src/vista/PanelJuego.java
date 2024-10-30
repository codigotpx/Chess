package vista;

import funcionalidades.CargarImagen;
import modelo.Casilla;
import modelo.Tablero;

import javax.swing.*;
import java.awt.*;

public class PanelJuego extends JPanel {
    private Tablero tablero;
    private CargarImagen cargarImagen;

    public PanelJuego(Tablero tablero, CargarImagen cargarImagen) {
        this.tablero = tablero;
        this.cargarImagen = cargarImagen;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int tamañoTablero = 400;
        int tamañoCelda = tamañoTablero / tablero.getFilas();

        int inicioX = (getWidth() - tamañoTablero) / 2;
        int inicioY = (getHeight() - tamañoTablero) / 2;

        for (int i = 0; i < tablero.getFilas(); i++) {
            for (int j = 0; j < tablero.getColumnas(i); j++) {
                Casilla casilla = tablero.getCasilla(i, j);

                // Alternar colores de celda
                if ((i + j) % 2 == 0) {
                    g.setColor(new Color(121, 73, 56, 255));
                } else {
                    g.setColor(new Color(93, 50, 49, 255));
                }
                g.fillRect(inicioX + j * tamañoCelda, inicioY + i * tamañoCelda, tamañoCelda, tamañoCelda);

                // Verificar si la casilla tiene una ficha
                if (casilla.hasFicha()) {
                    String tipoFicha = casilla.getFicha().getNombre();
                    String colorFicha = casilla.getFicha().gettoString();

                    // Definimos la ruta de la imagen segun su color
                    String rutaImagen = "/resources/imagenes/" + colorFicha + "/" + tipoFicha + ".png"; // Especificar ruta según el tipo de ficha

                    // Cargar y dibujar la imagen de la ficha
                    Image imagen = cargarImagen.cargarImagen(rutaImagen);
                    if (imagen != null) {
                        int fichaX = inicioX + j * tamañoCelda + tamañoCelda / 8;
                        int fichaY = inicioY + i * tamañoCelda + tamañoCelda / 8;
                        int fichaTamaño = tamañoCelda * 3 / 4;

                        g.drawImage(imagen, fichaX, fichaY, fichaTamaño, fichaTamaño, this);
                    }
                }
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 400);
    }
}
