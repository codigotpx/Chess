package controlador;


import modelo.*;

public class ControladorJuego {
    private Tablero tablero;

    public ControladorJuego(Tablero tablero) {
        this.tablero = tablero;
        inicialTablero();
    }

    public void inicialTablero() {
        String[] posicionLetra = {"a","b","c","d","e","f","g","h"};
        for (int i = 0; i < tablero.getFilas(); i++) {
            for (int j = 0; j < tablero.getColumnas(i); j++) {
                String posicion = posicionLetra[j] + (8 - i);
                tablero.getCasilla(i, j).setId(posicion);
            }
        }
        String[] piezasIniciales = {"T", "C", "A", "D", "R", "A", "C", "T"};

        colocarFilaConPiezas(0, piezasIniciales, "w");
        colocarFilaPeones(1, "w");

        // Definir la posición de las piezas blancas
        colocarFilaConPiezas(7, piezasIniciales, "b");
        colocarFilaPeones(6, "b");
    }


    public void colocarFilaConPiezas(int fila, String[] piezas, String color) {
        for (int col = 0; col < 8; col++) {
            Ficha ficha;
            switch (piezas[col]) {
                case "T": ficha = new Torre(color); break;
                case "C": ficha = new Caballo(color); break;
                case "A": ficha = new Alfil(color); break;
                case "D": ficha = new Dama(color); break;
                case "R": ficha = new Rey(color); break;
                default: throw new IllegalArgumentException("Pieza desconocida: " + piezas[col]);
            }
            tablero.getCasilla(fila, col).setFicha(ficha); // Asigna la ficha en la posición del tablero
        }
    }

    public void colocarFilaPeones(int fila, String color) {
        for (int col = 0; col < 8; col++) {
            Ficha peon = new Peon(color);
            tablero.getCasilla(fila, col).setFicha(peon);// Asigna el peón en la posición del tablero
        }
    }




}
