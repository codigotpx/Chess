package modelo;

public class Rey extends Ficha {
    public Rey(String color) {
        super(color);
    }

    @Override
    public String gettoString(){
        return getColor();
    }

    public String getNombre() {
        return "R";
    }
}
