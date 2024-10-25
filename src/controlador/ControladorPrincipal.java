package controlador;

import modelo.Tablero;
import vista.PanelJuego;
import funcionalidades.CargarImagen;

import javax.swing.*;

public class ControladorPrincipal {
    private JFrame marco;

    public ControladorPrincipal(JFrame marco) {
        this.marco = marco;
        iniciarComponentes();
    }

    public void iniciarComponentes() {
        Tablero tablero = new Tablero();
        CargarImagen cargarImagen = new CargarImagen();
        PanelJuego panelJuego = new PanelJuego(tablero, cargarImagen);
        ControladorJuego controladorJuego = new ControladorJuego(tablero);
        marco.setContentPane(panelJuego);
    }
}
