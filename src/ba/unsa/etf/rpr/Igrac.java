package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Igrac {
    private String nadimak;
    private double zivotniPoeni;
    private List<Napad> napadi = new ArrayList<>();

    public Igrac(String nadimak) {
        this.nadimak = nadimak;
        this.zivotniPoeni = 100;
    }

    public String getNadimak() {
        return nadimak;
    }

    public void setNadimak(String nadimak) {
        this.nadimak = nadimak;
    }

    public double getZivotniPoeni() {
        return zivotniPoeni;
    }

    public void setZivotniPoeni(double zivotniPoeni) {
        this.zivotniPoeni = zivotniPoeni;
    }

    public List<Napad> getNapadi() {
        return napadi;
    }

    public void setNapadi(List<Napad> napadi) {
        this.napadi = napadi;
    }

    public abstract void napadni(String nazivNapada, Igrac meta) throws IlegalanNapad;
    public abstract void primiNapad(Napad napad);
    public abstract void napadni(String nazivNapada, Igrac meta, double koeficijent) throws IlegalanNapad;
    public abstract void primiNapad(Napad napad, double koeficijent);

    protected Napad dajNapadIzNaziva(String nazivNapada){
        List<Napad>pronadjeno = napadi.stream().filter(napad -> napad.getNazivNapada().equals(nazivNapada))
                .collect(Collectors.toList());
        return pronadjeno.isEmpty() ? null : pronadjeno.get(0);
    }

    public void registrujNapad(Napad napad){
        if(dajNapadIzNaziva(napad.getNazivNapada()) != null){
            throw new IllegalArgumentException("Napad sa ovim nazivom je već registrovan");
        }
        napadi.add(napad);
    }

}
