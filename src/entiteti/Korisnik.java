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
public class Korisnik {

    private int korisnik_id;
    private String username;
    private String password;
    private String adresa;
    private String bankovni_racun;
    private int tip_korisnika;

    public Korisnik() {
    }

    public Korisnik(int korisnik_id, String username, String password, String bankovni_racun, int tip_korisnika) {
        this.korisnik_id = korisnik_id;
        this.username = username;
        this.password = password;
        this.bankovni_racun = bankovni_racun;
        this.tip_korisnika = tip_korisnika;
    }

    public Korisnik(String username, String password, String bankovni_racun, int tip_korisnika) {
        this.username = username;
        this.password = password;
        this.bankovni_racun = bankovni_racun;
        this.tip_korisnika = tip_korisnika;
    }

    public Korisnik(String username, String password, String bankovni_racun) {
        this.username = username;
        this.password = password;
        this.bankovni_racun = bankovni_racun;
    }

    public Korisnik(int korisnik_id, String username, String password, String bankovni_racun) {
        this.korisnik_id = korisnik_id;
        this.username = username;
        this.password = password;
        this.bankovni_racun = bankovni_racun;
    }

    public Korisnik(String username, String password, String adresa, String bankovni_racun) {
        this.username = username;
        this.password = password;
        this.adresa = adresa;
        this.bankovni_racun = bankovni_racun;
    }

    public Korisnik(int korisnik_id, String username, String password, String adresa, String bankovni_racun) {
        this.korisnik_id = korisnik_id;
        this.username = username;
        this.password = password;
        this.adresa = adresa;
        this.bankovni_racun = bankovni_racun;
    }

    public Korisnik(int korisnik_id, String username, String password, String adresa, String bankovni_racun, int tip_korisnika) {
        this.korisnik_id = korisnik_id;
        this.username = username;
        this.password = password;
        this.adresa = adresa;
        this.bankovni_racun = bankovni_racun;
        this.tip_korisnika = tip_korisnika;
    }

    public Korisnik(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getKorisnik_id() {
        return korisnik_id;
    }

    public void setKorisnik_id(int korisnik_id) {
        this.korisnik_id = korisnik_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBankovni_racun() {
        return bankovni_racun;
    }

    public void setBankovni_racun(String bankovni_racun) {
        this.bankovni_racun = bankovni_racun;
    }

    public int getTip_korisnika() {
        return tip_korisnika;
    }

    public void setTip_korisnika(int tip_korisnika) {
        this.tip_korisnika = tip_korisnika;
    }

    @Override
    public String toString() {
        return "Korisnik{" + "korisnik_id=" + korisnik_id + ", username=" + username + ", password=" + password + ", adresa=" + adresa + ", bankovni_racun=" + bankovni_racun + ", tip_korisnika=" + tip_korisnika + '}';
    }

}
