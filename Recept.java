import java.util.ArrayList;

public class Recept {
    private String naziv;
    private int tezina;
    ArrayList<SastojakRecepta> sastojciRecepta;

    public Recept(String naziv, int tezina, ArrayList<SastojakRecepta> sastojciRecepta) {
        this.naziv = naziv;
        this.sastojciRecepta = (ArrayList<SastojakRecepta>) sastojciRecepta.clone();
        if (tezina < 1) this.tezina = 1;
        else if (tezina > 5) this.tezina = 5;
        else this.tezina = tezina;
    }

    public Recept() {
        this.naziv = "/";
        this.tezina = 0;
        this.sastojciRecepta = new ArrayList<SastojakRecepta>();
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getTezina() {
        return tezina;
    }

    public void setTezina(int tezina) {
        this.tezina = tezina;
    }

    public ArrayList<SastojakRecepta> getSastojciRecepta() {
        return sastojciRecepta;
    }

    public void setSastojciRecepta(ArrayList<SastojakRecepta> sastojciRecepta) {
        this.sastojciRecepta = (ArrayList<SastojakRecepta>) sastojciRecepta.clone();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(naziv + "\n");
        switch (tezina) {
            case 1:
                sb.append("Tezina: Pocetni nivo \n");
                break;
            case 2:
                sb.append("Tezina: Lak nivo \n");
                break;
            case 3:
                sb.append("Tezina: Srednji nivo \n");
                break;
            case 4:
                sb.append("Tezina: Tezak nivo \n");
                break;
            default:
                sb.append("Tezina: Majstorski nivo \n");
                break;
        }
        sb.append("Sastojci: ");
        for (SastojakRecepta sr : sastojciRecepta) sb.append(sr.getNaziv() + ", ");

        return sb.substring(0, sb.length() - 2).concat("\n***********\n");
    }
    public String toString(boolean b) {
        final StringBuilder sb = new StringBuilder(naziv + "\n");
        switch (tezina) {
            case 1:
                sb.append("Tezina: Pocetni nivo \n");
                break;
            case 2:
                sb.append("Tezina: Lak nivo \n");
                break;
            case 3:
                sb.append("Tezina: Srednji nivo \n");
                break;
            case 4:
                sb.append("Tezina: Tezak nivo \n");
                break;
            default:
                sb.append("Tezina: Majstorski nivo \n");
                break;
        }
        sb.append("Sastojci: ");
        for (SastojakRecepta sr : sastojciRecepta) sb.append(sr.getNaziv() + " - " + sr.getKolicina() + ", ");

        return sb.substring(0, sb.length() - 2).concat("\n***********\n");
    }

    public double ukupnaCena() {
        double ukupno = 0;
        for (SastojakRecepta sr : sastojciRecepta) {
            ukupno += sr.ukupnaCena();
        }
        return ukupno;
    }

    public Recept skalirajRecept(double procenat){
        Recept R = new Recept(naziv.concat(" - skaliran na ").concat(String.valueOf(procenat)).concat("%"),
                tezina, new ArrayList<SastojakRecepta>());
        for (SastojakRecepta S: sastojciRecepta){
            R.dodajSastojak(new SastojakRecepta(S.getNaziv(), S.getCenaPoJediniciMere(),
                    S.getKolicina()*procenat/100.0));
        }
        return R;
    }

    public void dodajSastojak(SastojakRecepta s) {
        sastojciRecepta.add(s);
    }

    public void ukloniSastojak(SastojakRecepta s) {
        int index = -1;
        for (SastojakRecepta S : sastojciRecepta)
            if (S.getNaziv().equals(s.getNaziv()) && S.getCenaPoJediniciMere() == s.getCenaPoJediniciMere()
                    && S.getKolicina() == s.getKolicina()) {
                index = sastojciRecepta.indexOf(S);
                break;
            }
        if(index>-1) {
            sastojciRecepta.remove(index);
            System.out.println("Obrisan sastojak recepta na indeksu " + index);
        }
    }
    public static ArrayList<Recept> filtrirajRecepte(ArrayList<Recept> recepti, int t){
        ArrayList<Recept> newRecepti = new ArrayList<>();
        for (Recept R: recepti) {
            if (R.tezina==t) newRecepti.add(R);
        }
        return newRecepti;
    }

    public  static ArrayList<Recept> filtrirajRecepte(ArrayList<Recept> recepti, int[] T){
        ArrayList<Recept> newRecepti = new ArrayList<>();
        for (int i = 0; i < T.length; i++) {
            newRecepti.addAll(filtrirajRecepte(recepti, T[i]));
        }
        return newRecepti;
    }
}

