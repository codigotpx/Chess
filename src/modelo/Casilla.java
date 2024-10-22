package modelo;

public class Casilla {
    private Ficha ficha;

    public Casilla() {
        this.ficha = null;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }

    public Ficha getFicha() {
        return ficha;
    }

    public boolean estadoOcupado() {
        return this.ficha != null;
    }
}
