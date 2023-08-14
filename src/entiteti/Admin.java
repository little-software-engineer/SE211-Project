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
public class Admin extends Korisnik {

    public Admin() {
    }

    public Admin(int korisnik_id, String username, String password, String bankovni_racun, int tip_korisnika) {
        super(korisnik_id, username, password, bankovni_racun, tip_korisnika);
    }

    @Override
    public String toString() {
        return "Admin{" + '}';
    }

}
