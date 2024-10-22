package modelo;

import modelo.Casilla;

public class Tablero {
    private Casilla[][] casillas;

    public Tablero() {
        casillas = new Casilla[8][8];
        iniciarTablero();
    }

    // Iniciamos las fichas en el tablero
    // P: peón, C: caballo, A: alfil, D: dama, R: rey, T: torre

    // Iniciamos la posición inicial de cada ficha
    public void iniciarTablero() {
       for (int i = 0; i < casillas.length; i++) {
           for (int j = 0; j < casillas[i].length; j++) {
                   casillas[i][j] = new Casilla();
           }
       }

        // Colocamos las piezas de las primera fila par ambos colores
        String[] piezasIniciales = {"T", "C", "A", "D", "R", "A", "C", "T"};

        // Definir la posición de las piezas blancas
        colocarFilaConPiezas(0, piezasIniciales, "blanco");
        colocarFilaPeones(0, "blanco");

        // Definir la posición de las piezas blancas
        colocarFilaConPiezas(7, piezasIniciales, "negro");
        colocarFilaPeones(6, "negro");
    }

    // Metodo para colocar la fila de piezas principales
    public void colocarFilaConPiezas(int fila, String[] piezas, String color ) {
        for (int col = 0; col < 8; col++) {
            Ficha ficha = new Ficha(piezas[col], color);
            casillas[fila][col].setFicha(ficha);
        }
    }

    // Metodo para colocar una fila de peones
    public void colocarFilaPeones(int fila, String color) {
        for ( int col = 0; col < 8; col++) {
            Ficha peon = new Ficha("P", color);
            casillas[fila][col].setFicha(peon);
        }
    }
}
