package modelo;


public class Tablero {
    private Casilla[][] tablero;
    private int filas = 8; // Asumiendo un tablero estándar de ajedrez
    private int columnas = 8;


    public Tablero() {
        tablero = new Casilla[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tablero[i][j] = new Casilla(); // Inicializa cada casilla
            }
        }
    }

    // Iniciamos las fichas en el tablero
    // P: peón, C: caballo, A: alfil, D: dama, R: rey, T: t


    public int getFilas() {
        return tablero.length;
    }

    public int getColumnas(int fila) {
        return tablero[fila].length;
    }

    public void setCasilla (int fila, int columna) {
        tablero[fila][columna].setFicha(null);
    }

    public Casilla getCasilla (int fila, int columna) {
        return tablero[fila][columna];
    }

}
