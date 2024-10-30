package modelo;

public class Peon extends Ficha {
    public Peon(String color) {
        super(color);
    }

    @Override
    public String gettoString(){
        return getColor();
    }

    public String getNombre() {
        return "P";
    }
}
