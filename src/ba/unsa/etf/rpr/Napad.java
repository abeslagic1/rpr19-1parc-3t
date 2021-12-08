package ba.unsa.etf.rpr;

public class Napad {
    private String naziv;
    private double djelovanje;

    public Napad(String naziv, double djelovanje) {
        this.naziv = naziv;
        this.djelovanje = djelovanje;
    }

    public String getNazivNapada() {
        return naziv;
    }

    public void setNazivNapada(String naziv) {
        this.naziv = naziv;
    }

    public double getDjelovanje() {
        return djelovanje;
    }

    public void setDjelovanje(double djelovanje) {
        this.djelovanje = djelovanje;
    }
}
