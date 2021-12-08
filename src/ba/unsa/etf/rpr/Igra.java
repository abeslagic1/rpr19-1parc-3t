package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

public class Igra {

    private List<Igrac> igraci = new ArrayList<>();

    public List<Igrac> getIgraci() {
        return igraci;
    }

    public void setIgraci(List<Igrac> igraci) {
        this.igraci = igraci;
    }

    public void registrujIgraca(Igrac igrac){
        if(igraci.contains(igrac)) throw new IllegalArgumentException("Vec je u igri igrac sa ovim nadimkom");
    }

    public void registrujNapadZaIgraca(Napad napad, Igrac igrac) {

    }

    //public List<Igrac> dajIgracePoKriteriju()

    public List<Heroj> dajHeroje() {
    return null;
    }

    public List<Neprijatelj> dajNeprijatelje() {
        return null;
    }

    public List<Heroj> dajPrezivjeleHeroje() {
        return null;
    }

    public List<Neprijatelj> dajPrezivjeleNeprijatelje() {
        return null;
    }

    public Igrac[] dajPrezivjeleIgrace() {
        return null;
    }

    public TreeSet<Igrac> dajIgraceUVodstvu() {
        return null;
    }

    public void izvrsiNapad(Igrac napadac, Igrac meta, Napad napad) throws IlegalanNapad {
        if(napadac.getZivotniPoeni() == 0) throw new IlegalanNapad("Nije moguce napasti sa igracem koji nema preostalih zivornih poena");
        if(napadac.getZivotniPoeni() < 20){
            napadac.napadni(napad.getNazivNapada(), meta, napadac.getZivotniPoeni()/100);
        }
        else napadac.napadni(napad.getNazivNapada(), meta);
    }


    public void izvrsiSerijuNapada(Igrac napadac, HashMap<Igrac, Napad> metaNapad) throws IlegalanNapad{
    }

    public boolean daLiJeMoguceNapasti(Igrac napadac, Igrac meta2, Napad napad) {
        return true;
    }

    public String prikaziStanje() {
        return null;
    }

    public int statusIgre() {
        return 0;
    }

    public void ukloniGubitnike() {
    }

    public void restartuj() {
    }
}
