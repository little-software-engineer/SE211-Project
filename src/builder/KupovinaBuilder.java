/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builder;

import entiteti.Korisnik;
import entiteti.Kupovina;
import entiteti.ProdajniObjekat;

/**
 *
 * @author PC
 */
public class KupovinaBuilder {

    private Kupovina kupovina;

    public KupovinaBuilder() {
        this.kupovina = new Kupovina();
    }

    public KupovinaBuilder kupovina_id(int kupovina_id) {
        this.kupovina.setKupovina_id(kupovina_id);
        return this;
    }

    public KupovinaBuilder cena(double cena) {
        this.kupovina.setCena(cena);
        return this;
    }

    public KupovinaBuilder naziv(String naziv) {
        this.kupovina.setNazivProizvoda(naziv);
        return this;
    }

    public KupovinaBuilder brojProizvoda(int brojProizvoda) {
        this.kupovina.setBrojProizvoda(brojProizvoda);
        return this;
    }

    public KupovinaBuilder metodPlacanja(String placanje) {
        this.kupovina.setMetodPlacanja(placanje);
        return this;
    }

    public KupovinaBuilder Korisnik(Korisnik korisnik) {
        this.kupovina.setKorisnik(korisnik);
        return this;
    }

    public KupovinaBuilder ProdajniObjekat(ProdajniObjekat objekat) {
        this.kupovina.setPo(objekat);
        return this;
    }

    public Kupovina build() {
        return this.kupovina;
    }
}
