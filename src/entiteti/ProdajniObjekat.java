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
public class ProdajniObjekat {

    private int objekat_id;
    private String naziv;
    private String adresa;
    private String grad;
    private int lagerKolicina;

    public ProdajniObjekat() {
    }

    public ProdajniObjekat(int objekat_id, String naziv, String adresa, String grad) {
        this.objekat_id = objekat_id;
        this.naziv = naziv;
        this.adresa = adresa;
        this.grad = grad;
    }

    public ProdajniObjekat(int objekat_id, String naziv, String adresa, String grad, int lagerKolicina) {
        this.objekat_id = objekat_id;
        this.naziv = naziv;
        this.adresa = adresa;
        this.grad = grad;
        this.lagerKolicina = lagerKolicina;

    }

    public ProdajniObjekat(String naziv, String adresa, String grad, int lagerKolicina) {
        this.naziv = naziv;
        this.adresa = adresa;
        this.grad = grad;
        this.lagerKolicina = lagerKolicina;
    }

    public int getLagerKolicina() {
        return lagerKolicina;
    }

    public void setLagerKolicina(int lagerKolicina) {
        this.lagerKolicina = lagerKolicina;
    }

    public int getObjekat_id() {
        return objekat_id;
    }

    public void setObjekat_id(int objekat_id) {
        this.objekat_id = objekat_id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    @Override
    public String toString() {
        return "ProdajniObjekat{" + "objekat_id=" + objekat_id + ", naziv=" + naziv + ", adresa=" + adresa + ", grad=" + grad + ", lagerKolicina=" + lagerKolicina + '}';
    }

}
