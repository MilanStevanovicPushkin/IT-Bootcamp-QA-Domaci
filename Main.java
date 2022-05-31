import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Sastojak s1 = new Sastojak("Jaje", 12.5);
        Sastojak s2 = new Sastojak();
        s2.setNaziv("Mleko");
        s2.setCenaPoJediniciMere(0.15);

        SastojakRecepta sr1 = new SastojakRecepta("Jaja", 13.5, 3.0);
        SastojakRecepta sr2 = new SastojakRecepta(s2,321.5);
        SastojakRecepta sr3 = new SastojakRecepta("Mast", 2.05, 100);
        SastojakRecepta sr4 = new SastojakRecepta("Secer", 1.35, 150);
        SastojakRecepta sr5 = new SastojakRecepta("Brasno", 1.35, 120);

        //System.out.println(s1);
        //System.out.println(s2);
        System.out.println(sr1 + " - Ukupna cena: " + sr1.ukupnaCena());
        System.out.println(sr2 + " - Ukupna cena: " + sr2.ukupnaCena());

        ArrayList<SastojakRecepta> sastojci1 = new ArrayList<>();
        ArrayList<SastojakRecepta> sastojci2 = new ArrayList<>();
        sastojci1.add(sr1);
        sastojci1.add(sr3);
        sastojci1.add(sr5);
        sastojci2.add(sr2);
        sastojci2.add(sr3);
        sastojci2.add(sr4);
        sastojci2.add(sr5);

        Recept r1 = new Recept("Recept 1",  -1, sastojci1);
        Recept r2 = new Recept("Recept 2",  3, sastojci2);
        Recept r3 = new Recept("Recept 3",  100, sastojci2);
        Recept r4 = new Recept("Recept 4",  6, sastojci1);

        System.out.println(r1);
        System.out.println(r1.ukupnaCena());
        System.out.println(r2);
        System.out.println(r2.ukupnaCena());
        System.out.println(r3);
        System.out.println(r3.ukupnaCena());
        System.out.println(r4);
        System.out.println(r4.ukupnaCena());

    }
}
