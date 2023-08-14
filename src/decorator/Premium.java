/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decorator;

/**
 *
 * @author PC
 */
public class Premium extends Decorator {

    @Override
    public void vrstaDekoracije() {
        System.out.println("Premium- Korisnici koji su tipa premium imaju pogonosti, popuste i mogucnost sakupljanja bodova u odabranim prodajnim objektima zarad specijalnih ponuda.");
    }

}
