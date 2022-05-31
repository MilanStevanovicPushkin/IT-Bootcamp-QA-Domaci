public class Sastojak {
    private String naziv;
    private double cenaPoJediniciMere;

    public Sastojak(String naziv, double cenaPoJediniciMere) {
        this.naziv = naziv;
        this.cenaPoJediniciMere = cenaPoJediniciMere;
    }

    public Sastojak() {
        this.naziv = "/";
        this.cenaPoJediniciMere = 0;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getCenaPoJediniciMere() {
        return cenaPoJediniciMere;
    }

    public void setCenaPoJediniciMere(double cenaPoJediniciMere) {
        this.cenaPoJediniciMere = cenaPoJediniciMere;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(naziv + " - ");
        sb.append(cenaPoJediniciMere + " rsd po jedinici mere");
        sb.append(' ');
        return sb.toString();
    }
}
