package ba.unsa.etf.rpr;

public class Neprijatelj extends Igrac{
    public Neprijatelj(String nadimak) {
        super(nadimak);
    }

    @Override
    public void napadni(String nazivNapada, Igrac meta) throws IlegalanNapad {
        if(!getNapadi().contains(dajNapadIzNaziva(nazivNapada))) throw new IlegalanNapad(getNadimak() + " ne može izvršiti napad " + nazivNapada);

        if(getZivotniPoeni() == 0) throw new IlegalanNapad("Ovaj igrač je vec završio borbu");

        if(meta instanceof Neprijatelj) throw new IlegalanNapad("Nije moguće izvršiti napad na prijatelja");

        Napad napad = dajNapadIzNaziva(nazivNapada);
        meta.primiNapad(napad);
    }

    @Override
    public void primiNapad(Napad napad) {
        setZivotniPoeni(getZivotniPoeni() - napad.getDjelovanje());

        if(getZivotniPoeni() < 0) {
            setZivotniPoeni(0);
        }
    }

    @Override
    public void napadni(String nazivNapada, Igrac meta, double koeficijent) throws IlegalanNapad {
        if(!getNapadi().contains(dajNapadIzNaziva(nazivNapada))) throw new IlegalanNapad(getNadimak() + " ne može izvršiti napad " + nazivNapada);

        if(getZivotniPoeni() == 0) throw new IlegalanNapad("Ovaj igrač je vec završio borbu");

        if(meta instanceof Neprijatelj) throw new IlegalanNapad("Nije moguće izvršiti napad na prijatelja");

        Napad napad = dajNapadIzNaziva(nazivNapada);
        meta.primiNapad(napad, koeficijent);
    }

    @Override
    public void primiNapad(Napad napad, double koeficijent) {
        setZivotniPoeni(getZivotniPoeni() - napad.getDjelovanje() * koeficijent);

        if(getZivotniPoeni() < 0) {
            setZivotniPoeni(0);
        }
    }
}
