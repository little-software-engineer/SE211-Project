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
public class Obican extends Decorator {

    @Override
    public void vrstaDekoracije() {
        System.out.println("Obican- Obicni korisnici imaju mogucnost neometane kupovine proizvoda bez dodatnih pogodnosti.");
    }

}
