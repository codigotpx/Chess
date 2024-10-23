package vista;

import modelo.Casilla;
import modelo.Tablero;

import javax.swing.*;
import java.awt.*;

public class PanelJuego extends JPanel {
    private JPanel panelJuego;
    private Tablero tablero;

    public PanelJuego(Tablero tablero) {
        this.tablero = tablero;
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);

        // Definimos el lado que ocupara el tablero
        int ladoTablero = Math.min(getWidth() / 2, getHeight());
        int tamañoCelda = ladoTablero / tablero.getFilas();

        // Condenadas de la esquina suoerior izquierda del tablero
        int inicioX = 0;
        int inicioY = 0;


        // Dibujamos las celdas del tablero
        for (int i = 0; i < tablero.getFilas(); i++) {
            for (int j = 0; j < tablero.getColumnas(); j++) {
                Casilla casilla = tablero.getCasilla(i,j);
                // Alternar entre el blanco y el negro
                if ((i + j) % 2 == 0) {
                    g.setColor(Color.WHITE);
                } else {
                    g.setColor(Color.BLACK);
                }
                // Dibujamos el rectangulo de la cerla
                g.fillRect(inicioX + j * tamañoCelda, inicioY + i * tamañoCelda, tamañoCelda, tamañoCelda);
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension (500, 800);
    }
}
