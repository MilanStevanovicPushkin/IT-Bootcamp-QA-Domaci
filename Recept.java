import java.util.ArrayList;

public class Recept {
    private String naziv;
    private int tezina;
    ArrayList<SastojakRecepta> sastojciRecepta = new ArrayList<>();

    public Recept(String naziv, int tezina, ArrayList<SastojakRecepta> sastojciRecepta) {
        this.naziv = naziv;
        this.sastojciRecepta = sastojciRecepta;
        if (tezina<1) this.tezina = 1;
        else if (tezina>5) this.tezina = 5;
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
        this.sastojciRecepta = sastojciRecepta;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(naziv + "\n");
        switch (tezina){
            case 1: sb.append("Tezina: Pocetni nivo \n"); break;
            case 2: sb.append("Tezina: Lak nivo \n"); break;
            case 3: sb.append("Tezina: Srednji nivo \n"); break;
            case 4: sb.append("Tezina: Tezak nivo \n"); break;
            default: sb.append("Tezina: Majstorski nivo \n"); break;
        }
        sb.append("Sastojci: ");
        for (SastojakRecepta sr: sastojciRecepta) sb.append(sr.getNaziv() + ", ");

        return sb.substring(0, sb.length()-2);
    }

    public double ukupnaCena (){
        double ukupno = 0;
        for (SastojakRecepta sr: sastojciRecepta) {
            ukupno += sr.ukupnaCena();
        }
        return ukupno;
    }
}
