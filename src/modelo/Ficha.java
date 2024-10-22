package modelo;

public class Ficha {
    private String tipo;
    private String color;

    public Ficha(String tipo, String color) {
        this.tipo = tipo;// P: peón, C: caballo, A: alfil, D: dama, R: rey, T: torre
        this.color = color; // N: negras, B: blancas
    }

    // Insertar la ficha
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    // Obtener la ficha
    public String getTipo() {
        return tipo;
    }
    // Obtener el color de la ficha
    public String getColor() {
        return color;
    }
}
