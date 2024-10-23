package controlador;

import modelo.Tablero;
import vista.PanelJuego;

import javax.swing.*;

public class ControladorPrincipal {
    private JFrame marco;

    public ControladorPrincipal(JFrame marco) {
        this.marco = marco;
        iniciarComponentes();
    }

    public void iniciarComponentes() {
        Tablero tablero = new Tablero();
        PanelJuego panelJuego = new PanelJuego(tablero);
        ControladorJuego controladorJuego = new ControladorJuego(tablero);
        marco.setContentPane(panelJuego);
    }
}
