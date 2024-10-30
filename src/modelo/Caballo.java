package modelo;

public class Caballo extends Ficha {
    public Caballo(String color) {
        super(color);
    }

    @Override
    public String gettoString() {
        return getColor();
    }

    public String getNombre() {
        return "C";
    }

}
