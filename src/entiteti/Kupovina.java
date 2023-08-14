/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entiteti;

/**
 *
 * @author PC
 */
public class Kupovina {

    private int kupovina_id;
    private String nazivProizvoda;
    private double cena;
    private int brojProizvoda;
    private String metodPlacanja;

    private ProdajniObjekat po;
    private Korisnik korisnik;

    public Kupovina() {
    }

    public Kupovina(int kupovina_id, String nazivProizvoda, double cena, int brojProizvoda, String metodPlacanja, ProdajniObjekat po, Korisnik korisnik) {
        this.kupovina_id = kupovina_id;
        this.nazivProizvoda = nazivProizvoda;
        this.cena = cena;
        this.brojProizvoda = brojProizvoda;
        this.metodPlacanja = metodPlacanja;
        this.po = po;
        this.korisnik = korisnik;
    }

    public int getKupovina_id() {
        return kupovina_id;
    }

    public void setKupovina_id(int kupovina_id) {
        this.kupovina_id = kupovina_id;
    }

    public String getNazivProizvoda() {
        return nazivProizvoda;
    }

    public void setNazivProizvoda(String nazivProizvoda) {
        this.nazivProizvoda = nazivProizvoda;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public int getBrojProizvoda() {
        return brojProizvoda;
    }

    public void setBrojProizvoda(int brojProizvoda) {
        this.brojProizvoda = brojProizvoda;
    }

    public String getMetodPlacanja() {
        return metodPlacanja;
    }

    public void setMetodPlacanja(String metodPlacanja) {
        this.metodPlacanja = metodPlacanja;
    }

    public ProdajniObjekat getPo() {
        return po;
    }

    public void setPo(ProdajniObjekat po) {
        this.po = po;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    @Override
    public String toString() {
        return "Kupovina{" + "kupovina_id=" + kupovina_id + ", nazivProizvoda=" + nazivProizvoda + ", cena=" + cena + ", brojProizvoda=" + brojProizvoda + ", metodPlacanja=" + metodPlacanja + ", po=" + po + ", korisnik=" + korisnik + '}';
    }

}
