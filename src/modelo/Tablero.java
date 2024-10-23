package modelo;

import modelo.Casilla;

public class Tablero {
    private Casilla[][] tablero;


    public Tablero() {
        tablero = new Casilla[8][8];
        iniciarTablero();
    }

    // Iniciamos las fichas en el tablero
    // P: peón, C: caballo, A: alfil, D: dama, R: rey, T: torre

    // Iniciamos la posición inicial de cada ficha
    public void iniciarTablero() {
       for (int i = 0; i < tablero.length; i++) {
           for (int j = 0; j < tablero[i].length; j++) {
                   tablero[i][j] = new Casilla();
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
            tablero[fila][col].setFicha(ficha);
        }
    }

    // Metodo para colocar una fila de peones
    public void colocarFilaPeones(int fila, String color) {
        for ( int col = 0; col < 8; col++) {
            Ficha peon = new Ficha("P", color);
            tablero[fila][col].setFicha(peon);
        }
    }

    public int getFilas() {
        return tablero.length;
    }

    public int getColumnas() {
        return tablero[0].length;
    }

    public Casilla getCasilla (int fila, int columna) {
        return tablero[fila][columna];
    }

}
