public class SastojakRecepta extends Sastojak{
    private double kolicina;

    public SastojakRecepta(String naziv, double cenaPoJediniciMere, double kolicina) {
        super(naziv, cenaPoJediniciMere);
        this.kolicina = kolicina;
    }
    public SastojakRecepta(Sastojak s, double kolicina) {
        super(s.getNaziv(), s.getCenaPoJediniciMere());
        this.kolicina = kolicina;
    }
    public SastojakRecepta(double kolicina) {
        this.kolicina = kolicina;
    }

    public double getKolicina() {
        return kolicina;
    }

    public void setKolicina(double kolicina) {
        this.kolicina = kolicina;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.getNaziv() + " - ");
        sb.append(super.getCenaPoJediniciMere() + " rsd po jedinici mere - ");
        sb.append("kolicina: " + kolicina);
        sb.append(' ');
        return sb.toString();
    }

    public double ukupnaCena(){
        return kolicina * super.getCenaPoJediniciMere();
    }
}
