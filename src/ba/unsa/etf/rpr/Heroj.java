package ba.unsa.etf.rpr;

public class Heroj extends Igrac{
    private double odbrambeniPoeni;

    public Heroj(String nadimak, double odbrambeniPoeni) {
        super(nadimak);
        this.odbrambeniPoeni = odbrambeniPoeni;
    }

    public double getOdbrambeniPoeni() {
        return odbrambeniPoeni;
    }

    public void setOdbrambeniPoeni(double odbrambeniPoeni) {
        this.odbrambeniPoeni = odbrambeniPoeni;
    }

    @Override
    public void napadni(String nazivNapada, Igrac meta) throws IlegalanNapad {

        if(!getNapadi().contains(dajNapadIzNaziva(nazivNapada))) throw new IlegalanNapad(getNadimak() + " ne može izvršiti napad " + nazivNapada);

        if(getZivotniPoeni() == 0) throw new IlegalanNapad("Ovaj igrač je vec završio borbu");

        if(meta instanceof Heroj) throw new IlegalanNapad("Nije moguće izvršiti napad na prijatelja");

        Napad napad = dajNapadIzNaziva(nazivNapada);
        meta.primiNapad(napad);
    }

    @Override
    public void primiNapad(Napad napad) {

        if(getOdbrambeniPoeni() < napad.getDjelovanje()){
            setZivotniPoeni(getZivotniPoeni() - napad.getDjelovanje() + getOdbrambeniPoeni());

            if(getZivotniPoeni() < 0){
                setZivotniPoeni(0);
            }
        }

    }

    @Override
    public void napadni(String nazivNapada, Igrac meta, double koeficijent) throws IlegalanNapad {
        if(!getNapadi().contains(dajNapadIzNaziva(nazivNapada))) throw new IlegalanNapad(getNadimak() + " ne može izvršiti napad " + nazivNapada);

        if(getZivotniPoeni() == 0) throw new IlegalanNapad("Ovaj igrač je vec završio borbu");

        if(meta instanceof Heroj) throw new IlegalanNapad("Nije moguće izvršiti napad na prijatelja");

        Napad napad = dajNapadIzNaziva(nazivNapada);
        meta.primiNapad(napad, koeficijent);
    }

    @Override
    public void primiNapad(Napad napad, double koeficijent) {

        if(getOdbrambeniPoeni() < napad.getDjelovanje()){
            setZivotniPoeni(getZivotniPoeni() - napad.getDjelovanje() * koeficijent + getOdbrambeniPoeni());

            if(getZivotniPoeni() < 0) {
                setZivotniPoeni(0);
            }
        }
    }
}
