package modelo;

public abstract class Ficha {

    private String color; // blanco o negro

    public Ficha(String color) {
        this.color = color; // N: negras, B: blancas
    }

    public String getColor() {
        return color;
    }

    public abstract String gettoString();
    public abstract String getNombre();
}
